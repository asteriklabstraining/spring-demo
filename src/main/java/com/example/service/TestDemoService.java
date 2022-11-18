package com.example.service;

public class TestDemoService {

    public int add(int a, int b){
        return a + b;
    }

    public int multiply(int a , int b){
        return a * b;
    }

    //it takes two parameter and the subtracts second from the first one and then adds 15
    public int calculate(int a, int b){
        int additionValue = 15;
        return (a-b)+additionValue;
    }
}
