package br.com.erudio.migrationswithflyway.erudio.controllers;

import br.com.erudio.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class GreetingController {

    private static final String tamplate = "Helo, %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting GreetingController(@RequestParam(value = "name", defaultValue = "Hello World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(tamplate, name));
    }
}
