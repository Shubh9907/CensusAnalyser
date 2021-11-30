package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyser {
    public int loadIndianCensusData(String indiaCensusCsvFilePath) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(indiaCensusCsvFilePath));
        CsvToBeanBuilder<IndianCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
        csvToBeanBuilder.withType(IndianCensusCSV.class);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<IndianCensusCSV> csvToBean = csvToBeanBuilder.build();
        Iterator<IndianCensusCSV> censusCSVIterator = csvToBean.iterator();
        int numOfEntries = 0;
        while (censusCSVIterator.hasNext()) {
            numOfEntries++;
            IndianCensusCSV censusCSV = censusCSVIterator.next();
        }
        return numOfEntries;
    }
}
