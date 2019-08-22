package com.yihuisoft.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 *
 * @author tonywu
 * @version v1.0.0
 */
public class DateUtil {

    /**
     * yyyy格式
     */
    public static final String sdfyyyy = "yyyy";
    /**
     * yyyy-MM-dd格式
     */
    public static final String sdfyyyy_MM_dd = "yyyy-MM-dd";
    /**
     * yyyy年MM月dd日格式
     */
    public static final String sdfyyyyCMMCddC = "yyyy年MM月dd日";
    /**
     * yyyyMMdd格式
     */
    public static final String sdfyyyyMMdd = "yyyyMMdd";
    /**
     * yyyy-MM-dd HH:mm:ss格式
     */
    public static final String sdfyyyy_MM_ddHHmmss = "yyyy-MM-dd HH:mm:ss";
    /**
     * yyyy-MM-dd HH:mm格式
     */
    public static final String sdfyyyy_MM_ddHHmm = "yyyy-MM-dd HH:mm";
    /**
     * yyyy年MM月dd日 HH:mm:ss格式
     */
    public static final String sdfyyyyCMMCddCHHmmss = "yyyy年MM月dd日 HH:mm:ss";
    /**
     * HH:mm:ss格式
     */
    public static final String sdfHHmmss = "HH:mm:ss";
    /**
     * yyyyMMddHHmmss格式
     */
    public static final String sdfyyyyMMddHHmmss = "yyyyMMddHHmmss";
    /**
     * yyyyMM格式
     */
    public static final String sdfyyyyMM = "yyyyMM";
    /**
     * yyyy-MM格式
     */
    public static final String sdfyyyy_MM = "yyyy-MM";
    /**
     * MMdd格式
     */
    public static final String sdfMMdd = "MMdd";
    /**
     * HHmm格式
     */
    public static final String sdfHHmm = "HHmm";

    /**
     * 获取当前时间
     *
     * @return 当前时间字符串（格式：yyyyMMddHHmmss）
     */
    public static String getSdfTimes() {
        return new SimpleDateFormat(sdfyyyyMMddHHmmss).format(new Date());
    }

    /**
     * 获取当前年月
     *
     * @return 当前年月（格式：YYYY-MM）
     */
    public static String getMonth() {
        return new SimpleDateFormat(sdfyyyy_MM).format(new Date());
    }


