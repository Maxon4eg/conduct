package com.conductor;

import com.conductor.model.Record;
import com.conductor.util.Config;
import com.conductor.util.CustomXmlMapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class Worker {

    private Worker() {
    }

    public static Record getLatestRecord(String url) {
        return given().get(url)
                .then().assertThat().statusCode(200)
                .contentType("application/xml").extract()
                .response().as(Record.class, new CustomXmlMapper());
    }

    public static void validateOutputValue(Record record) {
        if (record.getOutputValue().length() != Config.getOutputValueLength()) {
            throw new UnsupportedOperationException("Output value is not valid  actual - " +
                    record.getOutputValue().length()
                    + " expecting  - " + Config.getOutputValueLength() + " ");
        }
        Matcher m = Pattern.compile(Config.getHexAllowedChars()).matcher(record.getOutputValue());
        if (m.find()) {
            throw new UnsupportedOperationException("Not allowed character: " + m.group() +
                    " in outputValue : "
                    + record.getOutputValue());
        }
    }
}
