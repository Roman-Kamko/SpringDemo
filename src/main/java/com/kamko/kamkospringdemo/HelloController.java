package com.kamko.kamkospringdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    public final HelloService helloService;
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }
    @GetMapping(path = "/")
    public String hello() {
        return helloService.hello();
    }
    @GetMapping(path = "/hello")
    public String answerHello(@RequestParam("name") String userName) {
        return helloService.answerHello(userName);
    }
}
