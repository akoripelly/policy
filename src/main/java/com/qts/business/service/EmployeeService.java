package com.qts.business.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.qts.business.vo.Employee;

public class EmployeeService {

	public List<Employee> readFromCSV(String filePath) {
        List<Employee> employees = new ArrayList<>();
        Path pathToFile = Paths.get(filePath);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                Employee book = createEmployee(attributes);
                // adding book into ArrayList
                employees.add(book);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return employees;
    }
	
	private Employee createEmployee(String[] metadata) {
        String firstName = metadata[0];
        String lastName = metadata[1];
        String gender = metadata[2];
        String age = metadata[3];

        // create and return book of this metadata
        return new Employee(firstName, lastName, gender, age);
    }
}
