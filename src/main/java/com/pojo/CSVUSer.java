package com.pojo;
import com.opencsv.bean.CsvBindByName;

public class CSVUSer {
    @CsvBindByName
    private  String name;

    @CsvBindByName(column = "email" ,required = true)
    private  String email;

    @CsvBindByName(column = "phone")
    private  String phoneNo;

    @CsvBindByName
    private String country;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phoneNo;
    }
    public String getCountry() {
        return country;
    }
}
