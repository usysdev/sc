package net.usysdev.sc;

import java.util.Calendar;


/**
 * 日時ユーティリティクラス。
 */
public final class CoreDate {

    private final long millisec;


    /**
     * 保持している日時の年を返す。
     *
     * @return 年
     */
    public int year() {

        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millisec);
        return c.get(Calendar.YEAR);
    }


    /**
     * 保持している日時の月を返す。
     *
     * @return 月(1～12)
     */
    public int month() {

        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millisec);
        return (c.get(Calendar.MONTH) + 1);
    }


    /**
     * 保持している日時の日を返す。
     *
     * @return 日(1～31)
     */
    public int dayOfMonth() {

        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millisec);
        return c.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * 保持している日時の時を返す。
     *
     * @return 時(0～23)
     */
    public int hourOfDay() {

        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millisec);
        return c.get(Calendar.HOUR_OF_DAY);
    }


    /**
     * 保持している日時の分を返す。
     *
     * @return 分(0～59)
     */
    public int minute() {

        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millisec);
        return c.get(Calendar.MINUTE);
    }


    /**
     * 保持している日時の秒を返す。
     *
     * @return 秒(0～59)
     */
    public int second() {

        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millisec);
        return c.get(Calendar.SECOND);
    }


    /**
     * 保持している日時をUTC1970年1月1日午前0時からの経過ミリ秒で返す。
     *
     * @return ミリ秒
     */
    public long millisec() {

        return millisec;
    }


    /**
     * 現在を保持している日時を生成する。
     *
     * @return 現在を保持している日時オブジェクト
     */
    public static CoreDate now() {

        return new CoreDate(System.currentTimeMillis());
    }


    /**
     * 年月日時分秒形式からこのオブジェクトを生成する。
     *
     * @return 引数を表現する日時オブジェクト
     *
     * @param yyyymmddhhiiss 日時
     */
    public static CoreDate createFrom(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {

        final Calendar c = Calendar.getInstance();
        c.set(year, month - 1, dayOfMonth, hourOfDay, minute, second);
        c.set(Calendar.MILLISECOND, 0);
        return new CoreDate(c.getTimeInMillis());
    }


    /**
     * UTC1970年1月1日午前0時からの経過ミリ秒からこのオブジェクトを生成する。
     *
     * @return 引数を表現する日時オブジェクト
     *
     * @param utc UTC1970年1月1日午前0時からの経過ミリ秒
     */
    public static CoreDate createFromUTC(long utc) {

        return new CoreDate(utc);
    }


    /**
     * コンストラクタ
     *
     * @param utc UTC1970年1月1日午前0時からの経過ミリ秒
     */
    private CoreDate(long utc) {

        this.millisec = utc;
    }


    private CoreDate() {

        this.millisec = 0;
    }
}
