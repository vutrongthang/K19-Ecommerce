/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.controllers;

import com.vtt.pojo.Products;
import com.vtt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    @GetMapping("/product")
    public String product(Model model){
        model.addAttribute("product", new Products());
        return "product";
    }
    @RequestMapping("/product")
    public String addProduct(Model model, 
            @ModelAttribute(value = "product") Products p) {
        if (this.productService.addOrUpdateProduct(p) == true)
            return "redirect:/";
        else
            model.addAttribute("errMsg", "Something Wrong!!!");
        
        return "product";
    }
}