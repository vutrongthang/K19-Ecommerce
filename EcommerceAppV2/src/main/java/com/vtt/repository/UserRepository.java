/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.repository;

import com.vtt.pojo.User;

/**
 *
 * @author vutrongthang
 */
public interface UserRepository {
    User getUserByUsername(String username);
}
