package com.bwf.aiyiqi.framwork;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by Administrator on 2016/11/23.
 */

public class Print1 {
    public static void Print(Context context,String str){
        PrintStream ps = null;
        try {
            ps = new PrintStream(new File(context.getFilesDir().getAbsolutePath()+"/2.txt"));
            ps.print(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            ps.close();
        }
    }

}
