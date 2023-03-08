package org.javarush.cryptanalyzer.garipov;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bruteforce
{
    File file;
    File filenew = new File("ListNewFile");


    public Bruteforce(File file)
    {
        this.file=file;
    }


    public File bruteforceOperation() throws IOException {


        FileWriter writer = new FileWriter (filenew);

        writer.write(findMaxChar(read(file)));

        writer.close();

        return filenew;



    }

    public char[] read(File file) throws IOException {

        char result[]=new char[length(file)];
        List<String> listOfStrings = new ArrayList<String>();
        listOfStrings = Files.readAllLines((file).toPath());
        result = listOfStrings.toString().toCharArray();
        return result;

    }


    public int length(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);//считаем сколько символов в файле
        byte[] byteArray = new byte[(int)file.length()];
        fis.read(byteArray);
        String data = new String(byteArray);
        System.out.println("Number of characters in the String: "+data.length());
        return data.length();
    }


    public static String findMaxChar(char[] result) {

        int maxCount = 1;
        char maxChar = result[0];
        for(int i = 0, j = 0; i < result.length - 1; i = j){
            int count = 1;
            while (++j < result.length && result[i] == result[j]) {
                count++;
            }
            if (count > maxCount) {
                maxCount = count;
                maxChar = result[i];
            }
        }
        return (maxChar + " = " + maxCount);
    }






}
