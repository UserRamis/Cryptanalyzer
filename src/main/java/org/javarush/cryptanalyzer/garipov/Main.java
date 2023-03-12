package org.javarush.cryptanalyzer.garipov;

import java.io.*;


public class Main {

    static File txt = new File("Test.txt");//наш текст

   static File filenew = new File("DecryptNewFile.txt");//зашифрованный файл


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