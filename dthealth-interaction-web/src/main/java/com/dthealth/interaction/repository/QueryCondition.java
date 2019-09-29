package com.dthealth.interaction.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryCondition {
    public final static char EXACT = 0;
    public final static char FUZZY = 1;
    public final static char SEGMENTATION_IN = 2;
    public final static char SEGMENTATION_GREATER = 3;
    public final static char SEGMENTATION_LESS = 4;
    public final static String QUERY_TYPE="queryType";
    public final static String ATTRIBUTE="attribute";
    public final static String VALUE="value";
    public final static String GREATER="greater";
    public final static String LESS="less";
    public final static char ASC = 0;
    public final static char DESC = 1;
    private String attribute;
    private String orderedAttribute;
    private char orderType;
    private List<Map<String,Object>> list = new ArrayList<>();
    private Map<String,Object> map;
    public void addPageSearch(char queryType, String attribute, Object... value) {
        map = new HashMap<>();
        map.put(QUERY_TYPE,queryType);
        map.put(ATTRIBUTE,attribute);
        if(queryType==SEGMENTATION_IN){
            map.put(GREATER,value[0]);
            map.put(LESS,value[1]);
        }
        map.put(VALUE,value);
        list.add(map);
    }
    public void addSearch(char queryType, String attribute, Object value){
        map = new HashMap<>();
        map.put(QUERY_TYPE,queryType);
        map.put(ATTRIBUTE,attribute);
        map.put(VALUE,value);
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getOrderedAttribute() {
        return orderedAttribute;
    }

    public void setOrderedAttribute(String orderedAttribute) {
        this.orderedAttribute = orderedAttribute;
    }

    public char getOrderType() {
        return orderType;
    }

    public void setOrderType(char orderType) {
        this.orderType = orderType;
    }

    public List<Map<String, Object>> getList() {
        return list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }
}
