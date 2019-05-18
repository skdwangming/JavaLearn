package com.dx.spring.beans.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        // 1:创建Spring的IOC容器；
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
        // 2.从IOC容器中获取Bean的实例
        IArithmeticCalculator arithmeticCalculator = (IArithmeticCalculator) ctx.getBean("arithmeticCalculator");
        // 3.使用Bean


    }
}