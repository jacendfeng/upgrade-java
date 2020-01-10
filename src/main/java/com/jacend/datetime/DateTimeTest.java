package com.jacend.datetime;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * 格林威治时间
 * 格林威治（又译格林尼治）是英国伦敦南郊原格林威治天文台的所在地，
 * 它是世界计算时间和地球经度的起点，国际经度会议 1884 年在美国华盛顿召开，
 * 会上通过协议，以经过格林威治天文台的经线为零度经线（即本初子午线），
 * 作为地球经度的起点，并以格林威治为“世界时区”的起点。
 *
 * 格林威治时间和北京时间的关系
 * 格林威治时间被定义为世界时间，就是 0 时区，北京是东八区。
 * 也就是说格林威治时间的 1 日 0 点，对应到北京的时间就是 1 日 8 点。
 *
 *
 * 时间戳
 * 时间戳是指格林威治时间 1970-01-01 00:00:00（北京时间 1970-01-01 08:00:00）起至现在的总秒数。
 *
 */
public class DateTimeTest {

    public static void beforeJDK8() {
        // 获取时间
        Date date = new Date();
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        System.out.println(time);

        // 获取时间戳
        long ts = new Date().getTime();
        System.out.println(ts);
        long ts2 = System.currentTimeMillis();
        System.out.println(ts2);
        long ts3 = Calendar.getInstance().getTimeInMillis();
        System.out.println(ts3);

        // 格式化时间 TODO: 线程不安全
        SimpleDateFormat sf  = new SimpleDateFormat("yyyy--MM--dd HH:mm:ss");
        System.out.println(sf.format(new Date()));

        // 获得昨天此刻时间
        Calendar calendar1 = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTime());
    }

    /**
     * JDK 8 对时间操作新增了三个类：LocalDateTime、LocalDate、LocalTime。
     *
     * LocalDate 只包含日期，不包含时间，不可变类，且线程安全。
     * LocalTime 只包含时间，不包含日期，不可变类，且线程安全。
     * LocalDateTime 既包含了时间又包含了日期，不可变类，且线程安全。
     */
    public static void inJDK8() {
        // 获取日期
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        // 获取时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        // 获取日期和时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        // 获取当前时间戳，精确到毫秒
        long milli = Instant.now().toEpochMilli();
        // 获取当前时间戳，精确到秒
        long second = Instant.now().getEpochSecond();
        System.out.println(milli);
        System.out.println(second);

        // 时间格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy--MM--dd HH:mm:ss");
        String timeFormat = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(timeFormat);

        String timeFormat2 = LocalDateTime.now().format(DateTimeFormatter.ISO_WEEK_DATE);
        System.out.println(timeFormat2);


        // 时间装换
        String timeStr = "2019-10-10 06:06:06";
        LocalDateTime dateTime = LocalDateTime.parse(timeStr,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateTime);

        // 获取昨天此刻时间
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.plusDays(-1);
        System.out.println(yesterday);
    }

    public static void main(String[] args) {
        beforeJDK8();
        System.out.println("==============");
        inJDK8();
    }
}
