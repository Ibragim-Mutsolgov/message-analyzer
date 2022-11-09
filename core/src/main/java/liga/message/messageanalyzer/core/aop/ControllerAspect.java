package liga.message.messageanalyzer.core.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.common.core.model.Debug;
import liga.medical.common.core.model.Exception;
import liga.medical.common.core.model.RabbitMessage;
import liga.medical.common.core.service.DebugService;
import liga.medical.common.core.service.ExceptionService;
import liga.medical.common.core.service.RabbitMessageService;
import liga.message.messageanalyzer.core.controller.AnalyzerController;
import liga.message.messageanalyzer.core.dto.RabbitMessageDto;
import liga.message.messageanalyzer.core.dto.SystemTypeId;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.logging.Logger;

@Aspect
@Component
@AllArgsConstructor
public class ControllerAspect {

    private RabbitMessageService rabbitMessageService;

    private DebugService debugService;

    private ExceptionService exceptionService;

    @Pointcut(value = "execution(* liga.message.messageanalyzer.core.controller.*.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object logger(ProceedingJoinPoint joinPoint) throws JsonProcessingException {
        Logger logger = Logger.getLogger(ControllerAspect.class.getName());
        ObjectMapper mapper = new ObjectMapper();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        Object[] massive = joinPoint.getArgs();
        Object object = null;
        String dtoToString = mapper.writeValueAsString(massive[0]);
        RabbitMessage dto = mapper.readValue(dtoToString, RabbitMessage.class);
        rabbitMessageService.save(dto);
        String text = "Класс: " + className + "; метод: " + methodName + "()";
        Debug debug = new Debug();
        debug.setUuid(UUID.randomUUID());
        debug.setSystemTypeId(SystemTypeId.systemTypeId);
        debug.setMethodParams(text);
        debugService.save(debug);
        logger.info(text);
        try {
            object = joinPoint.proceed();
        } catch (Throwable throwable) {
            Exception exception = new Exception();
            exception.setUuid(UUID.randomUUID());
            exception.setSystemTypeId(SystemTypeId.systemTypeId);
            exception.setMethodParams(text);
            exceptionService.save(exception);
            logger.info(text);
            throwable.printStackTrace();
        }
        return object;
    }
}