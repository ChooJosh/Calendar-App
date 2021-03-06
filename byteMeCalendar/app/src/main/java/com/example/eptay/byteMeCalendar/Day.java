package com.example.eptay.byteMeCalendar;

public class Day {
    private String date;
    private int eventCount;
    private int m_year;
    private int m_month;
    private int m_day;
    private String m_dayName;
    private int m_dayOfWeek;


    public Day(String dayName, String date, int eventCount) {
            this.m_dayName = dayName;
            this.date = date;
            this.eventCount = eventCount;
    }

    public Day(int year, int month, int day) {
        m_year = year;
        m_month = month;
        m_day = day;
        m_dayOfWeek = GlobalCalendar.getDayOfWeek();
        m_dayName = m_weekdays[m_dayOfWeek - 1];
        date = GlobalCalendar.getDate();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getEventCount() {
        return eventCount;
    }

    String[] m_weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public int getYear() { return m_year; }
    public int getMonth() { return m_month; }
    public int getDayNum() { return m_day; }
    public String getDayName() {return m_dayName; }
    public int getDayOfWeek() { return m_dayOfWeek; }

    public String toString() {
        return m_dayName + ", " + (m_month + 1) + "/" + m_day + "/" + m_year;
    }
}

