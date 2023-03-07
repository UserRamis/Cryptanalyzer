package org.javarush.cryptanalyzer.garipov;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        File txt = new File("Test.txt");
        System.out.println(Read(txt));
        char result1[] = Read(txt);//наш первый текст в массиве
        System.out.println(Encryption(result1, 2));
        char result2[] = Encryption(result1, 2);// наш зашифрованный текст
        System.out.println(Deconding(result2, 2));
        char result3[] = Deconding(result2, 2);//наш расшифрованный текст


    }

    public static char[] Read(File file) {
        ArrayList<Character> result1 = new ArrayList<>();

        try (FileInputStream fin = new FileInputStream("Test.txt")) {
            int i = -1;
            while ((i = fin.read()) != -1) {
                char ch;
                result1.add((char) i);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        char[] myCharArray = new char[result1.size()];
        for (int i1 = 0; i1 < result1.size(); i1++) {
            myCharArray[i1] = result1.get(i1);
        }
        return myCharArray;
    }

    public static char[] Encryption(char ch[], int num) {
        char result[] = new char[ch.length];
        for (int i = 0; i < ch.length; i++) {
            int asciiOfE = (int) ch[i];
            asciiOfE = asciiOfE + num;
            result[i] = (char) asciiOfE;
        }
        return result;
    }

    public static char[] Deconding(char ch[], int num) {
        char result[] = new char[ch.length];
        for (int i = 0; i < ch.length; i++) {
            int asciiOfE = (int) ch[i];
            asciiOfE = asciiOfE - num;
            result[i] = (char) asciiOfE;
        }
        return result;
    }
}