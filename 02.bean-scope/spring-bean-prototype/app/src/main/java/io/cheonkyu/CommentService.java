package io.cheonkyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CommentService {
  @Autowired
  private ApplicationContext context;

  // CommentService가 싱글톤이기 때문에 CommentProcessor가 프로토타입이여서 한번만 생성되서 동일함
  @Autowired
  private CommentProcessor p;

  public void sendComment() {
    // 메서드 호출될 때마다 새로운 빈으로 주입됨
    CommentProcessor p1 = context.getBean(CommentProcessor.class);
    System.out.println("p, 싱글톤 빈 생성 시, 한번만 생성된 빈 : " + p);
    System.out.println("p1, 메소드 호출 마다 다른 빈이 생성됨 프로토타입 " + p1);
    System.out.println("p == p1 비교 : " + (p1 == p));

    System.out.println("p.commentRepository, p1.repository 비교");
    System.out.println("commentRepository는 싱글톤 빈이기에 서로 같은 인스턴스임");
    System.out.println(p1.getCommentRepository() == p.getCommentRepository());
  }
}
