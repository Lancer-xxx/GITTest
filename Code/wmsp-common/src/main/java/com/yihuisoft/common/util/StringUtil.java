package com.yihuisoft.common.util;

import java.security.MessageDigest;

import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

import java.util.Random;

/**
 * 字符串处理工具类
 *
 * @author tonywu
 * @version v1.0.0
 */
public class StringUtil {
    private static Random random = new Random();
    private StringUtil(){}

    /**
     * 逗号常量
     */
    public static final String COMMA_STRING_GAP = ",";

    /**
     * 获取字符串编码格式
     *
     * @param str 字符串
     * @return 编码格式(GB2312 | ISO - 8859 - 1 | UTF - 8 | GBK | " ")
     */
    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return encode;
            }
        } catch (Exception exception3) {
        }
        return "";
    }

    /**
     * 随机产生N位验证码，包括数字和大小写字母
     *
     * @param n 位数
     * @return 字符串
     */
    public static String getRandCharString(int n) {
        char[] rand = new char[n];
        String str = "123456789qwertyuipkjhgfdsacvbnmQWERTYUPLKJHGFDSACVBNM";
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(str.length());
            rand[i] = str.charAt(index); // 通过下标获取字符
        }
        return String.valueOf(rand);
    }

    /**
     * 随机产生N位验证码，仅有数字
     *
     * @param n 位数
     * @return 字符串
     */
    public static String getRandNumberStr(int n) {
        char[] rand = new char[n];
        String str = "1234567809";
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(str.length());
            rand[i] = str.charAt(index); // 通过下标获取字符
        }
        return String.valueOf(rand);
    }

    /**
     * 生成指定范围的随机数
     *
     * @param min 最小值
     * @param max 最大值
     * @return 字符串
     */
    public static String getRandNumberStr(int min, int max) {

        int s = random.nextInt(max) % (max - min + 1) + min;
        return String.valueOf(s);
    }

    /**
     * 检测字符串是否不为空(null,"","null")
     *
     * @param s 被检测字符串
     * @return 不为空则返回true，否则返回false
     */
    public static boolean notEmpty(String s) {
        return s != null && !"".equals(s) && !"null".equals(s);
    }

    /**
     * 检测字符串是否为空(null,"","null")
     *
     * @param s 被检测字符串
     * @return 为空则返回true，不否则返回false
     */
    public static boolean isEmpty(String s) {
        return s == null || "".equals(s) || "null".equals(s);
    }

    /**
     * 将字符串用逗号切割后形成数组的长度
     *
     * @param instr 被切割字符串
     * @return 切割形成数组的长度
     */
    public static int splitCount(String instr) {
        if (isEmpty(instr)) {
            return 0;
        }
        return instr.split(COMMA_STRING_GAP).length;
    }

    /**
     * @param jsapiTicket 签名
     * @param timestamp   时间戳
     * @param noncestr    随机字符串
     * @param url         当前网页的URL
     * @return
     */
    public static String wxSignatureJS(String jsapiTicket, String noncestr,
                                       String timestamp, String url) {
        Map<String, String> ret = sign(jsapiTicket, url, noncestr, timestamp);
        return ret.get("signature");
    }

    /**
     * 签名
     *
     * @param jsapiTicket
     * @param url
     * @param nonceStr
     * @param timestamp
     * @return
     */
    public static Map<String, String> sign(String jsapiTicket, String url,
                                           String nonceStr, String timestamp) {
        Map<String, String> ret = new HashMap<String, String>();
        String string1;
        String signature = "";
        String[] paramArr = new String[]{"jsapiTicket=" + jsapiTicket,
                "timestamp=" + timestamp, "nonceStr=" + nonceStr, "url=" + url};
        Arrays.sort(paramArr);
        // 将排序后的结果拼接成一个字符串
        string1 = paramArr[0].concat("&" + paramArr[1])
                .concat("&" + paramArr[2]).concat("&" + paramArr[3]);
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
            LoggerUtils.info("signature:" + signature);
        } catch (Exception e) {
            LoggerUtils.error("\n>>生成签名失败", e);
        }
        ret.put("url", url);
        ret.put("jsapiTicket", jsapiTicket);
        ret.put("nonceStr", nonceStr);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        return ret;
    }

    /**
     * 将字节数组转换成16进制字符串
     *
     * @param hash 被处理的字节数组
     * @return 转换后的16进制字符串
     */
    public static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
