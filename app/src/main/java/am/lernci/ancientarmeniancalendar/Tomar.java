package am.lernci.ancientarmeniancalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Tomar {

    private static final Map<Integer, String> MONTHS;
    private static final Map<Integer, String> DAYS;
    private static final Map<Integer, String> WEEK_DAYS;
    private static final Map<Integer, String> HOURS;
    private GregorianCalendar calendar;

    static {
        HOURS = new HashMap<Integer, String>();
        HOURS.put(1, "Խաւարականն");
        HOURS.put(2, "Աղջամուղջն");
        HOURS.put(3, "Մթացեալն");
        HOURS.put(4, "Շաղաւոտն");
        HOURS.put(5, "Կամաւօտն");
        HOURS.put(6, "Բաւականն");
        HOURS.put(7, "Հաւթափեալն");
        HOURS.put(8, "Գիզկան");
        HOURS.put(9, "Լուսաճեմն");
        HOURS.put(10, "Առաւոտն");
        HOURS.put(11, "Լուսափայլն");
        HOURS.put(12, "Փայլածումն");
        HOURS.put(13, "Այգն");
        HOURS.put(14, "Ծայգն");
        HOURS.put(15, "Զօրացեալն");
        HOURS.put(16, "Ճառագայթեալն");
        HOURS.put(17, "Շառաւիղեալն");
        HOURS.put(18, "Երկրատեսն");
        HOURS.put(19, "Շանթակալն");
        HOURS.put(20, "Հրակաթն");
        HOURS.put(21, "Հուրթափեալն");
        HOURS.put(22, "Թաղանթեալն");
        HOURS.put(23, "Առաւարն");
        HOURS.put(24, "Արփողն");

        DAYS = new HashMap<Integer, String>();
        DAYS.put(1, "Արեգ");
        DAYS.put(2, "Հրանդ");
        DAYS.put(3, "Արամ");
        DAYS.put(4, "Մարգար");
        DAYS.put(5, "Ահրանք");
        DAYS.put(6, "Մադեղ");
        DAYS.put(7, "Աստղիկ");
        DAYS.put(8, "Միհր");
        DAYS.put(9, "Ձոպաբեր");
        DAYS.put(10, "Մուրց");
        DAYS.put(11, "Երեզկան");
        DAYS.put(12, "Անի");
        DAYS.put(13, "Պարխար");
        DAYS.put(14, "Վանատ");
        DAYS.put(15, "Արամազդ");
        DAYS.put(16, "Մանի");
        DAYS.put(17, "Ասակ");
        DAYS.put(18, "Մասիս");
        DAYS.put(19, "Անահիտ");
        DAYS.put(20, "Արագած");
        DAYS.put(21, "Գրգոռ");
        DAYS.put(22, "Կորդուիք");
        DAYS.put(23, "Ծմակ");
        DAYS.put(24, "Լուսնակ");
        DAYS.put(25, "Ցրօն");
        DAYS.put(26, "Նպատ");
        DAYS.put(27, "Վահագն");
        DAYS.put(28, "Սէին");
        DAYS.put(29, "Վարագ");
        DAYS.put(30, "Գիշերավար");

        WEEK_DAYS = new HashMap<Integer, String>();
        WEEK_DAYS.put(1, "Արեգակի օր");   // – կիրակի
        WEEK_DAYS.put(2, "Լուսնի օր");    // – երկուշաբթի
        WEEK_DAYS.put(3, "Հրատի օր");     // – երեքշաբթի
        WEEK_DAYS.put(4, "Փայլածուի օր"); // – չորեքշաբթի
        WEEK_DAYS.put(5, "Լուսնթագի օր"); // – հինգշաբթի
        WEEK_DAYS.put(6, "Արուսյակի օր"); // – ուրբաթ
        WEEK_DAYS.put(7, "Երևակի օր");    // – շաբաթ

        MONTHS = new HashMap<Integer, String>();
        MONTHS.put(1, "Նավասարդի"); // –30 օր
        MONTHS.put(2, "Հոռի");      // –30 օր
        MONTHS.put(3, "Սահմի");     // –30 օր
        MONTHS.put(4, "Տրե");       // –30 օր
        MONTHS.put(5, "Քաղոց");     // –30 օր
        MONTHS.put(6, "Արաց");      // –30 օր
        MONTHS.put(7, "Մեհեկի");    // –30 օր
        MONTHS.put(8, "Արեգի");     // –30 օր
        MONTHS.put(9, "Ահեկի");     // –30 օր
        MONTHS.put(10, "Մարերի");    // –30 օր
        MONTHS.put(11, "Մարգաց");    // –30 օր
        MONTHS.put(12, "Հրոտից");    // –30 օր
        MONTHS.put(13, "Ավելյաց");   // –5 (6) օր
    }

    Tomar() {
        calendar = new GregorianCalendar();
    }

    public GregorianCalendar getCalendar() {
        return calendar;
    }

    private int getDaysDiff() {
        if (calendar.isLeapYear(calendar.get(Calendar.YEAR))) {
            return 223;
        }
        return 222;
    }

    int getDayOfYear() {
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int diff = getDaysDiff();
        if (dayOfYear > diff) {
            return dayOfYear - diff;
        }
        return dayOfYear + 143;
    }

    int getYear() {
        int year = calendar.get(Calendar.YEAR);
        if (calendar.get(Calendar.DAY_OF_YEAR) <= getDaysDiff()) {
            --year;
        }
        return year + 2492;
    }

    int getMonth() {
        return (int) Math.ceil(getDayOfYear() / 30 + 1);
    }

    int getDayOfMonth() {
        int dayOfMonth = getDayOfYear() % 30;
        return dayOfMonth != 0 ? dayOfMonth : 30;
    }

    int getDayOfWeek() {
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    int getHour() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    String getMonthName() {
        return MONTHS.get(getMonth());
    }

    String getDayName() {
        return DAYS.get(getDayOfMonth());
    }

    String getDayOfWeekName() {
        return WEEK_DAYS.get(getDayOfWeek());
    }

    String getDateName() {
        return getDayOfWeekName() + ", " + getDayName() + " (" + getDayOfMonth() + ") " + getMonthName();
    }

    String getHourName() {
        return getHourName(getHour());
    }

    static String getHourName(Integer hour) {
        return HOURS.get(hour == 0 ? 24 : hour);
    }
}
