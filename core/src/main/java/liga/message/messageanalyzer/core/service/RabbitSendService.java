package liga.message.messageanalyzer.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.message.messageanalyzer.core.model.MessageDto;

public interface RabbitSendService {

    void sendMessage(MessageDto dto, String queue) throws JsonProcessingException;
}
