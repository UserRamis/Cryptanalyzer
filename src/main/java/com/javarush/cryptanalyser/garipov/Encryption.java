package com.javarush.cryptanalyser.garipov;
import java.io.*;
public class Encryption
{
   private File file;
   private int key;

    File filenew = new File("encoded.txt");

    public Encryption(File file,int key)
    {
        this.key=key;
        this.file=file;
    }
    public File ecryptionOperation() throws IOException {
        try(FileReader reader = new FileReader(file); FileWriter writer = new FileWriter (filenew))
        {
            int c;
            while((c=reader.read())!=-1){
                char ch=(char)c;

                String[] charSets = {Alphabet.alphabetBig, Alphabet.alphabetLower, Alphabet.number, Alphabet.punctuation};
                int[] modValues = {33, 33, 10, 9};
                for (int i = 0; i < charSets.length; i++)
                {
                if(charSets[i].contains(String.valueOf(ch)))
                {
                    int value=charSets[i].indexOf(ch);
                    ch=charSets[i].charAt((value+key)%modValues[i]);
                    writer.write(ch);
                    break;
                }
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return filenew;
    }
}