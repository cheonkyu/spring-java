package io.cheonkyu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Customer(
    @JsonProperty("customer_id") int customerId,
    @JsonProperty("name") String name,
    @JsonProperty("status") String status) {
}
