/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.controllers;

import com.vtt.pojo.Category;
import com.vtt.pojo.Products;
import com.vtt.service.CategoryService;
import com.vtt.service.ProductService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional
@ControllerAdvice
public class HomeController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @ModelAttribute
    public void commonAttributes(Model model) {
        List<Category> cates = this.categoryService.getCategories();
        model.addAttribute("categories", cates);

    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        List<Products> products = this.productService.getProducts(params);
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/products/{productId}")
    public String productDetail(Model model, @PathVariable(value = "productId") int id) {
        model.addAttribute("products", this.productService.getProductById(id));
        return "product-detail";
    }
}
