/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtt.repository;

import com.vtt.pojo.Users;

/**
 *
 * @author vutrongthang
 */
public interface UserRepository {
    Users getUserByUsername(String username);
}
