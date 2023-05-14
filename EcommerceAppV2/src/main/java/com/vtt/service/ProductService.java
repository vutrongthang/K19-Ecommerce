/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtt.service;

import com.vtt.pojo.Cart;
import com.vtt.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface ProductService {
    List<Product> getProducts(Map<String, String> params);
    Product getProductById(int id);
    boolean addOrUpdateProduct(Product p);
    boolean deleteProduct(int id);
    boolean addReceipt(Map<String, Cart> cart);
}
