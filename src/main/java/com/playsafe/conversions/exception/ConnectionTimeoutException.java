package com.playsafe.conversions.exception;

import com.playsafe.conversions.constants.StatusConstants;
import lombok.Getter;

@Getter
public class ConnectionTimeoutException extends Exception {

    private StatusConstants.HttpConstants status;

    public ConnectionTimeoutException(StatusConstants.HttpConstants status) {
        super(status.getDesc(), null);
        this.status = status;
    }
}