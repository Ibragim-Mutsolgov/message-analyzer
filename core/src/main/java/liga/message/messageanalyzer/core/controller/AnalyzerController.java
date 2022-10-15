package liga.message.messageanalyzer.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.message.messageanalyzer.core.model.MessageDto;
import liga.message.messageanalyzer.core.model.NamesForQueue;
import liga.message.messageanalyzer.core.service.RabbitSendService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/analyzer")
public class AnalyzerController {

    private final RabbitSendService service;

    @PostMapping
    public ResponseEntity<String> saveData(@RequestBody MessageDto dto) throws JsonProcessingException {
        if (dto.getStatus() != null && dto.getContent() != null) {
            service.sendMessage(dto, NamesForQueue.ROUTER_QUEUE_NAME);
            return ResponseEntity.ok().body("Сообщение принято и обработано.");
        }
        return ResponseEntity.badRequest().body("Неверный формат данных.");
    }
}
