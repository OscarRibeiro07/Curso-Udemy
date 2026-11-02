package br.com.erudio.mapper.custom.exception;

import java.util.Date;

public record ExceptionResponse(Date timeStamp, String message, String details) {
}
