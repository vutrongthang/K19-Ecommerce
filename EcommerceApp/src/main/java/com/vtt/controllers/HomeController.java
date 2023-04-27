/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.controllers;

import com.vtt.pojo.Category;
import com.vtt.pojo.Products;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vutrongthang
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model,
            @RequestParam(value = "kw", defaultValue = "") String kw) {
        List<Category> cates = new ArrayList<>();
        cates.add(new Category(1, "Moblie"));
        cates.add(new Category(2, "Tablet"));
        cates.add(new Category(3, "Desktop"));

        List<Products> products = new ArrayList<>();
        products.add(new Products(1, "Iphone 14 Promax", "https://cdn.tgdd.vn/hoi-dap/1421873/top-6-dien-thoai-man-hinh-full-hd-gia-re-tai-the-gioi-di-1-800x450.jpg", new BigDecimal(34000000)));
        products.add(new Products(2, "Samsung 14 Promax", "https://cdn.tgdd.vn/hoi-dap/1421873/top-6-dien-thoai-man-hinh-full-hd-gia-re-tai-the-gioi-di-1-800x450.jpg", new BigDecimal(34000000)));
        products.add(new Products(3, "Iphone 14 Promax", "https://cdn.tgdd.vn/hoi-dap/1421873/top-6-dien-thoai-man-hinh-full-hd-gia-re-tai-the-gioi-di-1-800x450.jpg", new BigDecimal(34000000)));
        products.add(new Products(4, "Iphone 14 Promax", "https://cdn.tgdd.vn/hoi-dap/1421873/top-6-dien-thoai-man-hinh-full-hd-gia-re-tai-the-gioi-di-1-800x450.jpg", new BigDecimal(34000000)));
        products.add(new Products(5, "Iphone 14 Promax", "https://cdn.tgdd.vn/hoi-dap/1421873/top-6-dien-thoai-man-hinh-full-hd-gia-re-tai-the-gioi-di-1-800x450.jpg", new BigDecimal(34000000)));
        
        if (kw !=null && !kw.isEmpty())
            products = products.stream().filter(p -> p.getProductName().contains(kw)).collect(Collectors.toList());
        
        model.addAttribute("categories", cates);
        model.addAttribute("products", products);
        return "index";

    }
}
