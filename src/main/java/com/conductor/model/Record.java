package com.conductor.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "frequency",
        "timeStamp",
        "seedValue",
        "previousOutputValue",
        "signatureValue",
        "outputValue",
        "statusCode"
})
@JacksonXmlRootElement()
public class Record {

    @JsonProperty("frequency")
    private String frequency;
    @JsonProperty("timeStamp")
    private String timeStamp;
    @JsonProperty("seedValue")
    private String seedValue;
    @JsonProperty("previousOutputValue")
    private String previousOutputValue;
    @JsonProperty("signatureValue")
    private String signatureValue;
    @JsonProperty("outputValue")
    private String outputValue;
    @JsonProperty("statusCode")
    private String statusCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonProperty("frequency")
    public String getFrequency() {
        return frequency;
    }

    @JsonProperty("frequency")
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @JsonProperty("timeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    @JsonProperty("timeStamp")
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonProperty("seedValue")
    public String getSeedValue() {
        return seedValue;
    }

    @JsonProperty("seedValue")
    public void setSeedValue(String seedValue) {
        this.seedValue = seedValue;
    }

    @JsonProperty("previousOutputValue")
    public String getPreviousOutputValue() {
        return previousOutputValue;
    }

    @JsonProperty("previousOutputValue")
    public void setPreviousOutputValue(String previousOutputValue) {
        this.previousOutputValue = previousOutputValue;
    }

    @JsonProperty("signatureValue")
    public String getSignatureValue() {
        return signatureValue;
    }

    @JsonProperty("signatureValue")
    public void setSignatureValue(String signatureValue) {
        this.signatureValue = signatureValue;
    }

    @JsonProperty("outputValue")
    public String getOutputValue() {
        return outputValue;
    }

    @JsonProperty("outputValue")
    public void setOutputValue(String outputValue) {
        this.outputValue = outputValue;
    }

    public Record withOutputValue(String outputValue) {
        this.outputValue = outputValue;
        return this;
    }

    @JsonProperty("statusCode")
    public String getStatusCode() {
        return statusCode;
    }

    @JsonProperty("statusCode")
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Record{" +
                "frequency='" + frequency + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", seedValue='" + seedValue + '\'' +
                ", previousOutputValue='" + previousOutputValue + '\'' +
                ", signatureValue='" + signatureValue + '\'' +
                ", outputValue='" + outputValue + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
