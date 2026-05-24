package com.mavila.pos.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(
        Integer status,
        String error,
        String message,
        String path,
        LocalDateTime timestamp,
        List<FieldErrorResponse> fieldErrors
) {
}
