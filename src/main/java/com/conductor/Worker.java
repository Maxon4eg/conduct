package com.conductor;

import com.conductor.model.Record;
import com.conductor.util.CustomXmlMapper;
import com.conductor.util.PropertyLoader;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
import static org.apache.commons.lang3.StringUtils.countMatches;

public class Worker {

    public Record getLatestRecord(String url) {
        return given().get(url)
                .then().statusCode(200).extract()
                .response().as(Record.class, new CustomXmlMapper());
    }

    public void validateOutputValue(Record record) {
        if (record.getOutputValue().length() != PropertyLoader.getOutputValueLength()) {
            throw new UnsupportedOperationException("Output value is not valid  actual - " +
                    record.getOutputValue().length()
                    + " expecting  - " + PropertyLoader.getOutputValueLength() + " ");
        }
        Matcher m = Pattern.compile(PropertyLoader.getHexAllowedChars()).matcher(record.getOutputValue());
        if (m.find()) {
            throw new UnsupportedOperationException("Not allowed character: " + m.group() +
                    " in outputValue : "
                    + record.getOutputValue());
        }

    }

    public Map<String, Integer> analyzeOutputValue(Record record) {
        Set<String> uniqueValues = new TreeSet<>(Arrays.asList(record.getOutputValue().split("")));
        Map<String, Integer> result = new TreeMap<>();
        uniqueValues.forEach(uChar -> result.put(uChar, countMatches(record.getOutputValue(), uChar)));
        return result;
    }
}
