package com.musula.backend.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ObjectUtils {
    private ObjectUtils() {
    }

    public static Boolean isNull(Object obj) {
        return obj == null;
    }


    public static LocalDateTime getUTCDateTimeNow() {
        return LocalDateTime.now(ZoneOffset.UTC);
    }

    public static Date convertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneOffset.UTC).toInstant());
    }

    public static LocalDateTime toLocalDateTime(String date) {
        if (date == null || date.isEmpty())
            return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date.replace(" UTC", ""), formatter);
    }

    public static LocalDate toLocalDate(String pattern, String date) {
        if (date == null || date.isEmpty())
            return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, formatter);
    }
}
