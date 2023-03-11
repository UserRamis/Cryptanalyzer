package org.javarush.cryptanalyzer.garipov;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class StaticAnalysis
{

    File author=new File("Текставтора.txt");
    File our=new File("Шифртекст.txt");

    File st=new File("Статический.txt");//наш расшифрованный файл

    StaticAnalysis(File author, File our)
    {
        this.author=author;
        this.our=our;
    }

    public File operationStatic() throws IOException {

        st.createNewFile();


        //String fileName = "path/to/file.txt"; // замените на путь к вашему файлу
        try {
            HashMap<Character, Integer> charCount = countCharacters(our);
            for (char c : charCount.keySet()) {
                int count = charCount.get(c);
                System.out.printf("'%c' встречается %d раз(а)\n", c, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        return st;
    }


    public static HashMap<Character, Integer> countCharacters(File fileName) throws IOException {
        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int c;
        while ((c = reader.read()) != -1) {
            char ch = (char) c;
            if (charCount.containsKey(ch)) {
                int count = charCount.get(ch);
                charCount.put(ch, count + 1);
            } else {
                charCount.put(ch, 1);
            }
        }
        reader.close();
        return charCount;
    }




}
