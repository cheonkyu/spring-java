package io.cheonkyu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var cs1 = context.getBean("commentService", CommentService.class);
        var cs2 = context.getBean("commentService", CommentService.class);

        System.out.println("싱글톤이기에 cs1, cs2가 동일한 인스턴스로 반환되어 무조건 true");
        System.out.println(cs1 == cs2);

        var u = context.getBean("userService", UserService.class);
        System.out.println("싱글톤이기에 commenctRepository 동일한 인스턴스로 반환되어 무조건 true");
        System.out.println(u.getCommentRepository() == cs1.getCommentRepository());
    }
}
