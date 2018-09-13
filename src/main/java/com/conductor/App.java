package com.conductor;

import com.conductor.model.Record;
import com.conductor.util.PropertyLoader;

import java.util.Map;


public class App {
    public static void main(String[] args) {
        Record record = Worker.getLatestRecord(PropertyLoader.getBeaconURL());
        Worker.validateOutputValue(record);
        BeaconAnalyzer analyzer = new BeaconAnalyzer();
        Map result = analyzer.analyzeOutputValue(record);
        System.out.println(analyzer.getPrintableResult(result));

    }

}


