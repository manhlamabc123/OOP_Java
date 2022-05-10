package Aims;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class MyDate {
    private static int day;
    private static int month;
    private static int year;
    private Date dateOrder;

    public MyDate() {}

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate(String date){}

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static void accept() {
        System.out.println("Input a date: ");
        Scanner sc= new Scanner(System.in);
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
            day = date.getDate();
            month = date.getMonth() + 1;
            year = date.getYear() + 1900;
            System.out.println("Input date: " + day + "/" + month + "/" + year + ".");

        } catch (Exception e) {
            System.out.println("Sorry, that's not valid. Please try again.");
        }
    }

    public static void print(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}
