package com.example.data.controller;

import com.example.data.model.Product;
import com.example.data.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    public IProductService productService;
    @ModelAttribute("product")
    public Product product(){
        return new Product();
    }

    @RequestMapping
    public ModelAndView listProduct(){
        List<Product> list = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("list",list);
//        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @GetMapping("/deleteProduct")
    public String handleDelete(@RequestParam("id") Integer id){
        System.out.println(id);
        productService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/addProduct")
    public String handleAddProduct( Product product, RedirectAttributes redirectAttributes){
//        Product product = new Product(id,name,price,description,producer);
        productService.save(product);

        return "redirect:/";
    }

    @PostMapping("/update")
    public String handleUpdate(
            @RequestParam("idEdit") int id,
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("description") String description,
            @RequestParam("producer") String producer) {


        Product product = productService.findById(id);
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setProducer(producer);
        productService.save(product);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            return "redirect:/";
    }

    @GetMapping("{id}/detail")
    public String viewProduct(@PathVariable int id, Model model){

        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "/detail";
    }
    @PostMapping("/search")
    public String searchProduct(@RequestParam String search, Model model){
        List<Product> list = productService.searchByName(search);

        model.addAttribute("list",list);
        return "/home";
    }

}

