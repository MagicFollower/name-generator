package com.ng.core;

import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Test add new name and regenerate datafile.
 * - it gives you a way to add names that you like, add generate data file.
 *
 * @author trivis
 */
public class AddNewNameTest {

    /**
     * Add male names
     *
     * @throws IOException ignoredException
     */
    @Test
    public void test01() throws IOException {
        BufferedReader bufferedReaderM = new BufferedReader(new InputStreamReader(Objects.requireNonNull(AddNewNameTest.class.getClassLoader().getResourceAsStream("male.data"))));
        BufferedWriter bufferedWriterM = new BufferedWriter(new FileWriter("male.data.new"));
        List<String> mns = bufferedReaderM.lines().collect(Collectors.toList());

        // add new names there ⬇️, then run test to get new file
        mns.add("Tomas");
        mns.add("Kiki");

        mns.stream().map(x -> {
            x = x.toLowerCase();
            String s = String.valueOf(x.charAt(0));
            x = x.replaceFirst(s, s.toUpperCase());
            return x.trim().split(" ")[0];
        }).distinct().sorted().forEach(x -> {
            try {
                bufferedWriterM.write(x);
                bufferedWriterM.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bufferedWriterM.flush();
    }

    /**
     * Add female names
     *
     * @throws IOException ignoredException
     */
    @Test
    public void test02() throws IOException {
        BufferedReader bufferedReaderF = new BufferedReader(new InputStreamReader(Objects.requireNonNull(AddNewNameTest.class.getClassLoader().getResourceAsStream("female.data"))));
        BufferedWriter bufferedWriterF = new BufferedWriter(new FileWriter("female.data.new"));
        List<String> mns = bufferedReaderF.lines().collect(Collectors.toList());

        // add new names there ⬇️, then run test to get a new file
        mns.add("Lusis");
        mns.add("Kiki");

        mns.stream().map(x -> {
            x = x.toLowerCase();
            String s = String.valueOf(x.charAt(0));
            x = x.replaceFirst(s, s.toUpperCase());
            return x.trim().split(" ")[0];
        }).distinct().sorted().forEach(x -> {
            try {
                bufferedWriterF.write(x);
                bufferedWriterF.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bufferedWriterF.flush();
    }

}
