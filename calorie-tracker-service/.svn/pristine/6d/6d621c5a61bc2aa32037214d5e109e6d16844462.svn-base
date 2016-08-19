package ca.pragmaticdev.ws.controller;

import ca.pragmaticdev.ws.data.TestImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class TestController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value= "/ws/test", method = RequestMethod.GET)
    public TestImpl getTestResponse(){
        return new TestImpl(counter.incrementAndGet(),"Test Successful");
    }


}
