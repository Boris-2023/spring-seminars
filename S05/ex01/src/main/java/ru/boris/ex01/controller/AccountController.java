package ru.boris.ex01.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.boris.ex01.dto.TransferRequest;
import ru.boris.ex01.model.Account;
import ru.boris.ex01.service.TransferService;

@RestController
@AllArgsConstructor
public class AccountController {

    private final TransferService transferService;

    @GetMapping("/accounts")
    public Iterable<Account> getAccounts(@RequestParam(required = false) String name) {
        if (name == null) return transferService.getAllAccounts();

        return transferService.findAccountByName(name);
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest transferRequest) {
        transferService.transferMoney(transferRequest.getSenderAccountId(),
                transferRequest.getReceiverAccountId(), transferRequest.getAmount());
    }

}