    /**
     * 获取上一年月
     *
     * @return 上一年月（格式：yyyyMM）
     */
    public static String getLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
        return dft.format(cal.getTime());
    }

    /**
     * 获取下一年月.
     *
     * @return 下一年月（格式：yyyyMM）
     */
    public static String getPreMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
        return dft.format(cal.getTime());
    }

    /**
     * 获取当前年份
     *
     * @return 当前年份（格式：yyyy）
     */
    public static String getYear() {
        return new SimpleDateFormat(sdfyyyy).format(new Date());
    }

    /**
     * 获取当前日期
     *
     * @return 当前日期（格式：YYYY-MM-DD）
     */
    public static String getDay() {
        return new SimpleDateFormat(sdfyyyy_MM_dd).format(new Date());
    }

    /**
     * 获取当前日期
     *
     * @return 当前日期（格式：YYYYMMDD）
     */
    public static String getDays() {
        return new SimpleDateFormat(sdfyyyyMMdd).format(new Date());
    }


    /**
     * 获取当前时间
     *
     * @return 当前时间（格式：YYYY-MM-DD HH:mm:ss）
     */
    public static String getTime() {
        return new SimpleDateFormat(sdfyyyy_MM_ddHHmmss).format(new Date());
    }

    /**
     * @param s 日期1（格式：yyyy-MM-dd）
     * @param e 日期2（格式：yyyy-MM-dd）
     * @return boolean  如果日期1大于日期2则返回true
     * @throws
     * @Title: compareDate
     * @Description: TODO(日期比较 ， 如果s > = e 返回true 否则返回false)
     * @author fh
     */
    public static boolean compareDate(String s, String e) {
        if (fomatDate(s) == null || fomatDate(e) == null) {
            return false;
        }
        return fomatDate(s).getTime() >= fomatDate(e).getTime();
    }

    /**
     * 将日期字符串转换为日期对象
     *
     * @param date 日期字符串（格式：yyyy-MM-dd）
     * @return 转换后的日期对象
     */
    public static Date fomatDate(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (date == null || "".equals(date) || "null".equals(date))
                return null;

            return fmt.parse(date);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }

    /**
     * 将日期字符串转换为日期对象,日期格式自定义
     *
     * @param date  日期字符串
     * @param sdfmt 日期格式
     * @return 日期对象
     */
    public static Date fomatDate(String date, String sdfmt) {
        try {
            if (date == null || "".equals(date) || "null".equals(date))
                return null;

            return new SimpleDateFormat(sdfmt).parse(date);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }


    /**
     * 将日期对象转换为日期字符串
     *
     * @param date  日期对象
     * @param sdfmt 日期格式
     * @return 转换后的字符串
     */
    public static String fomatDate(Date date, String sdfmt) {
        try {
            if (date == null)
                return null;
            return new SimpleDateFormat(sdfmt).format(date);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static Date fomatDateToDate(Date date, String sdfmt) {
        return fomatDate(fomatDate(date, sdfmt), sdfmt);
    }

    /**
     * 校验日期格式是否是yyyy-MM-dd
     *
     * @return 如果是则返回true，否则返回false
     */
    public static boolean isValidDate(String s) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fmt.parse(s);
            return true;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

    /**
     * 计算两个日期的相差几年，不足一年的按0算
     *
     * @param startTime 开始日期（格式：yyyy-MM-dd）
     * @param endTime   结束日期（格式：yyyy-MM-dd）
     * @return 年份差
     */
    public static int getDiffYear(String startTime, String endTime) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            System.out.println(e);
            return 0;
        }
    }

    /**
     * <li>功能描述：计算两个时间相差几天
     *
     * @param beginDateStr 开始日期字符串（格式：yyyy-MM-dd）
     * @param endDateStr   结束日期字符串（格式：yyyy-MM-dd）
     * @return long 相差天数
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;

        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println(e);
        }
        if (beginDate != null && endDate != null)
            day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }

    /**
     * <li>功能描述：计算两个时间相差多少秒
     *
     * @param beginDateStr 开始时间（格式：yyyy-MM-dd HH:mm:ss）
     * @param endDateStr   结束时间（格式：yyyy-MM-dd HH:mm:ss）
     * @return long 相差的秒数
     * @author Administrator
     */
    public static long getDaySubTime(String beginDateStr, String endDateStr) {
        long second = 0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;

        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            System.out.println(e);
        }
        if (beginDate != null && endDate != null)
            second = (endDate.getTime() - beginDate.getTime()) / (1000);

        return second;
    }


    /**
     * 获取当前时间，n天之后的时间
     *
     * @param days 天数
     * @return 时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    public static String getAfterDayDate(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdfd.format(date);
    }

    /**
     * 获取当前时间，n天之后的时间
     *
     * @param days 天数
     * @return 时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    public static String getAfterDayDate(int days) {
        int daysInt = days;

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdfd.format(date);
    }

    /**
     * 得到n天之后的日期对象
     *
     * @param days 天数
     * @return 日期对象
     */
    public static Date getAfterDay(int days) {
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, days); // 日期减 如果不够减会将月变动
        return canlendar.getTime();
    }

    /**
     * 得到n天之后的日期
     *
     * @param days
     * @return
     */
    public static Date getAfterDay(int days, String sdfmt) {
        return fomatDate(fomatDate(getAfterDay(days), sdfmt), sdfmt);
    }

    /**
     * 获取当前月的天数
     *
     * @return 天数
     */
    public static int getDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getActualMaximum(Calendar.DATE);
    }

    /**
     * 根据指定时间得到n小时之后的时间
     *
     * @param date 日期对象
     * @param n    小时数
     * @return n小时后的日期对象
     */
    public static Date getAfterHour(Date date, int n) {
        Calendar canlendar = Calendar.getInstance();
        canlendar.setTime(date);
        canlendar.add(Calendar.HOUR, n);
        return canlendar.getTime();
    }

    /**
     * 得到n天之后是周几
     *
     * @param days 天数
     * @return 星期几
     */
    public static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        return sdf.format(date);
    }

    /**
     * 返回第一个参数加上第二个参数（天）之后的日期
     *
     * @param date 日期对象
     * @param day  天数
     * @return 相加后的日期对象
     */
    public static Date getDateNext(Date date, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * 根据日期字串,传入几天,得到向后几天日期
     *
     * @param date 日期
     * @param day  几天
     * @return
     */
    public static Date getDateNext(String date, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(fomatDate(date));
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * 获取当前月，前几个月的年月
     *
     * @param monthNum 月数
     * @return 年月（格式：yyyyMM）
     */
    public static String getLastMonth(int monthNum) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1 * monthNum);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        return dateFormat.format(c.getTime());
    }

    /**
     * 下月第一天
     *
     * @return 返回日期对象
     */
    public static Date nextMonthFirstDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 上月第一天
     *
     * @return 返回日期对象
     */
    public static Date lastMonthFirstDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 将日期中的时分秒清零
     *
     * @param date 日期对象
     * @return 时分秒清零后的日期对象
     */
    public static Date getDayStart(Date date) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        return cal1.getTime();
    }

    /**
     * 获取，以1970/01/01作为起点，经过若干秒后的日期
     *
     * @param timeStamp 秒数
     * @return 日期对象
     */
    public static Date getDateByTimeStamp(Long timeStamp) {
        return new Date(timeStamp * 1000);
    }

    /**
     * 获取，以1970/01/01作为起点，经过若干秒后的日期
     *
     * @param timeStampMs 毫秒数
     * @return 日期对象
     */
    public static Date getDateByTimeStampMs(Long timeStampMs) {
        return new Date(timeStampMs);
    }

    /**
     * 获取传入时间的秒数，以1970/01/01为基础
     *
     * @param date 日期对象
     * @return 秒数
     * @throws Exception
     */
    public static long getTimeStampByDate(Date date) {
        long stamp = 0L;
        Date date1 = date;
        Date date2 = null;
        try {
            date2 = (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).parse("1970/01/01 08:00:00");
            stamp = (date1.getTime() - date2.getTime()) / 1000L;
        } catch (Exception e) {
            stamp = 0L;
        }

        return stamp;
    }

    /**
     * 获取传入时间的毫秒数，以1970/01/01为基础
     *
     * @param date 日期对象
     * @return 毫秒值
     * @throws Exception
     */
    public static long getTimeStampMsByDate(Date date) {
        long stamp = 0L;
        Date date1 = date;
        Date date2 = null;
        try {
            date2 = (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).parse("1970/01/01 08:00:00");
            stamp = (date1.getTime() - date2.getTime());
        } catch (Exception e) {
            stamp = 0L;
        }

        return stamp;
    }

    /**
     * 获取当前时间之前或之后几小时 hour
     *
     * @param hour 小时数（若为正数就是之后几小时，若为负数则是之前几小时）
     * @return 日期对象
     */
    public static Date getTimeByHour(int hour) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);

        //return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
        return calendar.getTime();
    }

    /**
     * 获取当前时间
     *
     * @return 当前时间HH:mm:ss
     */
    public static String getTimes() {
        return new SimpleDateFormat(sdfHHmmss).format(new Date());
    }

    /**
     * main函数
     *
     * @param args

    public static void main(String[] args) {
    System.out.println(getSdfTimes());
    System.out.println(getMonth());
    System.out.println(getLastMonth());
    System.out.println(getPreMonth());
    System.out.println(getYear());
    System.out.println(getDay());
    System.out.println(getDays());
    System.out.println(getTime());
    System.out.println(compareDate("2019-08-09", "2019-07-09"));
    System.out.println(getDiffYear("2001-06-09", "2019-07-09"));
    System.out.println(getDaySub("2019-06-09", "2019-07-09"));
    System.out.println(getDaySubTime("2019-07-09 09:28:09", "2019-07-09 10:28:09"));
    System.out.println(getAfterDayDate("2"));
    System.out.println(getAfterDay(2));
    System.out.println(getDayOfMonth());
    System.out.println(getAfterHour(new Date(), 2));
    System.out.println(getAfterDayWeek("2"));
    System.out.println(getLastMonth(2));
    System.out.println(nextMonthFirstDate());
    System.out.println(lastMonthFirstDate());
    System.out.println(getDateByTimeStamp(3600*24L));
    System.out.println(getDateByTimeStampMs(1000*3600*24L));
    System.out.println(getTimeByHour(-3));
    System.out.println(getTimes());
    }
     */
}
