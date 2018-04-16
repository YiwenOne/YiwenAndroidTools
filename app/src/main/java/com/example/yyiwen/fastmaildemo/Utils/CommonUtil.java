package com.example.yyiwen.fastmaildemo.Utils;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.jauker.widget.BadgeView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用工具
 *
 * @date 2015-10-30
 * @time 下午9:22:25
 */
public class CommonUtil {

    private static Matcher matcher;
    private static BadgeView badgeView;

    //保留两位小数
    public static double getTwoDouble(String carLossBef) {
        BigDecimal zemvalue = new BigDecimal(carLossBef);
        double carLossCos = zemvalue.setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        return carLossCos;
    }

    /**
     * Java Calender类获得指定日期加N月
     *
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedMonthAfter(String specified, int month) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specified);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.add(Calendar.MONTH, month);
//      int day = c.get(Calendar.DATE);
//      c.set(Calendar.DATE, day - 1);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }

    public static List<String> insureUtils(String insureItem) {
        mInsureIntem = new ArrayList<String>();
        String[] split = insureItem.split("\\},");
        Pattern pattern = Pattern.compile("t\\\":(.*)");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i].toString());
            if (i == split.length - 1) {
                pattern = Pattern.compile("t\\\":(.*)\\}");
            }
            matcher = pattern.matcher(split[i].toString());
            while (matcher.find()) {
                System.out.println(matcher.group(1));
                String a = matcher.group(1);
                mInsureIntem.add(a);
            }
        }
        return mInsureIntem;
    }

    public static List<String> mInsureIntem;

    public static void showInfoDialog(Context context, String message) {
        showInfoDialog(context, message, "提示", "确定", null);
    }

    public static void showInfoDialog(Context context, String message,
                                      String titleStr, String positiveStr,
                                      DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(context);
        localBuilder.setTitle(titleStr);
        localBuilder.setMessage(message);
        if (onClickListener == null)
            onClickListener = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            };
        localBuilder.setPositiveButton(positiveStr, onClickListener);
        localBuilder.show();
    }

    public static void setRedIcon(View view, int number) {
        if (number > 0) {
            if (badgeView == null) {
                badgeView = new BadgeView(UIUtils.getContext());
                badgeView.setTargetView(view);
                badgeView.setBadgeGravity(Gravity.RIGHT | Gravity.TOP);
            }
//          badgeView.setBackgroundResource(R.drawable.yuandian);
            if (number > 99) {
                badgeView.setText("99+");
            } else {
                badgeView.setText(String.valueOf(number));
            }
        } else {
            badgeView.setVisibility(View.GONE);
        }
    }


    public static BadgeView getBadgeV(View v, String str) {
        BadgeView mBadgeView = new BadgeView(UIUtils.getContext());
        mBadgeView.setTargetView(v);
        if (Integer.parseInt(str) > 99) {
            mBadgeView.setText("99+");
        } else {
            mBadgeView.setText(str);
        }
        mBadgeView.setBadgeGravity(Gravity.RIGHT | Gravity.TOP);
        v.setVisibility(View.VISIBLE);
        return mBadgeView;
    }


    public static String md5(String paramString) {
        String returnStr;
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(paramString.getBytes());
            returnStr = byteToHexString(localMessageDigest.digest());
            return returnStr;
        } catch (Exception e) {
            return paramString;
        }
    }


    /**
     * 将指定byte数组转换成16进制字符串
     *
     * @param b
     * @return
     */
    public static String byteToHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            hexString.append(hex.toUpperCase());
        }
        return hexString.toString();
    }

    /*
      判断当前是否有可用的网络以及网络类型 0：无网络 1：WIFI 2：CMWAP 3：CMNET
      @param context
      @return
     */
    public static int isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return 0;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        NetworkInfo netWorkInfo = info[i];
                        if (netWorkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                            return 1;
                        } else if (netWorkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                            String extraInfo = netWorkInfo.getExtraInfo();
                            if ("cmwap".equalsIgnoreCase(extraInfo)
                                    || "cmwap:gsm".equalsIgnoreCase(extraInfo)) {
                                return 2;
                            }
                            return 3;
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 获取现在时间
     *
     * @return 返回短时间字符串格式yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate(String mdata) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(mdata, Locale.CHINA);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String getGSTime(String oriTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //当前日期
//        long time = System.currentTimeMillis();
//        String currentDate = dateFormat.format(new Date(oriTime));
        Date createDate = new Date(oriTime);
        String createDateStr = dateFormat.format(createDate);
        return createDateStr;
    }

    //时间判断
    public static String changeTime(String netTime) {
        if (netTime != null) {
            String currentTime = CommonUtil.getStringDate("yyyy/MM/dd HH:mm:ss");
            String gsTime = getGSTime(netTime);

            String[] currentSplit = currentTime.split(" ");
            String[] netSplit = gsTime.split(" ");

            String result = "";
            //如果是当天的话
            if (currentSplit[0].equals(netSplit[0])) {
                result = netSplit[1].substring(0, 5);
            } else {
                result = netSplit[0];
            }
            return result;
        } else {
            return "";
        }
    }

    public static String monthAndYear(String netTime) {
        if (netTime != null) {
            String currentTime = CommonUtil.getStringDate("yyyy-MM");
            String gsTime = getGSMYTime(netTime);

            String[] currentSplit = currentTime.split(" ");
            String[] netSplit = gsTime.split(" ");

            String result = "";
            //如果是当天的话
            if (currentSplit[0].equals(netSplit[0])) {
                result = netSplit[1].substring(0, 5);
            } else {
                result = netSplit[0];
            }
            return result;
        } else {
            return "";
        }
    }

    public static String getGSMYTime(String netTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        //当前日期
//        long time = System.currentTimeMillis();
//        String currentDate = dateFormat.format(new Date(oriTime));
        Date createDate = new Date(netTime);
        String createDateStr = dateFormat.format(createDate);
        return createDateStr;
    }
    public static String getYearMonth(String netTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
        //当前日期
//        long time = System.currentTimeMillis();
//        String currentDate = dateFormat.format(new Date(oriTime));
        Date createDate = new Date(netTime);
        String createDateStr = dateFormat.format(createDate);
        return createDateStr;
    }
    public static String getYearMonthDay(String netTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        //当前日期
//        long time = System.currentTimeMillis();
//        String currentDate = dateFormat.format(new Date(oriTime));
        Date createDate = new Date(netTime);
        String createDateStr = dateFormat.format(createDate);
        return createDateStr;
    }

    public static String getShifen(String netTime) {
        if (netTime != null) {
            String currentTime = CommonUtil.getStringDate("yyyy/MM/dd HH:mm:ss");
            String gsTime = getGSTime(netTime);

            String[] netSplit = gsTime.split(" ");

            return netSplit[1].substring(0, 5);
        } else {
            return "";
        }
//        String[] split = time.split(" ");
//        String substring = split[1].substring(0, 4);
//        return substring;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int getScreenPicHeight(int screenWidth, Bitmap bitmap) {
        int picWidth = bitmap.getWidth();
        int picHeight = bitmap.getHeight();
        int picScreenHeight = 0;
        picScreenHeight = (screenWidth * picHeight) / picWidth;
        return picScreenHeight;
    }

    private static Drawable createDrawable(Drawable d, Paint p) {

        BitmapDrawable bd = (BitmapDrawable) d;
        Bitmap b = bd.getBitmap();
        Bitmap bitmap = Bitmap.createBitmap(bd.getIntrinsicWidth(),
                bd.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(b, 0, 0, p); // 关键代码，使用新的Paint画原图，

        return new BitmapDrawable(bitmap);
    }

    /**
     * 设置Selector。 本次只增加点击变暗的效果，注释的代码为更多的效果
     */
    public static StateListDrawable createSLD(Context context, Drawable drawable) {
        StateListDrawable bg = new StateListDrawable();
        int brightness = 50 - 127;
        ColorMatrix cMatrix = new ColorMatrix();
        cMatrix.set(new float[]{1, 0, 0, 0, brightness, 0, 1, 0, 0,
                brightness,// 改变亮度
                0, 0, 1, 0, brightness, 0, 0, 0, 1, 0});

        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(cMatrix));
        // p.setColor(0x60111111); //Paint ARGB色值，A = 0x40 不透明。RGB222222 暗色

        Drawable normal = drawable;
        Drawable pressed = createDrawable(drawable, paint);
        // p = new Paint();
        // p.setColor(0x8000FF00);
        // Drawable focused = createDrawable(drawable, p);
        // p = new Paint();
        // p.setColor(0x800000FF);
        // Drawable unable = createDrawable(drawable, p);
        // View.PRESSED_ENABLED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_pressed,}, pressed);
        bg.addState(new int[]{android.R.attr.state_focused,}, pressed);
        // View.ENABLED_FOCUSED_STATE_SET
        // bg.addState(new int[] { android.R.attr.state_enabled,
        // android.R.attr.state_focused }, focused);
        // View.ENABLED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_selected}, pressed);
        // View.FOCUSED_STATE_SET
        // bg.addState(new int[] { android.R.attr.state_focused }, focused);
        // // View.WINDOW_FOCUSED_STATE_SET
        // bg.addState(new int[] { android.R.attr.state_window_focused },
        // unable);
        // View.EMPTY_STATE_SET
        bg.addState(new int[]{}, normal);
        return bg;
    }

    private static boolean hasMethod(String methodName, Method[] method) {
        for (Method m : method) {
            if (methodName.equals(m.getName())) {
                return true;
            }
        }
        return false;
    }


    /**
     * 把输入流转换成字符串
     *
     * @param is
     * @return
     */
    public static String readStream(InputStream is) {
        String result = null;
        try {
            // 输出流对象
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            is.close();
            result = new String(baos.toByteArray(), "UTF-8");
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 非空验证
     * true:空
     * false:不空
     */
    public static boolean isEmpty(String value) {
        if (value == null || value.equals(""))
            return true;
        return false;
    }

    public static String getData(String netTime) {
        if (netTime != null) {
            String currentTime = CommonUtil.getStringDate("yyyy/MM/dd HH:mm:ss");
            String gsTime = getGSTime(netTime);

            String[] netSplit = gsTime.split(" ");

            return netSplit[0];
        } else {
            return "";
        }
    }

    public static String getYMDTime(String netTime) {
        if (netTime != null) {
            String currentTime = CommonUtil.getStringDate("yyyy/MM/dd");
            String gsTime = getGSTime(netTime);

            String[] netSplit = gsTime.split(" ");

            return netSplit[0];
        } else {
            return "";
        }
    }

    public static String getGSYMDData(String netTime) {
        if (netTime != null) {
            String gsTime = changeGSYMDTime(netTime);
            String[] netSplit = gsTime.split(" ");
            return netSplit[0];
        } else {
            return "";
        }
    }

    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 800) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    public static String changeGSYMDTime(String deliveryTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //当前日期
//        long time = System.currentTimeMillis();
//        String currentDate = dateFormat.format(new Date(oriTime));
        Date createDate = new Date(deliveryTime);
        String createDateStr = dateFormat.format(createDate);
        return createDateStr;
    }

    /*
     * 根据edittext的输入状况
     *      去改变button背景色的状态
     */
    public static class CustomerTextBack implements TextWatcher {

        public EditText editText;
        public Button button;

        public CustomerTextBack(EditText editText, Button button) {
            this.editText = editText;
            this.button = button;
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!TextUtils.isEmpty(editText.getText().toString().trim())) {
                button.setBackgroundColor(Color.parseColor("#06A0EA"));
                button.setTextColor(Color.parseColor("#FFFFFF"));
            } else {
                button.setBackgroundColor(Color.parseColor("#D4D4D4D4"));
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }


    //遍历数组
    public static String ergodicArray(List list) {
        String user = " ";
        if (list.size() == 1) {
            user = list.get(0).toString();
        } else {
            for (int i = 0; i < list.size(); i++) {
                user = list.get(i).toString() + " " + user;
            }
        }
        return user;
    }

    //显示日期格式--yyyy/MM/dd
    public static String paureDate(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String date = null;
        try {
            date = String.valueOf(format.parse(dateStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 显示时间格式为 hh:mm
     */
    public static String formatTimeShort(String time) {
        String formatStr = "HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        String temp = sdf.format(time);
        return temp;
    }
}
