package com.conductor;

import com.conductor.model.Record;
import com.conductor.util.PropertyLoader;

import java.util.Map;


public class App {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Record record = worker.getLatestRecord(PropertyLoader.getBeaconURL());
        worker.validateOutputValue(record);
        Map result = worker.analyzeOutputValue(record);
        result.forEach((k, v) -> System.out.println(k+" , "+ v));
    }

}


