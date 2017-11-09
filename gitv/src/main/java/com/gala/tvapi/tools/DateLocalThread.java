package com.gala.tvapi.tools;

import com.gala.tvapi.tv2.TVApiBase;
import com.tvos.apps.utils.DateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.cybergarage.soap.SOAP;

public class DateLocalThread {
    private static ThreadLocal<SimpleDateFormat> a = new ThreadLocal<SimpleDateFormat>() {
        protected final /* synthetic */ Object initialValue() {
            return a();
        }

        private synchronized SimpleDateFormat a() {
            return new SimpleDateFormat(DateUtil.PATTERN_STANDARD19H, Locale.getDefault());
        }
    };
    private static Date f197a = new Date();
    private static ThreadLocal<SimpleDateFormat> b = new ThreadLocal<SimpleDateFormat>() {
        protected final /* synthetic */ Object initialValue() {
            return a();
        }

        private synchronized SimpleDateFormat a() {
            return new SimpleDateFormat(DateUtil.PATTERN_STANDARD14W, Locale.getDefault());
        }
    };
    private static ThreadLocal<SimpleDateFormat> c = new ThreadLocal<SimpleDateFormat>() {
        protected final /* synthetic */ Object initialValue() {
            return a();
        }

        private synchronized SimpleDateFormat a() {
            return new SimpleDateFormat(DateUtil.PATTERN_STANDARD08W, Locale.getDefault());
        }
    };
    private static ThreadLocal<SimpleDateFormat> d = new ThreadLocal<SimpleDateFormat>() {
        protected final /* synthetic */ Object initialValue() {
            return a();
        }

        private synchronized SimpleDateFormat a() {
            return new SimpleDateFormat(DateUtil.PATTERN_STANDARD10H, Locale.getDefault());
        }
    };
    private static ThreadLocal<SimpleDateFormat> e = new ThreadLocal<SimpleDateFormat>() {
        protected final /* synthetic */ Object initialValue() {
            return a();
        }

        private synchronized SimpleDateFormat a() {
            return new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());
        }
    };
    private static ThreadLocal<SimpleDateFormat> f = new ThreadLocal<SimpleDateFormat>() {
        protected final /* synthetic */ Object initialValue() {
            return a();
        }

        private synchronized SimpleDateFormat a() {
            return new SimpleDateFormat("MM月dd日 HH:mm", Locale.getDefault());
        }
    };
    private static ThreadLocal<SimpleDateFormat> g = new ThreadLocal<SimpleDateFormat>() {
        protected final /* synthetic */ Object initialValue() {
            return a();
        }

        private synchronized SimpleDateFormat a() {
            return new SimpleDateFormat("MM月dd日", Locale.getDefault());
        }
    };

    public static Date parseYH(String textdate) throws ParseException {
        return ((SimpleDateFormat) a.get()).parse(textdate);
    }

    public static String formatYH(Date date) {
        return ((SimpleDateFormat) a.get()).format(date);
    }

    public static Date parseYH1(String textdate) throws ParseException {
        return ((SimpleDateFormat) b.get()).parse(textdate);
    }

    public static Date parseY(String textdate) throws ParseException {
        return ((SimpleDateFormat) c.get()).parse(textdate);
    }

    public static Date parseY1(String textdate) throws ParseException {
        return ((SimpleDateFormat) d.get()).parse(textdate);
    }

    public static String formatY1(Date date) {
        return ((SimpleDateFormat) d.get()).format(date);
    }

    public static Date parseY2(String textdate) throws ParseException {
        return ((SimpleDateFormat) e.get()).parse(textdate);
    }

    public static String formatY2(Date date) {
        return ((SimpleDateFormat) e.get()).format(date);
    }

    public static Date parseM(String textdate) throws ParseException {
        return ((SimpleDateFormat) f.get()).parse(textdate);
    }

    public static String formatM(Date date) {
        return ((SimpleDateFormat) f.get()).format(date);
    }

    public static Date parseM1(String textdate) throws ParseException {
        return ((SimpleDateFormat) g.get()).parse(textdate);
    }

    public static String formatM1(Date date) {
        return ((SimpleDateFormat) g.get()).format(date);
    }

    public static long getTime(String initIssueTime) {
        if (!(initIssueTime == null || initIssueTime.isEmpty())) {
            Date parseYH;
            if (initIssueTime.contains("-") && initIssueTime.contains(SOAP.DELIM)) {
                try {
                    parseYH = parseYH(initIssueTime);
                    f197a = parseYH;
                    return parseYH.getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if (!(initIssueTime.length() != 14 || initIssueTime.contains("-") || initIssueTime.contains(SOAP.DELIM))) {
                try {
                    parseYH = parseYH1(initIssueTime);
                    f197a = parseYH;
                    return parseYH.getTime();
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
            }
            if (initIssueTime.length() == 13 && !initIssueTime.contains("-") && !initIssueTime.contains(SOAP.DELIM)) {
                return Long.parseLong(initIssueTime);
            }
            if (initIssueTime.length() == 8) {
                try {
                    parseYH = parseY(initIssueTime);
                    f197a = parseYH;
                    return parseYH.getTime();
                } catch (ParseException e22) {
                    e22.printStackTrace();
                }
            }
        }
        return 0;
    }

    public static String parseIssueTime(long time) {
        long currentTime = TVApiBase.getTVApiProperty().getCurrentTime() - time;
        if (currentTime < 60000) {
            return "1分钟前";
        }
        if (currentTime >= 6000 && currentTime < 3600000) {
            return String.valueOf((int) ((currentTime / 1000) / 60)) + "分钟前";
        } else if (currentTime < 3600000 || currentTime >= 86400000) {
            f197a.setTime(time);
            return formatY1(f197a);
        } else {
            return String.valueOf((currentTime / 3600) / 1000) + "小时前";
        }
    }

    public static String parseTimeForHomeCard(long time) {
        long currentTimeMillis = System.currentTimeMillis() - time;
        if (currentTimeMillis < 60000) {
            return "1分钟前";
        }
        if (currentTimeMillis >= 6000 && currentTimeMillis < 3600000) {
            return String.valueOf((int) ((currentTimeMillis / 1000) / 60)) + "分钟前";
        } else if (currentTimeMillis < 3600000 || currentTimeMillis >= 86400000) {
            f197a.setTime(time);
            return formatM1(f197a);
        } else {
            return String.valueOf((currentTimeMillis / 3600) / 1000) + "小时前";
        }
    }
}
