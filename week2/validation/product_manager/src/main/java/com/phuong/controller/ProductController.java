package com.phuong.controller;

import com.phuong.model.Category;
import com.phuong.model.Product;
import com.phuong.dto.ProductDto;
import com.phuong.service.IProductService;
import com.phuong.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/home")
    public String goHome(Model model, @PageableDefault(value = 3) Pageable pageable, @RequestParam Optional<String> searchParam) {
        String searchValue = searchParam.orElse("");
        Page<Product> products = productService.findAll(pageable, searchValue);
        model.addAttribute("products", products);
        model.addAttribute("searchValue", searchValue);
        return "home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        this.productService.remove(id);
        return "redirect:/product/home";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("productDto", new ProductDto());
        List<Category> categories = this.categoryService.findAll();
        model.addAttribute("categories", categories);
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("productDto") ProductDto productDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Category> categories = this.categoryService.findAll();
            model.addAttribute("categories", categories);
            return "create";
        }
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasErrors()) {
            List<Category> categories = this.categoryService.findAll();
            model.addAttribute("categories", categories);
            return "create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        this.productService.save(product);
        return "redirect:/product/home";
    }

    @GetMapping("/edit/{id}")
    public String goEdit(Model model, @PathVariable Integer id) {
        Product product = this.productService.getById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        model.addAttribute("productDto", productDto);
        List<Category> categories = this.categoryService.findAll();
        model.addAttribute("categories", categories);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute ProductDto productDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Category> categories = this.categoryService.findAll();
            model.addAttribute("categories", categories);
            return "edit";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        this.productService.save(product);
        return "redirect:/product/home";
    }
}
