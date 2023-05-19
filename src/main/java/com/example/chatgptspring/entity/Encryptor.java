package com.example.chatgptspring.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Encryptor {

    private String[] symbols;
    private Integer[] digits;

    public Encryptor() {
        this.symbols = fillLetters();
        this.digits = fillNumbers();
    }

    public Integer[] encrypt(String password) {
        List<String> passwordArrL = List.of(password.split(""));
        List<Integer> list = new ArrayList<>();
        passwordArrL.stream()
                .flatMap(s -> Arrays.stream(symbols)
                        .filter(s::equals)
                        .map(symb -> (int) digits[Arrays.asList(symbols).indexOf(symb)]))
                .forEach(list::add);
        return list.toArray(new Integer[0]);
    }

    private String[] decrypted(Integer[] passwordForDecrypted) {
        String[] passwordArray = new String[passwordForDecrypted.length];
        IntStream.range(0, passwordForDecrypted.length)
                .forEach(i -> IntStream.range(0, this.digits.length)
                        .filter(j -> Objects.equals(passwordForDecrypted[i], this.digits[j]))
                        .findFirst()
                        .ifPresent(j -> passwordArray[i] = String.valueOf(this.symbols[j])));
        return passwordArray;
    }

    public String decryptPassword(Integer[] passwordForDecrypted) {
        String[] arr = decrypted(passwordForDecrypted);
        StringBuilder pass = new StringBuilder();
        for (String s : arr) {
            pass.append(s);
        }
        return String.valueOf(pass);
    }

    private String[] fillLetters() {
        String[] arr = new String[62];
        int index = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            arr[index] = String.valueOf(i);
            index++;
        }
        for (char i = 'a'; i <= 'z'; i++) {
            arr[index] = String.valueOf(i);
            index++;
        }
        for (int i = 0; i < 10; i++) {
            arr[index] = Integer.toString(i);
            index++;
        }
        return arr;
    }

    private Integer[] fillNumbers() {
        Integer[] arr = new Integer[62];
        int index = 0;
        for (int i = 265; i < (arr.length + 265); i++) {
            arr[index] = i;
            index++;
        }
        return arr;
    }
}
