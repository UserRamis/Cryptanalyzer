package com.javarush.cryptanalyser.garipov;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Bruteforce
{
    private File file;
    private  File boot = new File("Bruteforce.txt");
    private  String s="^([а-яА-Я-]+(\\s|,\\s|:\\s|;\\s)){2,}";
    private Decryption decryptionforbruteforce=new Decryption();
    private  Pattern pattern = Pattern.compile(s);
    private StringBuilder stringBuilder = new StringBuilder();
    private String line;

    public Bruteforce(File file)
    {
        this.file=file;
    }

    public File bruteforceOperation() throws IOException {
        for (int i = 1; i < 80; i++)
        {
            boot=clearFileContent(boot);
            boot = decryptionforbruteforce.decryptionOperation(file, i, boot);
            BufferedReader reader = new BufferedReader(new FileReader(boot));
            stringBuilder.delete(0,stringBuilder.length());
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            Matcher matcher = pattern.matcher(stringBuilder);
            if(matcher.find())
            {
                break;
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
}
