package com.francislainy.olisaudebt;

import org.springframework.boot.SpringApplication;

public class TestOlisaudeBtApplication {

    public static void main(String[] args) {
        SpringApplication.from(OlisaudeBtApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
