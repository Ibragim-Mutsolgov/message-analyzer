package liga.message.messageanalyzer.core.service.serviceimpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.message.messageanalyzer.core.dto.RabbitMessageDto;
import liga.message.messageanalyzer.core.service.RabbitSendService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RabbitSendServiceImpl implements RabbitSendService {

    private final AmqpTemplate template;

    private final ObjectMapper mapper;

    @Override
    public void sendMessage(RabbitMessageDto dto, String queue) throws JsonProcessingException {
        String dtoToString = mapper.writeValueAsString(dto);
        template.convertAndSend(queue, dtoToString);
    }
}
