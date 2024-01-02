package com.example.data.thuchanhhiohang.controller;

import com.example.data.thuchanhhiohang.model.Cart;
import com.example.data.thuchanhhiohang.model.Product;
import com.example.data.thuchanhhiohang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @ModelAttribute("cart")
    public Cart cart(){
        return new Cart();
    }
    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", iProductService.findAll());
        return modelAndView;
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (productOptional.isEmpty()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/remove/{id}")
    public String removeCart(@PathVariable Integer id,
                            @ModelAttribute Cart cart) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (productOptional.isEmpty()) {
            return "/error_404";
        }

        cart.removeProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }
    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable Integer id, Model model) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (productOptional.isEmpty()) {
            return "/error_404";
        }
        model.addAttribute("product",productOptional.get());
        return "/view";
    }


}


