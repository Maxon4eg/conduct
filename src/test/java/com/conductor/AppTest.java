package com.conductor;

import com.conductor.model.Record;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private final Record validRecord = new Record().withOutputValue("76277889E9341AE898EAE48F7664C59FBC0BECEE7527C50809873AC3A43E1873504275DDDB74557DD69774A4E917AC958296A9327D211B34CB3E716CD9169ACD");
    private final String validPrintableResult = "0,4\n 1,7\n 2,6\n 3,8\n 4,9\n 5,8\n 6,7\n 7,16\n 8,9\n 9,12\n A,8\n B,5\n C,9\n D,8\n E,10\n F,2\n";
    private final String beacondURL = "https://beacon.nist.gov/rest/record/last";
    private final Map<String, Integer> testResult = new HashMap<String, Integer>() {
        {
            put("0", 4);
            put("1", 7);
            put("2", 6);
            put("3", 8);
            put("4", 9);
            put("5", 8);
            put("6", 7);
            put("7", 16);
            put("8", 9);
            put("9", 12);
            put("A", 8);
            put("B", 5);
            put("C", 9);
            put("D", 8);
            put("E", 10);
            put("F", 2);

        }
    };
    private final String printableTestResult = "A,8\nB,5\nC,9\nD,8\nE,10\nF,2\n0,4\n1,7\n2,6\n3,8\n4,9\n5,8\n6,7\n7,16\n8,9\n9,12\n";

    @Test

    public void testGetRecord() throws Exception {
        Record record = Worker.getLatestRecord(beacondURL);
        Assert.assertNotNull(record.getOutputValue(), "output value is null");
        Assert.assertFalse(record.getOutputValue().isEmpty(), "output value is empty");
    }

    @Test
    public void testRecordValidation() throws Exception {
        Worker.validateOutputValue(validRecord);
    }

    @Test
    public void testValidateResult() throws Exception {
        Map<String, Integer> result = new BeaconAnalyzer().analyzeOutputValue(validRecord);
        Assert.assertEquals(result, testResult, "Map after analyzing");
    }

    @Test
    public void testValidatePrintableResult() throws Exception {
        String printableresult = new BeaconAnalyzer().getPrintableResult(testResult);
        Assert.assertEquals(printableresult, printableTestResult, "printable result");
    }
}
