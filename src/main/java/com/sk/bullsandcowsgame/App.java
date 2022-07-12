/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.bullsandcowsgame;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author SHIVALI
 */
@ExtendWith(SpringExtension.class)
@SpringBootApplication
public class App  {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
}

    
}