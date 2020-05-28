package com.playsafe.conversions.controller;

import com.playsafe.conversions.constants.ConverterConstants;
import com.playsafe.conversions.constants.StatusConstants;
import com.playsafe.conversions.model.ConversionRequest;
import com.playsafe.conversions.model.ConversionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.RoundingMode;

@RestController
public class ConverterController {

    /**
     *  Converts given amount from Kelvin to Celsius.
     * @param amount
     * @return
     */
    @PostMapping(path = "/conversions/ktoc")
    public ResponseEntity convertKelvinToCelsius(@Valid @RequestBody @Nullable ConversionRequest amount) {
        if (amount == null || amount.getAmount() == null) {
            return new ResponseEntity(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(amount.getAmount().add(ConverterConstants.KELVIN_TO_CELSIUS).setScale(2, RoundingMode.HALF_UP), HttpStatus.OK);
    }

    /**
     *  Converts given amount from Celsius to Kelvin.
     * @param amount
     * @return
     */
    @PostMapping(path = "/conversions/ctoc")
    public ResponseEntity convertCelsiusToKelvin(@Valid @RequestBody @Nullable ConversionRequest amount) {
        if (amount == null || amount.getAmount() == null) {
            return new ResponseEntity(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(amount.getAmount().subtract(ConverterConstants.KELVIN_TO_CELSIUS).setScale(2, RoundingMode.HALF_UP), HttpStatus.OK);
    }

    /**
     *  Converts given amount from Miles to Kilometers.
     * @param amount
     * @return
     */
    @PostMapping(path = "/conversions/mtok")
    public ResponseEntity convertMilesToKilometers(@Valid @RequestBody @Nullable ConversionRequest amount) {
        if (amount == null || amount.getAmount() == null) {
            return new ResponseEntity(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(amount.getAmount().multiply(ConverterConstants.MILES_TO_KILOMETER).setScale(5, RoundingMode.HALF_UP), HttpStatus.OK);
    }

    /**
     *  Converts given amount from Kilometers to Miles.
     * @param amount
     * @return
     */
    @PostMapping(path = "/conversions/ktom")
    public ResponseEntity convertKilometersToMiles(@Valid @RequestBody ConversionRequest amount) {
        if (amount == null || amount.getAmount() == null) {
            return new ResponseEntity(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(amount.getAmount().divide(ConverterConstants.MILES_TO_KILOMETER,5, RoundingMode.HALF_UP), HttpStatus.OK);
    }
}