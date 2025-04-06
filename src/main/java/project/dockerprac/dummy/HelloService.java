package project.dockerprac.dummy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final HelloRepository helloRepository;

    public int getNumber(int helloId){
        return helloRepository.findById(helloId).get().getNumber();
    }

    public void addHello(int num){
        HelloEntity helloEntity = new HelloEntity();
        helloEntity.addNumber(num);
        helloRepository.save(helloEntity);
    }
}

