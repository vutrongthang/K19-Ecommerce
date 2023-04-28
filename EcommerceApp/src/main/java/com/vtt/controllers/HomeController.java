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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vutrongthang
 */
@Controller
@Transactional

public class HomeController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
//    @RequestMapping("/")
//    public String index(Model model,
//            @RequestParam(value = "kw", defaultValue = "") String kw) {
//        List<Category> cates = new ArrayList<>();
//        cates.add(new Category(1, "Moblie"));
//        cates.add(new Category(2, "Tablet"));
//        cates.add(new Category(3, "Desktop"));
//
//        List<Products> products = new ArrayList<>();
//        products.add(new Products(1, "Iphone 14 Promax", "https://cdn.tgdd.vn/hoi-dap/1421873/top-6-dien-thoai-man-hinh-full-hd-gia-re-tai-the-gioi-di-1-800x450.jpg", new BigDecimal(34000000)));
//        products.add(new Products(2, "Samsung 14 Promax", "https://cdn.tgdd.vn/hoi-dap/1421873/top-6-dien-thoai-man-hinh-full-hd-gia-re-tai-the-gioi-di-1-800x450.jpg", new BigDecimal(34000000)));
//        products.add(new Products(3, "Iphone 14 Promax", "https://cdn.tgdd.vn/hoi-dap/1421873/top-6-dien-thoai-man-hinh-full-hd-gia-re-tai-the-gioi-di-1-800x450.jpg", new BigDecimal(34000000)));
//        products.add(new Products(4, "Iphone 14 Promax", "https://cdn.tgdd.vn/hoi-dap/1421873/top-6-dien-thoai-man-hinh-full-hd-gia-re-tai-the-gioi-di-1-800x450.jpg", new BigDecimal(34000000)));
//        products.add(new Products(5, "Iphone 14 Promax", "https://cdn.tgdd.vn/hoi-dap/1421873/top-6-dien-thoai-man-hinh-full-hd-gia-re-tai-the-gioi-di-1-800x450.jpg", new BigDecimal(34000000)));
//
//        if (kw != null && !kw.isEmpty()) {
//            products = products.stream().filter(p -> p.getProductName().contains(kw)).collect(Collectors.toList());
//        }
//
//        model.addAttribute("categories", cates);
//        model.addAttribute("products", products);
//        return "index";
//    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        List<Products> products = this.productService.getProducts(params);

        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("products", products);
        return "index";
    }
    @GetMapping("/products/{productId}")
    public String productDetail(Model model, @PathVariable(value = "productId") int id) {
        model.addAttribute("products", this.productService.getProductById(id));
        return "product-detail";
    }
}
