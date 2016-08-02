import com.alibaba.druid.sql.visitor.functions.Char;
import com.ytud.api.ProjectApi;
import com.ytud.common.model.ProjectModel;
import com.ytud.common.util.DateUtil;
import com.ytud.common.util.JacksonUtil;
import com.ytud.common.util.MD5Util;
import com.ytud.common.util.NumberUtil;
import com.ytud.provider.impl.ProjectApiImpl;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.awt.geom.Line2D;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * yangch 2016/7/27
 */
public class Test {
    @Resource
    private ProjectApi projectApi;

    //@Before
//    public void before(){
//        System.out.println("before");
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        projectApiImpl = (ProjectApiImpl) ac.getBean("projectApiImpl");
//        System.out.println(projectApiImpl);
//    }
    @org.junit.Test
    public void demo() {
        System.out.println(projectApi);
        ProjectModel project = projectApi.getProject(2);
        System.out.println(project.getProjectName());
    }

    @org.junit.Test
    public void demo2() {
        Map<String, String> m1 = new HashMap<String, String>();
        m1.put("name", "ych");
        m1.put("address", "beijing");
        String m1s = JacksonUtil.object2string(m1);
        Map<String, String> m2 = new HashMap<String, String>();
        m2.put("data", m1s);
        m2.put("sign", "ljoafdfn");
        System.out.println(JacksonUtil.object2string(m2));

        Map<String, Object> m3 = new HashMap<String, Object>();
        m3.put("data", m1);
        m3.put("sign", "ljoafdfn");
        System.out.println(JacksonUtil.object2string(m3));
    }

    @org.junit.Test
    public void demo03() {
        System.out.println(DateUtil.getDateFormat("yyMMdd"));
    }

    @org.junit.Test
    public void demo04() {
        Map<String, String> m1 = new HashMap<String, String>();
        m1.put("name", "ych");
        m1.put("address", "beijing");
        System.out.println(MD5Util.getMD5(JacksonUtil.object2string(m1)));
    }

    @org.junit.Test
    public void demo05() {
        //getDateByPackSn("200975f0369ffdb23");
        String hexStr1 = "2009753ff";
        int a = Integer.parseInt(hexStr1.trim(), 16);
        System.out.println(a);
    }

    @org.junit.Test
    public void demo06() {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = "200975f0369ffdb23".getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }

        System.out.println(hexString2binaryString(sb.toString()));
    }

    public static String hexString2binaryString(String hexString) {
        if (hexString == null || hexString.length() % 2 != 0)
            return null;
        String bString = "", tmp;
        for (int i = 0; i < hexString.length(); i++) {
            tmp = "0000"
                    + Integer.toBinaryString(Integer.parseInt(hexString
                    .substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }
        return bString;
    }

    @org.junit.Test
    public void demo07() {
        String result = NumberUtil.string2Hex("200975f0369ffb56");
        BigInteger bt = new BigInteger("200975f0369ffdb23", 16);
        System.out.println(bt);
        System.out.println(bt.toString(2));

        System.out.println("100000000010010111010111110000001101101001111111111101101100100011".indexOf("0000000010010111010111110000001101101001111111111110000000000000"));
        //long lg = Long.valueOf("200975f0369ffdb23", 16);
        //Long.MAX_VALUE        7fffffffffffffffL
//        result = Long.toBinaryString(lg);
//        result = result.substring(0, 41);
//        lg = Long.parseLong(result, 2);
//        long time = lg - Math.round(Math.pow(2, 40)) + 1 + 1465897230000L;
//        System.out.println(DateUtil.getDateByTime(time, "yyMMdd"));
    }

    @org.junit.Test
    public void demo08() {
//        String result = NumberUtil.string2Hex("200975f0369ffb56");
//        result=NumberUtil.hex2binary(result);
//        System.out.println(result);
        char[] chars = "200975f0369ffdb56".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(Integer.toBinaryString(c));
        }
        System.out.println(sb.toString());
    }

    public static String base_convert(final String inputValue, final int fromBase, final int toBase) {
        if (fromBase < 2 || fromBase > 36 || toBase < 2 || toBase > 36) {
            return null;
        }
        String ret = null;
        try {
            System.out.println("111");
            ret = Integer.toString(Integer.parseInt(inputValue, fromBase), toBase);
        } catch (Exception ex) {
        }
        ;
        return ret;
    }

    @org.junit.Test
    public void demo09() {
        System.out.println(MD5Util.getMD5("ftdtiam").toLowerCase());
    }

    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getDateByPackSn(String packSn) {
        Long data = Long.parseLong(packSn, 16);//十六进制字符串转long
        String result = Long.toBinaryString(data).substring(0, 41);//截取前41位
        data = Long.parseLong(result, 2);//二进制转十进制
        long time = data - Math.round(Math.pow(2, 40)) + 1 + 1465897230000L;
        return DateUtil.getDateByTime(time, "yyMMdd");
    }

    public static String toHexString(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return "0x" + str;//0x表示十六进制
    }

    @org.junit.Test
    public void demo10() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("ship_info", "ship_info");
        map.put("ship_com", "ship_com");
        map.put("ship_cn", "ship_cn");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("obj", JacksonUtil.object2string(map));
        System.out.println(MD5Util.getMD5(JacksonUtil.object2string(map2)));
    }

    @org.junit.Test
    public void demo11() {
        StringBuilder result = new StringBuilder();
        for (int i = 97; i <= 122; i++) {
            result.append("'").append((char) i).append("',");
        }
        for (int i = 65; i <= 90; i++) {
            result.append("'").append((char) i).append("',");
        }
        System.out.println(result.toString());
    }

    @org.junit.Test
    public void demo12() {
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] tem = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] result = Arrays.copyOf(chars, chars.length + tem.length);
        System.arraycopy(tem, 0, result, chars.length, tem.length);
        chars = result;
        System.out.println(String.valueOf(chars));
    }

    @org.junit.Test
    public void demo13() {
        String s1 = "ab";
        System.out.println(s1.intern());
        //StringBuilder
        //StringBuffer
        //System.out.println(s1 == (get() + "b").intern());
    }

    public static void get() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return "a";
    }

    public static void main(String[] args) {
        //get();
        byte b=0;
        System.out.println(b&1);
    }
}
