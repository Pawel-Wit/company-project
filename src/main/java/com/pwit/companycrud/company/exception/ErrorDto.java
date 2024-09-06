package com.pwit.companycrud.company.exception;

import java.time.LocalDateTime;

public record ErrorDto(String message, LocalDateTime timestamp) {

}
