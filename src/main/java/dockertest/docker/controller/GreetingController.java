package dockertest.docker.controller;

import dockertest.docker.model.Greeting;
import dockertest.docker.reponsitory.GreetingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private GreetingRepository greetingRepository;

    public GreetingController (GreetingRepository greetingRepository){
        this.greetingRepository = greetingRepository;
    }

    @GetMapping("/")
    public ResponseEntity<Greeting> greeting(){
        Greeting greeting = new Greeting("Hello world");
        greetingRepository.save(greeting);
        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }


}
