package io.cheonkyu.controller;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.cheonkyu.proxy.PaymentProxy;

@RestController
public class PaymentController {
  private final Logger logger = Logger.getLogger(PaymentController.class.getName());
  private final PaymentProxy paymentProxy;

  PaymentController(PaymentProxy paymentProxy) {
    this.paymentProxy = paymentProxy;
  }

  @PostMapping("/payment")
  public ResponseEntity<?> postPayment(@RequestBody Payment payment) {
    String requestId = UUID.randomUUID().toString();
    logger.info("/payment : " + requestId + payment);
    return ResponseEntity.ok(paymentProxy.createPayment(requestId, payment));
  }

  @PostMapping("/external/payment")
  public ResponseEntity<?> postExternalPayment(@RequestHeader String requestId, @RequestBody Payment payment) {
    logger.info("/external/payment : " + requestId + payment);
    return ResponseEntity.ok(payment);
  }
}
