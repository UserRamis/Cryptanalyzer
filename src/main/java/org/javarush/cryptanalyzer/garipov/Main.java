package org.javarush.cryptanalyzer.garipov;

import java.io.*;
import java.util.Scanner;

public class Main {

    static File txt = new File("Test.txt");//наш текст

   static File filenew = new File("DecryptNewFile.txt");//зашифрованный файл

    static File author=new File("Author.txt");

    public static void main(String[] args) throws IOException {

        Encryption encryption = new Encryption(txt,7);
        File ourfile = encryption.ecryptionOperation();//зашифрованный файл
        encryption.ecryptionOperation();

        Decryption decryption = new Decryption();
        decryption.decryptionOperation(ourfile, 7,filenew);

        Bruteforce bruteforce=new Bruteforce(ourfile);
        bruteforce.bruteforceOperation();

        StaticAnalysis staticAnalysis=new StaticAnalysis(author,txt);
        staticAnalysis.operationStatic();

























    }









}