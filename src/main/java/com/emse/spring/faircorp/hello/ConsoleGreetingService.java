package com.emse.spring.faircorp.hello;

import org.springframework.stereotype.Service;

@Service
public class ConsoleGreetingService implements GreetingService {

    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

}
