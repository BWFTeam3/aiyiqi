package com.bwf.aiyiqi.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/11/28.
 */

public class StringHandler {
    static Map<String, String> map;
    static List<String> list;

    public static Map<String, String> getMap(String result, int times) {
        map = new HashMap<>();
        for (int i = 0; i < times; i++) {
            if (result.lastIndexOf("}") < 0) break;
            result = result.substring(result.indexOf("{") + 1, result.lastIndexOf("}"));
        }

        String[] strings = result.split(",");
        for (int i = 0; i < strings.length; i++) {
            String key = strings[i].substring(0, strings[i].indexOf(":")).replace("\"", "");
            String value = strings[i].substring(strings[i].indexOf(":") + 1).replace("\"", "");
            Log.d("StringHandler", key + ":" + value);
            map.put(key, value);
        }
        return map;

    }

    public static List<String> getList(String result, int times) {
        list = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            if (result.lastIndexOf("}") < 0) break;
            result = result.substring(result.indexOf("{") + 1, result.lastIndexOf("}"));
        }

        String[] strings = result.split(",");
        for (int i = 0; i < strings.length; i++) {
            String key = strings[i].substring(0, strings[i].indexOf(":")).replace("\"", "");
            String value = strings[i].substring(strings[i].indexOf(":") + 1).replace("\"", "");
            list.add(UnicodeParser.decodeUnicode(key));
            list.add(UnicodeParser.decodeUnicode(value));
        }
        return list;
    }

    public static String getString(String string) {
        String a1 = "\"tags\":[{]\"";
        String b1 = "\\d{2,6}";
        String c1 = "\"[:][{]\"id\"";
        String regex1 = a1 + b1 + c1;
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(string);
        String result = matcher.replaceAll("\"tags\":[{\"id\"");

        String a2 = "[}],\"";
        String b2 = "\\d{2,6}";
        String c2 = "\"[:][{]\"id\"";
        String regex2 = a2 + b2 + c2;
        pattern = Pattern.compile(regex2);
        matcher = pattern.matcher(result);
        result = matcher.replaceAll("},{\"id\"");

        String oldOne = "}},\"relatedNews\"";
        String newOne = "}],\"relatedNews\"";
        result = result.replace(oldOne, newOne);
        return result;
    }
}
