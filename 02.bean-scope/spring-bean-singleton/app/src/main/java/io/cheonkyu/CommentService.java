package io.cheonkyu;

import org.springframework.stereotype.Service;

@Service
public class CommentService {
  private CommentRepository commentRepository;

  public CommentService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public CommentRepository getCommentRepository() {
    return commentRepository;
  }
}
