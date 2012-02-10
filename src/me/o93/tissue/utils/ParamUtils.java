package me.o93.tissue.utils;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class ParamUtils {
    public static ArrayList<String> arrayToList(HttpServletRequest request, String paramName) {
        ArrayList<String> list = new ArrayList<String>();
        String[] array = request.getParameterValues(paramName);
        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                list.add(array[i]);
            }
        }
        return list;
    }
}
