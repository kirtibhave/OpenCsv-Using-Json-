package com.csvtobean;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.pojo.CSVUSer;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCsvReadAndParseToBean {
    public static final String SAMPLE_CSV_FILE_PATH = "C:/Users/Lenovo/IdeaProjects/JavaOpenCsv/src/main/resources/UserData.csv";

    public static void main(String[] args) throws IOException{
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                ){
                    CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUSer.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVUSer> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                CSVUSer csvUser = csvUserIterator.next();
                System.out.println("Name :" +csvUser.getName());
                System.out.println("Email :"+csvUser.getEmail());
                System.out.println("Phone :"+csvUser.getPhone());
                System.out.println("Country:"+csvUser.getCountry());
                System.out.println("===================");
            }
        }
    }
}
