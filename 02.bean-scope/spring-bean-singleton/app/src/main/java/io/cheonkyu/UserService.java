package io.cheonkyu;

import org.springframework.stereotype.Service;

@Service
public class UserService {
  private CommentRepository commentRepository;

  public UserService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public CommentRepository getCommentRepository() {
    return commentRepository;
  }
}
