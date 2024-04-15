package ru.boris.ex01.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boris.ex01.exception.AccountNotFoundException;
import ru.boris.ex01.model.Account;
import ru.boris.ex01.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class TransferService {
    private final AccountRepository accountRepository; // auto realization by Spring !!!

    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findById(idSender)
                .orElseThrow(AccountNotFoundException::new);

        Account receiver = accountRepository.findById(idReceiver)
                .orElseThrow(AccountNotFoundException::new);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public List<Account> findAccountByName(String name){
        return accountRepository.findAccountByName(name);
    }
}
