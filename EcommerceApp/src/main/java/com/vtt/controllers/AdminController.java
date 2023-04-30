/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.controllers;

import com.vtt.pojo.Products;
import com.vtt.service.ProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vutrongthang
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;
    
    @ModelAttribute
    public void commonAttributes(Model model){
        model.addAttribute("products", this.productService.getProducts(null));        
    }
    
    @GetMapping("/product")
    public String product(Model model){
        model.addAttribute("product", new Products());
        return "product";
    }
    @GetMapping("/product/{productId}")
    public String updateProduct(Model model, @PathVariable(value = "productId") int id) {
        model.addAttribute("product", this.productService.getProductById(id));
        return "product";
    }
    @RequestMapping("/product")
    public String addProduct(Model model, 
            @ModelAttribute(value = "product") @Valid Products p,
            BindingResult rs) {
        if (rs.hasErrors())
            return "product";
        if (this.productService.addOrUpdateProduct(p) == true)
            return "redirect:/admin/product";
        else
            model.addAttribute("errMsg", "Something Wrong!!!");
        
        return "product";
    }
}