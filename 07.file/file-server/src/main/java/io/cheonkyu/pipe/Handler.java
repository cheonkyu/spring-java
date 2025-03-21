package io.cheonkyu.pipe;

@FunctionalInterface
public interface Handler<I, O> {
  O process(I input);
}