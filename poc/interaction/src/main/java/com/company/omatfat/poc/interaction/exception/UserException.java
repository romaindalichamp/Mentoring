package com.company.omatfat.poc.interaction.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 */
@Log4j2
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserException extends RestClientException {

    public UserException(String msg) {
        super(msg);
    }

    public UserException(String msg, Throwable ex) {
        super(msg, ex);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        log.error(this);
        return null;
    }
}
