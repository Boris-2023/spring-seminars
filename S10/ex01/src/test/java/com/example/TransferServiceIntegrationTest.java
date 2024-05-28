package com.example;

import com.example.model.Account;
import com.example.repositories.AccountRepository;
import com.example.services.TransferService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransferServiceIntegrationTest {

    @MockBean
    private AccountRepository repo;
    @Autowired
    private TransferService service;

    @Test
    public void moneyTransferCorrectFlow() {

        // precondition
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1000));

        when(repo.findById(1L)).thenReturn(Optional.of(sender)); // describe repo behaviour
        when(repo.findById(2L)).thenReturn(Optional.of(receiver));

        // action
        service.transferMoney(1, 2, new BigDecimal(500L));

        // action result testing
        verify(repo).changeAmount(1, new BigDecimal(500L));
        verify(repo).changeAmount(2, new BigDecimal(1500L));

    }
}
