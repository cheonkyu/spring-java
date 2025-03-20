package io.cheonkyu.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import io.cheonkyu.controller.Payment;

@FeignClient(name = "payment", url = "${name.service.url}")
public interface PaymentProxy {
  @PostMapping("/external/payment")
  public Payment createPayment(@RequestHeader String requestId, @RequestBody Payment payment);
}