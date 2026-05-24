package com.mavila.pos.exception;

public record FieldErrorResponse(
        String field,
        String message
) {
}
