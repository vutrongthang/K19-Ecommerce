/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.formatter;

import com.vtt.pojo.Category;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author vutrongthang
 */
public class CategoryFormatter implements Formatter<Category>{

     @Override
    public String print(Category cate, Locale locale) {
        return String.valueOf(cate.getCategoryID());
    }

    @Override
    public Category parse(String cateId, Locale locale) throws ParseException {
        Category c = new Category();
        c.setCategoryID(Integer.parseInt(cateId));
        
        return c;
    }
    
}
