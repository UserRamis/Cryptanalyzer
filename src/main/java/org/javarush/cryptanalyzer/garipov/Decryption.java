package org.javarush.cryptanalyzer.garipov;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Decryption
{
    File file;
    int key;


    File filenew = new File("DecryptNewFile");
    public Decryption(File file,int key)
    {
        this.key=key;
        this.file=file;
    }

    public File decryptionOperation() throws IOException {

       int keyForAlphabet=33 - (key % 33);
       int keyForNumber=10-(key%10);
       int keyForPunctuation=9-(key%9);

        if (filenew.createNewFile()){
            System.out.println("File is created!");
        }
        else{
            System.out.println("File already exists.");
        }
        FileWriter writer = new FileWriter (filenew);

        try(FileReader reader = new FileReader(file))
        {
            int c;
            while((c=reader.read())!=-1){
                char ch=(char)c;
                System.out.print((char)c);

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
        writer.close();
        return filenew;
    }






}
