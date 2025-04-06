package project.dockerprac.dummy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloEntityTest {

    @Test
    void addNumber는_넘겨받은number를_필드로넣는다() {
        // given
        HelloEntity entity = new HelloEntity();
        int input = 77;

        // when
        entity.addNumber(input);

        // then
        assertThat(entity.getNumber()).isEqualTo(input);
    }
}