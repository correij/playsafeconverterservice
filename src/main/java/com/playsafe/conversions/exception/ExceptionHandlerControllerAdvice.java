package com.playsafe.conversions.exception;

import com.playsafe.conversions.constants.StatusConstants;
import com.playsafe.conversions.model.ConversionResponse;
import com.playsafe.conversions.model.Status;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {


    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ConversionResponse handleServiceException(final ServiceException exception) {

        Status status = new Status(exception.getStatus());
        return new ConversionResponse(status, null);

    }

    @ExceptionHandler(CanNotGetResponseException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    ConversionResponse handleResponseException(final CanNotGetResponseException exception) {
        Status status = new Status(exception.getStatus());
        return new ConversionResponse(status, null);

    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    ConversionResponse handleNotFoundException(final NotFoundException exception) {
        Status status = new Status(exception.getStatus());
        return new ConversionResponse(status, null);

    }

    @ExceptionHandler(ConnectionTimeoutException.class)
    @ResponseStatus(value = HttpStatus.GATEWAY_TIMEOUT)
    public @ResponseBody
    ConversionResponse handleConnectionException(final ConnectionTimeoutException exception) {
        Status status = new Status(exception.getStatus());
        return new ConversionResponse(status, null);

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    ConversionResponse internalServerException(final Exception exception) {

        Status status = new Status(StatusConstants.HttpConstants.INTERNAL_SERVER_ERROR);
        return new ConversionResponse(status, null);

    }
}
