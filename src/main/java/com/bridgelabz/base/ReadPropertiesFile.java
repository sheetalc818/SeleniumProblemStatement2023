package com.bridgelabz.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
    public BufferedReader reader;
    public Properties properties;
    public String propertiesFilePath = "C:\\Users\\Admin\\Documents\\QADevPrograms\\SeleniumProblemStatement2023\\src\\main\\resources\\Testdata.properties";

    public ReadPropertiesFile(){
        try {
            reader = new BufferedReader(new FileReader(propertiesFilePath));
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
