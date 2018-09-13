package com.conductor;

import com.conductor.model.Record;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.countMatches;

public class BeaconAnalyzer {

    public Map<String, Integer> analyzeOutputValue(Record record) {
        Set<String> uniqueValues = new TreeSet<>(Arrays.asList(record.getOutputValue().split("")));
        Map<String, Integer> result = new TreeMap<>();
        uniqueValues.forEach(uChar -> result.put(uChar, countMatches(record.getOutputValue(), uChar)));
        return result;
    }

    public String getPrintableResult(Map map) {
        StringBuilder sb = new StringBuilder();
        map.forEach((k, v) -> sb.append(k + "," + v + "\n"));
        return sb.toString();
    }
}
