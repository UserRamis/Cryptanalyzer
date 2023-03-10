package org.javarush.cryptanalyzer.garipov;

import java.io.File;
import java.io.IOException;

public class StaticAnalysis
{

    File author=new File("Текставтора.txt");
    File our=new File("Шифртекст.txt");

    File st=new File("Статический.txt");

    StaticAnalysis(File author, File our)
    {
        this.author=author;
        this.our=our;
    }

    public File operationStatic() throws IOException {
        st.createNewFile();











        return st;
    }






}
