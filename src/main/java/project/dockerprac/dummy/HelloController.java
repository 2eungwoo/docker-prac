package project.dockerprac.dummy;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello/{id}")
    public int hello(@PathVariable int id){
        return helloService.getNumber(id);
    }

    @PostMapping("/hello/{num}")
    public String addHello(@PathVariable int num){
        helloService.addHello(num);
        return "success";
    }
}
