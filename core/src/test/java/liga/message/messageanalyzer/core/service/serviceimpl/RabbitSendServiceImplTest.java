package liga.message.messageanalyzer.core.service.serviceimpl;
/*
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.message.messageanalyzer.core.dto.RabbitMessageDto;
import liga.message.messageanalyzer.core.dto.Type;
import liga.message.messageanalyzer.core.service.RabbitSendService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.AmqpTemplate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RabbitSendServiceImplTest {

    private RabbitSendService service;

    @Mock
    private AmqpTemplate amqpTemplate;

    private ObjectMapper mapper;

    private RabbitMessageDto dto;

    private String queue;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
        service = new RabbitSendServiceImpl(amqpTemplate, mapper);
        dto = new RabbitMessageDto(
                Type.alert,
                "Content"
        );
        queue = "test";
    }

    @Test
    void sendMessage() throws JsonProcessingException {
        // given
        String message = mapper.writeValueAsString(dto);

        // when
        service.sendMessage(dto, queue);

        // then
        verify(amqpTemplate).convertAndSend(queue, message);
    }
}
 */