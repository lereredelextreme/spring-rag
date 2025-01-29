package fr.efrei.rag.web.rest;

import fr.efrei.rag.web.dto.Sample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SampleResource {

    @GetMapping("/samples/{value}")
    public String hello(@PathVariable(value = "value", required = false) final String value) {
        return "Hello" + value + "!";
    }

    public Sample helloJson(@PathVariable(value = "value", required = false) final String value) {
        return new Sample("Hello" + value + "!");
    }
}
