package com.example.myweb.common;

public class LogAdvice {
    public void printLog() {
    	System.out.println(">>> [공통 작업] 비즈니스 로직 수행 전에 동작합니다.");
    }
    
    public void printLog2() {
    	System.out.println(">>> [공통 작업] 비즈니스 로직 수행 후에 동작합니다.");
}
}
