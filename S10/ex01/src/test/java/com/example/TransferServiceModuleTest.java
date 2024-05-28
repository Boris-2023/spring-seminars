package com.example;

import com.example.exceptions.AccountNotFoundException;
import com.example.model.Account;
import com.example.repositories.AccountRepository;
import com.example.services.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TransferServiceModuleTest {

    @Mock
    private AccountRepository repo;
    @InjectMocks
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

        given(repo.findById(1L)).willReturn(Optional.of(sender)); // describe repo behaviour
        given(repo.findById(2L)).willReturn(Optional.of(receiver));

        // action
        service.transferMoney(1, 2, new BigDecimal(500L));

        // result check
        verify(repo).changeAmount(1, new BigDecimal(500L));
        verify(repo).changeAmount(2, new BigDecimal(1500L));

    }

    @Test
    public void moneyTransferAccountNotFoundTest() {
        // precondition
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        given(repo.findById(1L)).willReturn(Optional.of(sender)); // describe repo behaviour
        given(repo.findById(2L)).willReturn(Optional.empty());

        // action
        assertThrows(AccountNotFoundException.class, () -> {
            service.transferMoney(1, 2, new BigDecimal(500L));
        });

        // action result testing
        verify(repo, never()).changeAmount(anyLong(), any());
    }
}
