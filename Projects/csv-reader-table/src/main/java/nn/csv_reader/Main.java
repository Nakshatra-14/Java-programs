package nn.csv_reader;

import java.io.File;

import com.github.houbb.csv.support.reader.impl.CsvReaderFile;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        CsvReaderFile csvf = new CsvReaderFile(new File("src\\main\\resources\\Test.csv"));

        System.out.println(csvf.read());
    }
}