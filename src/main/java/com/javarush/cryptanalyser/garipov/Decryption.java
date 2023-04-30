package com.javarush.cryptanalyser.garipov;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Decryption
{
    public File decryptionOperation(File input,int key,File output) throws IOException {

        int keyForAlphabet=33 - (key % 33);
        int keyForNumber=10-(key%10);
        int keyForPunctuation=9-(key%9);
        FileWriter writer = new FileWriter (output);
        try(FileReader reader = new FileReader(input))
        {
            int c;
            while((c=reader.read())!=-1){
                char ch=(char)c;
                if(Alphabet.alphabetBig.contains(String.valueOf(ch)))
                {
                    int value = Alphabet.alphabetBig.indexOf(ch);//получаем индекс символа
                    ch=Alphabet.alphabetBig.charAt((value+keyForAlphabet)%33);
                }
                if(Alphabet.alphabetLower.contains(String.valueOf(ch)))
                {
                    int value = Alphabet.alphabetLower.indexOf(ch);//получаем индекс символа
                    ch=Alphabet.alphabetLower.charAt((value+keyForAlphabet)%33);
                }
                if(Alphabet.number.contains(String.valueOf(ch)))
                {
                    int value = Alphabet.number.indexOf(ch);//получаем индекс символа
                    ch=Alphabet.number.charAt((value+keyForNumber)%10);
                }
                if(Alphabet.punctuation.contains(String.valueOf(ch)))
                {
                    int value = Alphabet.punctuation.indexOf(ch);//получаем индекс символа
                    ch=Alphabet.punctuation.charAt((value+keyForPunctuation)%9);
                }
                writer.write(ch);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return output;
    }
}