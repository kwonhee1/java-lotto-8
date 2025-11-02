package lotto.controller.exception;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ExceptionMapper <Handler> {

    private final Handler exceptionHandler;

    private final Map<Class<? extends IllegalArgumentException>, Method> MESSAGES_MAP = new HashMap<>();

    public ExceptionMapper(Handler handlerClass) {
        exceptionHandler = handlerClass;
        initMessageMap(handlerClass.getClass());
    }

    private void initMessageMap(Class handlerClass) {
        for(Method method : handlerClass.getDeclaredMethods()) {
            TargetException annotation = method.getDeclaredAnnotation(TargetException.class);

            if(annotation == null)
                continue;

            for (Class<? extends IllegalArgumentException> exceptionClass : annotation.value())
                MESSAGES_MAP.put(exceptionClass, method);
        }
    }

    public <T extends IllegalArgumentException> String toMessage(T exception) {
        Method hadlerMethod = MESSAGES_MAP.get(exception.getClass());

        if (hadlerMethod == null)
            throw new NoExceptionHandlerMethodException(exception);

        String errorMessage;
        try {
            errorMessage = (String) hadlerMethod.invoke(exceptionHandler, exception);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException(e);
        }

        return errorMessage;
    }

}
