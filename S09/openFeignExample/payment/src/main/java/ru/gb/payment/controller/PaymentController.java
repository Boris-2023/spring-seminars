package ru.gb.payment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.payment.model.Payment;

import java.util.UUID;

@RestController
@RequestMapping
public class PaymentController {
    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(@RequestHeader String requestId, @RequestBody Payment payment) {
        payment.setId(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.OK).header("requestId", requestId).body(payment);
    }
}
