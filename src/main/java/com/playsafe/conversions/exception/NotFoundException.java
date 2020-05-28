package com.playsafe.conversions.exception;

import com.playsafe.conversions.constants.StatusConstants;
import lombok.Getter;

@Getter
public class NotFoundException extends Exception {

    private StatusConstants.HttpConstants status;

    public NotFoundException(StatusConstants.HttpConstants status) {
        super(status.getDesc(), null);
        this.status = status;
    }
}