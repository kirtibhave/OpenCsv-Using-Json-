package com.csvreader;
import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCsvReader {
    private static final String SAMPLE_CSV_FILE_PATH = "C:/Users/Lenovo/IdeaProjects/JavaOpenCsv/src/main/resources/UserData.csv";

    public static void readSingleRecordInCsv() throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("Name:" + nextRecord[0]);
                System.out.println("Email:" + nextRecord[1]);
                System.out.println("Phone:" + nextRecord[2]);
                System.out.println("Country:" + nextRecord[3]);
                System.out.println("================================");
            }
        }
    }

    static void readAllRecordInCsv() throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
                ) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                System.out.println("Name :" +record[0]);
                System.out.println("Email :"+record[1]);
                System.out.println("Phone :"+record[2]);
                System.out.println("Country :"+record[3]);
                System.out.println("=======================");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        readSingleRecordInCsv();
        readAllRecordInCsv();
    }
}
