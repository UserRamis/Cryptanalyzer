package org.javarush.cryptanalyzer.garipov;

import java.io.File;
import java.io.IOException;

public class Main {

    static File txt = new File("Test.txt");

    public static void main(String[] args) throws IOException
    {

    Encryption encryption=new Encryption(txt,2);
    File ourfile=encryption.ecryptionOperation();
    encryption.ecryptionOperation();

    Decryption decryption=new Decryption(ourfile,2);
    decryption.decryptionOperation();



    }


}