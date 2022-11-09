package liga.message.messageanalyzer.core.controller;
/*
import com.fasterxml.jackson.core.JsonProcessingException;
import liga.message.messageanalyzer.core.dto.RabbitMessageDto;
import liga.message.messageanalyzer.core.dto.Type;
import liga.message.messageanalyzer.core.service.RabbitSendService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AnalyzerControllerTest {

    private AnalyzerController controller;

    @Mock
    private RabbitSendService service;

    private RabbitMessageDto dto;

    @BeforeEach
    void setUp() {
        controller = new AnalyzerController(service);
        dto = new RabbitMessageDto(
                Type.alert,
                "Content"
        );
    }

    @Test
    void saveData() throws JsonProcessingException {
        // given
        ResponseEntity<String> result;

        // when
        result = controller.saveData(dto);

        // then
        assertEquals(result.getBody(), "Сообщение принято и обработано.");
    }

    @Test
    void saveDataWithNullParameter() throws JsonProcessingException {
        // given
        ResponseEntity<String> result;
        dto = new RabbitMessageDto(
                null,
                null
        );

        // when
        result = controller.saveData(dto);

        // then
        assertEquals(result.getBody(), "Неверный формат данных.");
    }
}
 */