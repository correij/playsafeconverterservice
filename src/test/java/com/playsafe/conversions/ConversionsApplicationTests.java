package com.playsafe.conversions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playsafe.conversions.controller.ConverterController;
import com.playsafe.conversions.model.ConversionRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;


@SpringBootTest
class ConversionsApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ConverterController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void testConvertKevinToCelsiusSuccess() throws Exception {
        ConversionRequest request = new ConversionRequest();
        request.setAmount(new BigDecimal(274));

        ResponseEntity response = controller.convertKelvinToCelsius(request);
        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        assertThat(new BigDecimal(0.85).setScale(2, RoundingMode.HALF_UP)).isEqualTo(response.getBody());
    }

    @Test
    void testConvertKevinToCelsiusBadInput() throws Exception {
        ResponseEntity response = controller.convertKelvinToCelsius(null);
        assertThat(HttpStatus.INTERNAL_SERVER_ERROR).isEqualTo(response.getStatusCode());
    }


    @Test
    void testConvertCelsiusToKelvinSuccess() throws Exception {
        ConversionRequest request = new ConversionRequest();
        request.setAmount(new BigDecimal(1));

        ResponseEntity response = controller.convertCelsiusToKelvin(request);
        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        assertThat(new BigDecimal(274.15).setScale(2, RoundingMode.HALF_UP)).isEqualTo(response.getBody());
    }

    @Test
    void testConvertCelsiusToKelvinBadInput() throws Exception {
        ConversionRequest request = new ConversionRequest();
        request.setAmount(null);

        ResponseEntity response = controller.convertCelsiusToKelvin(request);
        assertThat(HttpStatus.INTERNAL_SERVER_ERROR).isEqualTo(response.getStatusCode());
    }

    @Test
    void testConvertMilesToKilometersSuccess() throws Exception {
        ConversionRequest request = new ConversionRequest();
        request.setAmount(new BigDecimal(1));

        ResponseEntity response = controller.convertMilesToKilometers(request);
        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        assertThat(new BigDecimal(1.60934).setScale(5, RoundingMode.HALF_UP)).isEqualTo(response.getBody());
    }

    @Test
    void testConvertMilesToKilometersBadInput() throws Exception {
        ConversionRequest request = new ConversionRequest();
        request.setAmount(null);

        ResponseEntity response = controller.convertMilesToKilometers(request);
        assertThat(HttpStatus.INTERNAL_SERVER_ERROR).isEqualTo(response.getStatusCode());
    }

    @Test
    void testConvertKilometersToMileSuccess() throws Exception {
        ConversionRequest request = new ConversionRequest();
        request.setAmount(new BigDecimal(1.60934));

        ResponseEntity response = controller.convertKilometersToMiles(request);
        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        assertThat(new BigDecimal(1).setScale(5, RoundingMode.HALF_UP)).isEqualTo(response.getBody());
    }

    @Test
    void testConvertKilometersToMileBadInput() throws Exception {
        ResponseEntity response = controller.convertKilometersToMiles(null);
        assertThat(HttpStatus.INTERNAL_SERVER_ERROR).isEqualTo(response.getStatusCode());
    }
}
