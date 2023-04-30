package com.javarush.cryptanalyser.garipov;
import java.io.*;
import java.util.Scanner;
public class Main {

    static File txt;//наш текст

    static File filenew = new File("output.txt");//зашифрованный файл

    static File author=new File("Author.txt");//текст автора


    public static void main(String[] args) throws IOException {

        System.out.println("Выберите файл, который хотите зашифровать. Если хотите выбрать файл по умолачанию, пропишите 1, если хотите выбрать файл самостоятельно, пропишите 2.");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        if(choice==2)
        {
            String path=sc.nextLine();
            path=sc.nextLine();//выбранный пользователем файл
            txt=new File(path);
        }
        else {
            txt = new File("input.txt");//файл по умолчанию
        }
        System.out.println("Введите ключ ");
        int key=sc.nextInt();


        Encryption encryption = new Encryption(txt,key);
        File ourfile = encryption.ecryptionOperation();//зашифрованный файл
        encryption.ecryptionOperation();

        Decryption decryption = new Decryption();
        decryption.decryptionOperation(ourfile, key,filenew);

        Bruteforce bruteforce=new Bruteforce(ourfile);
        bruteforce.bruteforceOperation();




    }
}