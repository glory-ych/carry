package com.ytud.common.util;

/**
 * yangch 2016/7/28
 */
public class NumberUtil {

    /**
     * 字符串转十六进制
     *
     * @param str
     * @return
     */
    public static String string2Hex(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }
        return sb.toString();
    }

    /**
     * 十六进制转二进制
     * @param hex
     * @return
     */
    public static String hex2binary(String hex) {
        if (hex == null || hex.length() % 2 != 0)
            return null;
        StringBuilder sb = new StringBuilder();
        String tmp = "";
        for (int i = 0; i < hex.length(); i++) {
            tmp = "0000" + Integer.toBinaryString(Integer.parseInt(hex.substring(i, i + 1), 16));
            sb.append(tmp.substring(tmp.length() - 4));
        }
        return sb.toString();
    }

    /**
     * 进制转换
     *
     * @param obj
     * @param from 原进制
     * @param to   目的进制
     * @return
     */
    public static String radixConvert(Object obj, int from, int to) {
        Integer data = 0;
        if (obj instanceof String) {
            data = Integer.valueOf(obj.toString(), from);
        }
        if (to == 2) {
            return Integer.toBinaryString(data);
        } else if (to == 8) {
            return Integer.toOctalString(data);
        } else if (to == 10) {
            return data.toString();
        } else if (to == 16) {
            return Integer.toHexString(data);
        } else {
            return null;
        }
    }
}
