package com.javarush.cryptanalyser.garipov;

import java.io.*;


public class Main {

    static File txt = new File("input.txt");//наш текст

   static File filenew = new File("output.txt");//зашифрованный файл

    static File author=new File("Author.txt");//текст автора


    public static void main(String[] args) throws IOException {

        Encryption encryption = new Encryption(txt,1);
        File ourfile = encryption.ecryptionOperation();//зашифрованный файл
        encryption.ecryptionOperation();

        Decryption decryption = new Decryption();
        decryption.decryptionOperation(ourfile, 1,filenew);

        Bruteforce bruteforce=new Bruteforce(ourfile);
        bruteforce.bruteforceOperation();




    }
}