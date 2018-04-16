package com.example.yyiwen.fastmaildemo.Utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by y.yiwen on 1/28/2016.
 * 货币转换和添加间隔符工具类
 */
public class NumberUtils {
    public static String getMoneyType(String string) {
        // 把string类型的货币转换为double类型。
        Double numDouble = Double.parseDouble(string);
        // 想要转换成指定国家的货币格式
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        // 把转换后的货币String类型返回
        String numString = format.format(numDouble);
        return numString;
    }
    /**
     * 金额显示以千位分割
     */
    public static String parseMoney(String pattern, BigDecimal bd) {
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(bd);
    }

    /**
     * 手机号码加间隔符
     * @param phoneNumber
     * @return
     */
    public static String parsePhoneNumber(String phoneNumber) {
        String str = new String(phoneNumber);
        phoneNumber = str.substring(0, 3) + "-" + str.substring(3, 7) + "-" + str.substring(7, 11);
        return phoneNumber;
    }

    /**
     * 保留两位小数点
     * @param str
     * @return
     */
    public static String saveTwoPoint(String str){
        BigDecimal bd1 = new BigDecimal(str);
        return NumberUtils.parseMoney(",###,###.00", bd1);
    }
}
