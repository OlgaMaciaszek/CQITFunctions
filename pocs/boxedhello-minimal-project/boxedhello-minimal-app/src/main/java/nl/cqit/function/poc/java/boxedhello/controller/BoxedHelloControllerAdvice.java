package nl.cqit.function.poc.java.boxedhello.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BoxedHelloControllerAdvice extends ResponseEntityExceptionHandler {

    private static final Log LOG = LogFactory.getLog(BoxedHelloControllerAdvice.class);

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleRuntimeException(RuntimeException ex, WebRequest request) {

        LOG.error(ex.getMessage(), ex);
        LOG.debug("Request: " + request + "Content-Type: " + Arrays.toString(request.getHeaderValues(HttpHeaders.CONTENT_TYPE))
                + "Accept: " + Arrays.toString(request.getHeaderValues(HttpHeaders.ACCEPT)));

        if (ex instanceof JsonParseException) {
            ProblemDetail body = getExceptionProblemDetail(
                    HttpStatus.BAD_REQUEST,
                    "/errors/validation-failed",
                    "Validation failed",
                    ex
            );
            return body;
        }

        ProblemDetail body = getExceptionProblemDetail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "/errors/unhandled-exception",
                "Encountered an unhandled exception",
                ex
        );
        return body;
    }

    private ProblemDetail getExceptionProblemDetail(
            HttpStatus status,
            String problemType, String problemDetail, RuntimeException ex) {
        ProblemDetail body = ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(status.value()),
                ex.getLocalizedMessage()
        );
        body.setType(URI.create(problemType));
        body.setTitle(problemDetail);
        body.setProperty("exceptionType", ex.getClass().getName());
        if (ex.getCause() != null && ex.getCause() != ex) {
            body.setProperty("cause", getCauseMap(ex, ex.getCause()));
        }
        return body;
    }

    private Map<String, Object> getCauseMap(Throwable ex, Throwable cause) {
        Map<String, Object> causeMap = new HashMap<>();
        causeMap.put("exceptionType", cause.getClass().getName());
        causeMap.put("message", cause.getLocalizedMessage());
        causeMap.put("stacktrace", cause.getStackTrace());
        if (cause.getCause() != null && cause.getCause() != cause) {
            causeMap.put("cause", getCauseMap(cause, cause.getCause()));
        }
        return Map.copyOf(causeMap);
    }
}
