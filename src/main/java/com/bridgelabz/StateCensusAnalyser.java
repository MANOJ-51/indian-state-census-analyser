package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateCensusAnalyser {

    //creating list of csv data
    List<StateCensusCsvData> stateCensusCsvData = new ArrayList<>();

    //reading data from csv file
    public void readingDataFromCsvFile(String filePath) throws StateCensusIoException, IOException {
        try {
            CSVReader csvReader = new CSVReader(new FileReader(filePath));
            String[] data;
            data = csvReader.readNext();
            if (checkingHeader(data) == false) {
                throw new StateCensusIoException(StateCensusIoException.exceptionType.INVALID_HEADER +
                        " Header is not correct.");
            }
            while ((data = csvReader.readNext()) != null) {
                if (data.length != 4) {
                    throw new StateCensusIoException(StateCensusIoException.exceptionType.DELIMITER_ISSUE +
                            " The file is having issue with delemiter");
                } else {
                    stateCensusCsvData.add(new StateCensusCsvData(Integer.parseInt(data[0]), data[1],
                            Integer.parseInt(data[2]), data[3]));
                }
            }
            csvReader.close();
        } catch (FileNotFoundException exception) {
            throw new StateCensusIoException(StateCensusIoException.exceptionType.NO_SUCH_FILE +
                    " File does not exist ");
        } catch (NumberFormatException exception) {
            throw new StateCensusIoException(StateCensusIoException.exceptionType.INCORRECT_TYPE +
                    " The Type is not valid ");
        }

    }

    //checking number of records matching
    public boolean checkingNumberOfRecords() {
        if (stateCensusCsvData.size() == 37) {
            return true;
        } else {
            return false;
        }
    }

    //checking header is correct or not
    public boolean checkingHeader(String[] data) {
        if (data[0].compareTo("SrNo") + data[1].compareTo("StateName") +
                data[2].compareTo("TIN") + data[3].compareTo("StateCode") == 0) {
            return true;
        } else {
            return false;
        }
    }
}
