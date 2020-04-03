package com.WriteIntoCsc;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.pojo.CsvUserWithoutAnnotation;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCsvWriter {
private static final String OBJECT_LIST_SAMPLE = "C:\\Users\\Lenovo\\IdeaProjects\\JavaOpenCsv\\src\\main\\resources\\OpenObjectListData.csv";

public static void main(String[] args) throws IOException,
        CsvDataTypeMismatchException,
        CsvRequiredFieldEmptyException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(OBJECT_LIST_SAMPLE));
        ) {
            StatefulBeanToCsv<CsvUserWithoutAnnotation> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            List<CsvUserWithoutAnnotation> user = new ArrayList<>();
            user.add(new CsvUserWithoutAnnotation("Sundar Pichai", "Sundar.pichai@gmail.com", "+1-111111111", "India"));
            user.add(new CsvUserWithoutAnnotation("Satya Nadella", "satya.nadella@outlook.com", "+1-1111111112", "India"));
            beanToCsv.write(user);
        }
    }
}
