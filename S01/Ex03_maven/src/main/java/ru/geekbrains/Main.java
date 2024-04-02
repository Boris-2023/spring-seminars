package ru.geekbrains;

import com.google.common.base.Joiner;

public class Main {
    public static void main(String[] args) {

        String[] words = {"Hello", "world!"};
        String msg = Joiner.on(", ").join(words);
        System.out.println(msg);

    }
}