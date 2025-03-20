package io.cheonkyu.services;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import io.cheonkyu.aop.ToLog;

@Service
public class CommentService {
  Logger logger = Logger.getLogger(CommentService.class.getName());

  @ToLog
  public String publishComment(Comment comment) {
    logger.info("execute publishComment Method");
    return comment.toString();
  }
}
