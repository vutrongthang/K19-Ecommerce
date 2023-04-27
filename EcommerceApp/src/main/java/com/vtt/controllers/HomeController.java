/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.controllers;

import com.vtt.pojo.Category;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vutrongthang
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        List<Category> cates = new ArrayList<>();
        cates.add(new Category(1, "Moblie"));
        cates.add(new Category(2, "Tablet"));
        cates.add(new Category(3, "Desktop"));

        model.addAttribute("categories", cates);
        return "index";
    }
}
