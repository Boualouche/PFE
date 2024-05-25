package com.campify.reservationservice.controller;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @PostMapping("/create-checkout-session")
    public ResponseEntity<String> createCheckoutSession(@RequestBody Map<String, Object> reservationInfo) {
        Stripe.apiKey = stripeApiKey;

        Integer totalAmount = (Integer) reservationInfo.get("amount");

        SessionCreateParams createParams = new SessionCreateParams.Builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:5173/success") // Redirect URL after successful payment
                .setCancelUrl("http://localhost:5173/cancel") // Redirect URL if payment is canceled
                .addLineItem(new SessionCreateParams.LineItem.Builder()
                        .setQuantity(1L)
                        .setPriceData(new SessionCreateParams.LineItem.PriceData.Builder()
                                .setCurrency("usd")
                                .setUnitAmount((long) (totalAmount * 100)) // Convert total amount to cents
                                .setProductData(new SessionCreateParams.LineItem.PriceData.ProductData.Builder()
                                        .setName("Reservation")
                                        .build())
                                .build())
                        .build())
                .build();

        try {
            Session session = Session.create(createParams);
            return ResponseEntity.ok(session.getId());
        } catch (StripeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}