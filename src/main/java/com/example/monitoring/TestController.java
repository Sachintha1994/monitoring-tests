package com.example.monitoring;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private MeterRegistry registry;

    @RequestMapping("/hello")
    public String hello() {
        registry.counter("requests_to_hello_endpoint").increment();
        return "Hello World!";
    }
}
