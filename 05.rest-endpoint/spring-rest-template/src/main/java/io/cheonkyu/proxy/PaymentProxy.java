package io.cheonkyu.proxy;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.cheonkyu.controller.Payment;

@Component
public class PaymentProxy {
  private final RestTemplate rest;

  @Value("${name.service.url}")
  private String paymentsServiceUrl;

  public PaymentProxy(RestTemplate rest) {
    this.rest = rest;
  }

  public Payment createPayment(Payment payment) {
    String uri = paymentsServiceUrl + "/external/payment";

    HttpHeaders headers = new HttpHeaders();
    headers.add("requestId", UUID.randomUUID().toString());

    HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);

    ResponseEntity<Payment> response = rest.exchange(uri, HttpMethod.POST, httpEntity, Payment.class);
    return response.getBody();
  }
}
