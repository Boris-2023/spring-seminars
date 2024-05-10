package ru.gb.openFeign.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.openFeign.model.Payment;
import ru.gb.openFeign.proxy.PaymentProxy;

@RestController
@AllArgsConstructor
public class PaymentController {
    private final PaymentProxy proxy;

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment){
        String id = "1";
        return proxy.createPayment(id, payment);
    }
}
