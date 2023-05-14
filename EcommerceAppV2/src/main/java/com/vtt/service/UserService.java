/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtt.service;

import com.vtt.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author vutrongthang
 */
public interface UserService extends UserDetailsService{
    User getUserByUsername(String username);
}
