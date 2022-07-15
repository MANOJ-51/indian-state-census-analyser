package com.bridgelabz;

public class StateCensusCsvData {

    //headings in csv file
    public int srNumber;
    public String stateName;
    public int tin;
    public String stateCode;

    //parameterised constructor
    public StateCensusCsvData(int srNumber, String stateName, int tin, String stateCode) {
        this.srNumber = srNumber;
        this.stateName = stateName;
        this.tin = tin;
        this.stateCode = stateCode;
    }
}
