package liga.message.messageanalyzer.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RabbitMessageDto {

    private Long id;

    private Type type;

    private String description;
}
