package liga.message.messageanalyzer.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.message.messageanalyzer.core.model.MessageDto;
import liga.message.messageanalyzer.core.model.Status;
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

    private MessageDto dto;

    @BeforeEach
    void setUp() {
        controller = new AnalyzerController(service);
        dto = new MessageDto(
                Status.alert,
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
        dto = new MessageDto(
                null,
                null
        );

        // when
        result = controller.saveData(dto);

        // then
        assertEquals(result.getBody(), "Неверный формат данных.");
    }
}