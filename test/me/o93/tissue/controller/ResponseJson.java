package me.o93.tissue.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResponseJson {
    List<Map<String, Object>> jsons;
    
    @SuppressWarnings("unchecked")
    public ResponseJson(Object obj) {
        jsons = new ArrayList<Map<String, Object>>();
        jsons.add((Map<String, Object>) obj);
    }
    
    public ResponseJson(List<Map<String, Object>> jsons) {
        this.jsons = jsons;
    }
    
    public ResponseJson(Map<String, Object> json) {
        jsons = new ArrayList<Map<String, Object>>();
        jsons.add(json);
    }
    
    @SuppressWarnings("unchecked")
    public ResponseJson getJson(String key) {
        return new ResponseJson((Map<String, Object>) jsons.get(0).get(key));
    }
    
    public ResponseJson getJson(int index) {
        return new ResponseJson(jsons.get(index));
    }
    
    @SuppressWarnings("unchecked")
    public ResponseJson getJsons(String key) {
        return new ResponseJson((List<Map<String, Object>>) jsons.get(0).get(key));
    }
    
    public Object[] getArray(String key) {
        return (Object[]) jsons.get(0).get(key);
    }
    
    public String getString(String key) {
        return (String) jsons.get(0).get(key);
    }
    
    public long getLong(String key) {
        return (Long) jsons.get(0).get(key);
    }
    
    public double getDouble(String key) {
        return (Double) jsons.get(0).get(key);
    }
}
