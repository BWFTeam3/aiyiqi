package com.bwf.aiyiqi.utils;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/28.
 */

public class StringHandler {
    static Map<String,String> map;
    public static Map<String,String> getMap(String result,int times){
        map=new HashMap<>();
        for (int i = 0; i < times; i++) {
            if (result.lastIndexOf("}")<0)break;
            result=result.substring(result.indexOf("{")+1,result.lastIndexOf("}"));
        }

        String [] strings = result.split(",");
        for (int i = 0; i < strings.length; i++) {
            String key=strings[i].substring(0,strings[i].indexOf(":")).replace("\"","");
            String value=strings[i].substring(strings[i].indexOf(":")+1).replace("\"","");
            Log.d("StringHandler", key+":"+value);
            map.put(key,value);
        }
        return map;

    }
}
