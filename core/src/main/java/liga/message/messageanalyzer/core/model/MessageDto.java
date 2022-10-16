package liga.message.messageanalyzer.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageDto {

    private Status status;

    private String content;
}
