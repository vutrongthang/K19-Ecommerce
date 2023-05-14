/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtt.service.impl;

import com.vtt.pojo.Comment;
import com.vtt.repository.CommentRepository;
import com.vtt.service.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vutrongthang
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepo;

    @Override
    public List<Comment> getComments(int productId) {
        return this.commentRepo.getComments(productId);
    }

    @Override
    public boolean addComment(Comment c) {
        return this.commentRepo.addComment(c);
    }
    
}
