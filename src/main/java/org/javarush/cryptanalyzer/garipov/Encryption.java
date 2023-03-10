package org.javarush.cryptanalyzer.garipov;
import java.io.*;
public class Encryption
{
    File file;
    int key;

    File filenew = new File("EncryptNewFile.txt");

    public Encryption(File file,int key)
    {

        this.key=key;
        this.file=file;
    }
    public File ecryptionOperation() throws IOException {
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
                    ch=Alphabet.alphabetBig.charAt((value+key)%33);
                }
                if(Alphabet.alphabetLower.contains(String.valueOf(ch)))
                {
                    int value = Alphabet.alphabetLower.indexOf(ch);//получаем индекс символа
                    ch=Alphabet.alphabetLower.charAt((value+key)%33);
                }
                if(Alphabet.number.contains(String.valueOf(ch)))
                {
                    int value = Alphabet.number.indexOf(ch);//получаем индекс символа
                    ch=Alphabet.number.charAt((value+key)%10);
                }
                if(Alphabet.punctuation.contains(String.valueOf(ch)))
                {
                    int value = Alphabet.punctuation.indexOf(ch);//получаем индекс символа
                    ch=Alphabet.punctuation.charAt((value+key)%9);
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