/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.controllers;

import com.vtt.pojo.Cart;
import com.vtt.pojo.Category;
import com.vtt.pojo.Products;
import com.vtt.pojo.Users;
import com.vtt.service.CategoryService;
import com.vtt.service.ProductService;
import com.vtt.service.UserService;
import com.vtt.utils.Utils;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private UserService userDetailsService;

    @ModelAttribute
    public void commonAttributes(Model model, HttpSession session) {
        List<Category> cates = this.categoryService.getCategories();
        model.addAttribute("categories", cates);
        model.addAttribute("cartStats", Utils.cartStats((Map<Integer, Cart>) session.getAttribute("cart")));
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

    @GetMapping("/cart")
    public String cart(HttpSession session, Model model) {
        model.addAttribute("cart", (Map<Integer, Cart>) session.getAttribute("cart"));
        return "cart";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new Users());

        return "register";
    }

    @PostMapping("/register")
    public String addUser(Model model, @ModelAttribute(value = "user") Users user) {
        String errMsg = "";
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (this.userDetailsService.addUser(user)) {
                return "redirect:/login";
            } else {
                errMsg = "He thong dang co loi! Vui long quay lai sau!";
            }
        } else {
            errMsg = "Mat khau KHONG khop!";
        }

        model.addAttribute("errMsg", errMsg);
        return "register";
    }
}
