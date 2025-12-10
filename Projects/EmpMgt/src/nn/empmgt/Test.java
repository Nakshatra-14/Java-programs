package nn.empmgt;

import java.io.File;
import java.io.FileReader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, CsvValidationException{
        File file = new File("indian_1000_records.csv");
        CSVReader csvReader = new CSVReader(new FileReader(file));
        System.out.println("Hello");
        csvReader.close();
    }
}
