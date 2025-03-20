package io.cheonkyu.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import io.cheonkyu.Comment;

@Service
public class CommentService {
  private Logger logger = Logger.getLogger(CommentService.class.getName());

  public String publishComment(Comment comment) {
    logger.info("publish comment: " + comment.getText());
    return comment.getText();
  }
}
