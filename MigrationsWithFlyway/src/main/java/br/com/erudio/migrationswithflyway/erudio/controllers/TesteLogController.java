package br.com.erudio.migrationswithflyway.erudio.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteLogController {

    private final Logger logger = LoggerFactory.getLogger(TesteLogController.class.getName());

    @GetMapping("/test")
    public String testLog() {
        logger.debug("This is a debug message log");
        logger.info("This is a debug message log");
        logger.warn("This is a debug message log");
        logger.error("This is a debug message log");
        return "LOG GERADO";
    }
}
