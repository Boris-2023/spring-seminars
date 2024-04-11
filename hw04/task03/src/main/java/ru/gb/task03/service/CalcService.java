package ru.gb.task03.service;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class CalcService {

    private long value1 = 10L;
    private long value2 = 10L;
    private String operator = "+";

    public Long getResult() {
        long result;

        switch (getOperator()) {
            case "+" -> result = getValue1() + getValue2();
            case "-" -> result = getValue1() - getValue2();
            case "*" -> result = getValue1() * getValue2();
            case "/" -> result = getValue1() / getValue2();
            default -> {
                System.out.println("Unknown operator!");
                result = 0L;
            }
        }
        return result;
    }

}
