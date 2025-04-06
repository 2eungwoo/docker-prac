package project.dockerprac.dummy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelloServiceTest {
    @Mock
    private HelloRepository helloRepository;

    @InjectMocks
    private HelloService helloService;

    @Test
    void getNumber는_helloId로_엔티티를찾아_number를_반환한다() {
        // given
        int helloId = 1;
        HelloEntity entity = new HelloEntity();
        entity.addNumber(123);
        when(helloRepository.findById(helloId)).thenReturn(Optional.of(entity));

        // when
        int result = helloService.getNumber(helloId);

        // then
        assertThat(result).isEqualTo(123);
    }

    @Test
    void addHello는_숫자를_입력받아_entity를_저장한다() {
        // given
        int input = 45;
        ArgumentCaptor<HelloEntity> captor = ArgumentCaptor.forClass(HelloEntity.class);

        // when
        helloService.addHello(input);

        // then
        verify(helloRepository).save(captor.capture());
        HelloEntity savedEntity = captor.getValue();
        assertThat(savedEntity.getNumber()).isEqualTo(input);
    }
}