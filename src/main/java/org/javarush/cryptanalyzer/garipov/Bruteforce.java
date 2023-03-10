package org.javarush.cryptanalyzer.garipov;
import java.io.*;
import java.util.Scanner;

public class Bruteforce
{
    File file;
    File boot = new File("Bruteforce.txt");

    public Bruteforce(File file)
    {
        this.file=file;
    }
    Decryption decryptionforbruteforce=new Decryption();


    public File bruteforceOperation() throws IOException
    {
        boot.createNewFile();
        boolean flag=false;
        int key=1;

      while (!flag)
      {
          boot= decryptionforbruteforce.decryptionOperation(file,key,boot);
          if(containsSpacesBetweenWords(boot))
          {
              return boot;
          }
          else
          {
              boot=clearFileContent(boot);
            key++;
          }
      }
        return boot;
    }

    public File  clearFileContent(File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }


    public static boolean containsSpacesBetweenWords(File file) {
        try {
            Scanner scanner = new Scanner(file);

            // Читаем файл построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Проверяем наличие пробелов между словами в каждой строке
                if (line.contains(" ")) {
                    scanner.close();
                    return true;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
















}
