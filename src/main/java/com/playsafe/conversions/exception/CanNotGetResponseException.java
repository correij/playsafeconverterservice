package com.playsafe.conversions.exception;

import com.playsafe.conversions.constants.StatusConstants;
import lombok.Getter;

@Getter
public class CanNotGetResponseException extends RuntimeException {

    private StatusConstants.HttpConstants status;

    public CanNotGetResponseException(StatusConstants.HttpConstants status) {
        super(status.getDesc(), null);
        this.status = status;
    }
}
