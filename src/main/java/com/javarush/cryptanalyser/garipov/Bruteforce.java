package com.javarush.cryptanalyser.garipov;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Bruteforce
{
    File file;
    File boot = new File("Bruteforce.txt");

    public Bruteforce(File file)
    {
        this.file=file;
    }
    Decryption decryptionforbruteforce=new Decryption();


    public File bruteforceOperation() throws IOException
    {
        boot.createNewFile();
        boolean flag=true;
        int key=1;

        boot= decryptionforbruteforce.decryptionOperation(file,key,boot);
        while (!flag)
        {
            boot= decryptionforbruteforce.decryptionOperation(file,key,boot);


            String str1 = Files.readString((Path.of(boot.toURI())));
            StringBuilder str= new StringBuilder(str1);

            if(doesNotContainLongWords(str)&&!doesNotHavePreposition(str)&&!doesNotHaveEnoughSpaces(str))
            {
                return boot;

            }
            else
            {
                boot=clearFileContent(boot);
                key++;
                str.setLength(0);
                //str1=" ";

            }

        }
        return boot;
    }

    public File  clearFileContent(File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }


    private boolean doesNotContainLongWords(StringBuilder decryptedText) {
        String[] array = decryptedText.toString().split(" ");
        for (String s : array) {
            if (s.length() > 30) {
                return false;
            }
        }
        return true;
    }

    private boolean doesNotHavePreposition(StringBuilder decryptedText) {
        String[] array = decryptedText.toString().split(" ");
        int count = 0;
        for (String s : array) {
            if (s.length() == 1) {
                count++;
            }
        }
        return count == 0;
    }

    private boolean doesNotHaveEnoughSpaces(StringBuilder decryptedText) {
        String[] array = decryptedText.toString().split("\n");
        int count = 0;
        for (String s : array) {
            if (s.contains(" ")) {
                String[] arr = s.split(" ");
                count += arr.length - 1;
            }
        }
        return count < array.length;
    }
















}