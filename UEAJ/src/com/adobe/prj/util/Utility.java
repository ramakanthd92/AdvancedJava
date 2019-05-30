package com.adobe.prj.util;

import java.lang.reflect.Method;

public class Utility {

    public static void sort(Comparable[] elems) {
        for (int i = 0; i < elems.length; i++) {
            for (int j = i + 1; j < elems.length; j++) {
                if(elems[i].compareTo(elems[j]) > 0) {
                    Comparable c = elems[i];
                    elems[i] = elems[j];
                    elems[j] = c;
                }
            }
        }
    }

    public static String getCreateStatement(Class<?> clazz) {
        StringBuilder builder = new StringBuilder();
        Table t = clazz.getAnnotation(Table.class);
        if( t != null) {
            builder.append("create table ");
            builder.append(t.name());
            builder.append("(");
            Method[] methods = clazz.getDeclaredMethods();
            for(Method m : methods) {
                if(m.getName().startsWith("get")) {
                    Column c = m.getAnnotation(Column.class);
                    if(c != null) {
                        builder.append(c.name());
                        builder.append(" ");
                        builder.append(c.type());
                        builder.append(",");
                    }
                }
            }
            builder.setCharAt(builder.lastIndexOf(","), ')');
        }
        return builder.toString();
    }
}