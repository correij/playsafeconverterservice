package com.playsafe.conversions.exception;

import com.playsafe.conversions.constants.StatusConstants;
import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
    private StatusConstants.HttpConstants status;

    public ServiceException(StatusConstants.HttpConstants status) {
        super(status.getDesc(), null);
        this.status = status;
    }
}
