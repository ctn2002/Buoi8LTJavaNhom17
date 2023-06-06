package com.example.buoi7.controller;

import com.example.buoi7.model.Category;
import com.example.buoi7.model.Product;
import com.example.buoi7.service.CategoryService;
import com.example.buoi7.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listproduct", productService.GetAll());
        return "products/index";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") int id, Model model) {
        Product product = productService.get(id);
        model.addAttribute("product", product);
        return "products/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("product") Product product, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("product", product);
            return "products/edit";
        }
        productService.save(product);
        return "redirect:/products";
    }

}
