package com.aggregator.microservice.ecommerceaggregator.service;

import com.aggregator.microservice.ecommerceaggregator.model.AggregatedData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@RequiredArgsConstructor
public class AggregatorService {

    private final RestTemplate restTemplate;

    private static final String ORDER_SERVICE_URL = "http://localhost:8088/v1/order-service";
    private static final String PAYMENT_SERVICE_URL = "http://localhost:8087/v1/payment-service";

    public AggregatedData getAggregateData(Long orderId) {

        var order = restTemplate.getForObject(ORDER_SERVICE_URL + "/order/" + orderId, AggregatedData.Order.class);
        var payment = restTemplate.getForObject(PAYMENT_SERVICE_URL + "/order/" + orderId, AggregatedData.Payment.class);

        return new AggregatedData(order, payment);

    }

}
