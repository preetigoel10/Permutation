package com.bobble;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCsvFile {

    public static void writeDataLineByLine(String filePath)
    {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // add data to csv
            String[] data1 = { "a", "b", "c" };
            writer.writeNext(data1);
            String[] data2 = { "i", "j" };
            writer.writeNext(data2);
            String[] data3 = { "x", "y" };
            writer.writeNext(data3);
            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "input.csv";
        writeDataLineByLine(filePath);
    }
}
