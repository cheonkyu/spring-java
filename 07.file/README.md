# 07.file

## 파이프라인 패턴 (책임 연쇄 패턴)

```java
// handler 인터페이스
@FunctionalInterface
public interface Handler<I, O> {
    O process(I input);
}
```

```java
// 핸들러 체인 연결을 위한 파이프라인
public class Pipeline<I, O> {

    private final Handler<I, O> currentHandler;

    public Pipeline(Handler<I, O> currentHandler) {
        this.currentHandler = currentHandler;
    }

    <K> Pipeline<I, K> addHandler(Handler<O, K> newHandler) {
        return new Pipeline<>(input -> newHandler.process(currentHandler.process(input)));
    }

    O execute(I input) {
        return currentHandler.process(input);
    }
}
```

https://velog.io/@e1psycongr00/책임-연쇄-패턴
