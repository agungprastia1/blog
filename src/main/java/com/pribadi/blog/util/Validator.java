package com.pribadi.blog.util;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

public class Validator {
    public static boolean isNullOrEmpty(Object value) {
        if (null == value) {
            return true;
        } else if (value instanceof String) {
            return value.toString().trim().length() <= 0;
        } else if (value instanceof Collection) {
            return ((Collection)value).isEmpty();
        } else if (value instanceof Map) {
            return ((Map)value).isEmpty();
        } else if (value instanceof Enumeration) {
            return !((Enumeration)value).hasMoreElements();
        } else if (value instanceof Iterator) {
            return !((Iterator)value).hasNext();
        } else {
            boolean arrayFlag = arrayIsNullOrEmpty(value);
            return arrayFlag;
        }
    }

    private static boolean arrayIsNullOrEmpty(Object value) {
        if (value instanceof Object[]) {
            return ((Object[])((Object[])value)).length == 0;
        } else if (value instanceof int[]) {
            return ((int[])((int[])value)).length == 0;
        } else if (value instanceof long[]) {
            return ((long[])((long[])value)).length == 0;
        } else if (value instanceof float[]) {
            return ((float[])((float[])value)).length == 0;
        } else if (value instanceof double[]) {
            return ((double[])((double[])value)).length == 0;
        } else if (value instanceof char[]) {
            return ((char[])((char[])value)).length == 0;
        } else if (value instanceof boolean[]) {
            return ((boolean[])((boolean[])value)).length == 0;
        } else if (value instanceof byte[]) {
            return ((byte[])((byte[])value)).length == 0;
        } else if (value instanceof short[]) {
            return ((short[])((short[])value)).length == 0;
        } else {
            return false;
        }
    }

    public static boolean isNotNullOrEmpty(Object value) {
        return !isNullOrEmpty(value);
    }
}
