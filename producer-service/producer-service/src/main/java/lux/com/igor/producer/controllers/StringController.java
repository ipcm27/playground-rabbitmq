package lux.com.igor.producer.controllers;


import lombok.RequiredArgsConstructor;
import lux.com.igor.producer.services.StringService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/produces")
public class StringController {


    private final StringService service;

    @PostMapping
    public ResponseEntity<String> produce(@RequestParam("message") String message) {
       service.produce(message);
       return ResponseEntity.ok("Sending message");
    }

}
