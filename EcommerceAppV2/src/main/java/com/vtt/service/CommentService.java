/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtt.service;

import com.vtt.pojo.Comment;
import java.util.List;

/**
 *
 * @author admin
 */
public interface CommentService {
    List<Comment> getComments(int productId);
    boolean addComment(Comment c);
}
