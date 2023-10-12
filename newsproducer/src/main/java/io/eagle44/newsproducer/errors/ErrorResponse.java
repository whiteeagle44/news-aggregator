package io.eagle44.newsproducer.errors;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorResponse {
    private final Date timeStamp;
    private final int status;
    private final String error;

    public ErrorResponse(HttpStatus httpStatus, String error) {
        this.timeStamp = new Date();
        this.status = httpStatus.value();
        this.error = error;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}
