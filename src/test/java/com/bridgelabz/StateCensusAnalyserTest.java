package com.bridgelabz;

import com.opencsv.exceptions.CsvException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {
    StateCensusAnalyser stateCensusAnalyser;

    @Before
    public void setup() {
        stateCensusAnalyser = new StateCensusAnalyser();
    }

    //t.c-1 :-given csv file no of records matches should return true
    @Test
    public void givenCsvFileNumberOfRecordsMatchesShouldReturnTrue()
            throws CsvException, StateCensusIoException, IOException {
        stateCensusAnalyser.readingDataFromCsvFile("src/files/StateCensusData.csv");
        Assert.assertEquals(true, stateCensusAnalyser.checkingNumberOfRecords());
    }

    //t.c-2 :- if the given csv state file is incorrect it throws a custom exception
    @Test
    public void givenCsvFileIfDoesNotExistShouldTrowACustomException() throws IOException, CsvException {
        try {
            stateCensusAnalyser.readingDataFromCsvFile("src/files/StateCensus.csv");
        } catch (StateCensusIoException exception) {
            exception.printStackTrace();
        }
    }

    //t.c-3 :- given csv  with incorrect data type should throw custom exception
    @Test
    public void givenCsvFileWithIncorrectDataTypeShouldThrowCustomException() throws CsvException {
        try {
            stateCensusAnalyser.readingDataFromCsvFile("src/files/StateCensusWrongDataType.csv");
        } catch (StateCensusIoException | IOException exception) {
            exception.printStackTrace();
        }
    }

    //t.c-4 :- given csv file with more columns should throw custom exception
    @Test
    public void givenCsvFileWithDelimiterIssueShouldThrowCustomException()
            throws CsvException, IOException {
        try {
            stateCensusAnalyser.readingDataFromCsvFile("src/files/StateCensusDelimiter.csv");
        } catch (StateCensusIoException exception) {
            exception.printStackTrace();
        }
    }

    //t.c-5 :- given csv file when header is not correct
    @Test
    public void givenCsvFileWhenHeadersDoesNotMatchShouldThrowException()
            throws CsvException, IOException {
        try {
            stateCensusAnalyser.readingDataFromCsvFile("src/files/StateCensusWrongHeader.csv");
        } catch (StateCensusIoException exception) {
            exception.printStackTrace();
        }
    }
}
