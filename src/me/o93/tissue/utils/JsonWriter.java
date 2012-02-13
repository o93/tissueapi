package me.o93.tissue.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class JsonWriter {
    
    public static void write(HttpServletResponse response, String responseBody) {
        write(response, responseBody, HttpServletResponse.SC_OK, "", "");
    }
    
    public static void write(
            HttpServletResponse response, int statusCode, String errorType, String errorDetail) {
        write(response, "", statusCode, errorType, errorDetail);
    }
    
    private static void write(
            HttpServletResponse response,
            String responseBody,
            int statusCode,
            String errorType, String errorDetail) {
        response.setContentType("application/json; charset=UTF-8");
        response.setStatus(statusCode);
        
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.print("{\"meta\":{\"code\":");
            writer.print(statusCode);
            
            if (statusCode != HttpServletResponse.SC_OK) {
                writer.print(",\"errorType\":\"");
                writer.print(errorType);
                writer.print("\",\"errirDetail\":\"");
                writer.print(errorDetail);
                writer.print("\"");
            }
            writer.print("},\"response\":");
            writer.print(responseBody);
            writer.print("}");
            writer.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
