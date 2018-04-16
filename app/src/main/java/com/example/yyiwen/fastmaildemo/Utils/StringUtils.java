package com.example.yyiwen.fastmaildemo.Utils;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by y.yiwen on 4/6/2016.
 */
public class StringUtils {
    /**
     * 提示输入内容超过规定长度
     * @param context
     * @param editText
     * @param max_length
     * @param err_msg
     */
    public static void lengthFilter( final Context context, EditText editText,
                                     final int max_length, final String err_msg){

        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(max_length){

            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                // TODO Auto-generated method stub
                //获取字符个数(一个中文算2个字符)
                int destLen = StringUtils.getCharacterNum(dest.toString());
                int sourceLen = StringUtils.getCharacterNum(source.toString());
                if(destLen + sourceLen > max_length){
                   UIUtils.showToastSafe(err_msg);
                    return "";
                }
                return source;
            }
        };
        editText.setFilters(filters);
    }
    /**
     *
     * @param content
     * @return
     */
    public static int getCharacterNum(String content){
        if(content.equals("")||null == content){
            return 0;
        }else {
            return content.length()+getChineseNum(content);
        }

    }
    /**
     * 计算字符串的中文长度
     * @param s
     * @return
     */
    public static int getChineseNum(String s){
        int num = 0;
        char[] myChar = s.toCharArray();
        for(int i=0;i<myChar.length;i++){
            if((char)(byte)myChar[i] != myChar[i]){
                num++;
            }
        }
        return num;
    }
    //过滤特殊字符
    public static String stringFilter(String str)throws PatternSyntaxException {
        // 只允许字母、数字和汉字
        String   regEx  =  "[^a-zA-Z0-9\u4E00-\u9FA5]";
        Pattern p   =   Pattern.compile(regEx);
        Matcher m   =   p.matcher(str);
        return   m.replaceAll("").trim();
    }
    //过滤汉字
    public static String filterChinese(String chin)
    {
        chin = chin.replaceAll("[^^(a-zA-Z0-9)]", "");
        return chin;
    }

    //身份证号验证
    public static boolean personIdValidation(String text) {
        String regx = "[0-9]{17}x";
        String reg1 = "[0-9]{15}";
        String regex = "[0-9]{18}";
        return text.matches(regx) || text.matches(reg1) || text.matches(regex);
    }
    //加一个月
    public static String dateAddFormat(String datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = sdf.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cl = Calendar.getInstance();
        if(date!=null) {
            cl.setTime(date);
        }
        cl.add(Calendar.MONTH,+1);
        date = cl.getTime();
        return sdf.format(date);
    }
    //减一个月
    public static String dateReduceFormat(String datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = sdf.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cl = Calendar.getInstance();
        if(date!=null) {
            cl.setTime(date);
        }
        cl.add(Calendar.MONTH,-1);
        date = cl.getTime();
        return sdf.format(date);
    }
    public static String dateFormat(String datetime) {
        String str = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = sdf.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(date!=null) {
            str= sdf.format(date);
        }
        return str;
    }
    public static String getSpecifiedMonthAfter(String specified, int month) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy/MM").parse(specified);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(date!=null) {
            c.setTime(date);
        }
        c.add(Calendar.MONTH, month);
//      int day = c.get(Calendar.DATE);
//      c.set(Calendar.DATE, day - 1);
        String dayAfter = new SimpleDateFormat("yyyy/MM").format(c.getTime());
        return dayAfter;
    }
}
