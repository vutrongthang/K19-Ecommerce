/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.controllers;

import com.vtt.pojo.Cart;
import com.vtt.pojo.Category;
import com.vtt.pojo.Product;
import com.vtt.service.CategoryService;
import com.vtt.service.ProductService;
import com.vtt.utils.Utils;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vutrongthang
 */
@Controller
@ControllerAdvice
public class HomeController {
      @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    
    @ModelAttribute
    public void commonAttributes(Model model, HttpSession session) {
        List<Category> cates = this.categoryService.getCategories(); 
        model.addAttribute("categories", cates);
        model.addAttribute("cartStats", Utils.cartStats((Map<Integer, Cart>) session.getAttribute("cart")));
    }
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        List<Product> products = this.productService.getProducts(params);
       
        model.addAttribute("products", products);
        return "index";
    }
    
    @GetMapping("/products/{productId}")
    public String productDetail(Model model, @PathVariable(value = "productId") int id) {
        model.addAttribute("product", this.productService.getProductById(id));
        return "product-detail";
    }
    
    @GetMapping("/cart")
    public String cart(HttpSession session, Model model) {
        model.addAttribute("cart", (Map<Integer, Cart>) session.getAttribute("cart"));
        return "cart";
    }
    
    @GetMapping("/login")
    public String loginView() {
        return "login";
    }
}
