package liga.message.messageanalyzer.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.message.messageanalyzer.core.dto.RabbitMessageDto;

public interface RabbitSendService {

    void sendMessage(RabbitMessageDto dto, String queue) throws JsonProcessingException;
}
