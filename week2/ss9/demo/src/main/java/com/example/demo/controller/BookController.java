package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.BookRenting;
import com.example.demo.service.IBookRentingService;
import com.example.demo.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Random;

@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBookRentingService iBookRentingService;


    @ModelAttribute("bookReturn")
    public BookRenting bookRenting(){
        return new BookRenting();
    }

    @RequestMapping("")
    public ModelAndView findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                @RequestParam(value = "size", defaultValue = "3") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> list = iBookService.findAll(pageable);
        return new ModelAndView("/home", "list", list);
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetailBook(@PathVariable("id") Integer id) {
        Book book = iBookService.findById(id);
        return new ModelAndView("/formDetail", "book", book);
    }

    @GetMapping("/renting/{id}")
    public String  rentingHandle(@PathVariable("id") Integer id , Model model) {
        Book book = iBookService.findById(id);
        Integer randomNumber;
        LocalDateTime startRenting;

        if (book.getQuantity() >= 1){
            Random random = new Random();

             randomNumber = random.nextInt(99999) + 1;
            startRenting = LocalDateTime.now();
            BookRenting bookRenting = new BookRenting(randomNumber,false,startRenting,book);
            iBookRentingService.save(bookRenting);

            book.setQuantity(book.getQuantity() - 1);
            iBookService.save(book);
        } else {
            System.out.println("qua roi");
            model.addAttribute("book",book);
            model.addAttribute("eroo","het sach roi cha noi");
            return "/formDetail";
        }
        return "redirect:/";
    }
    @GetMapping("/returnBook")
    public String returnBookHandle(@RequestParam("idRenting") Integer idRenting){
        System.out.println(idRenting + "-----------------------------------------------------------------------");
        BookRenting bookRenting1 = iBookRentingService.findBookRentingByIdRenting(idRenting);

        if(bookRenting1 != null){
           Book book = iBookService.findById(bookRenting1.getBook().getId());
           LocalDateTime localDateTime = LocalDateTime.now();
           book.setQuantity(book.getQuantity() + 1);

           bookRenting1.setCheckRenting(true);
           bookRenting1.setEndRenting(localDateTime);
           iBookService.save(book);
           iBookRentingService.save(bookRenting1);
        } else {
            System.out.println("loi roi alo");
            return "redirect:/";
        }


        return "redirect:/";
    }


}
