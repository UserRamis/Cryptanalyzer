package org.javarush.cryptanalyzer.garipov;

import java.io.*;
import java.util.Scanner;

public class Main {

    static File txt = new File("Test.txt");

   static File filenew = new File("DecryptNewFile.txt");

    public static void main(String[] args) throws IOException {

        Encryption encryption = new Encryption(txt,2);
        File ourfile = encryption.ecryptionOperation();//зашифрованный файл
        encryption.ecryptionOperation();

        Decryption decryption = new Decryption();
        decryption.decryptionOperation(ourfile, 2,filenew);

        Bruteforce bruteforce=new Bruteforce(ourfile);
        bruteforce.bruteforceOperation();

























    }









}