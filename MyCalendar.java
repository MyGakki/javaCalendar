package com.myCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MyCalendar {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		while (true) {
			System.out.println("输出日历请输入1，输出星期请输入2");
			int code = new Scanner(System.in).nextInt();
			if (code == 1) {
				System.out.println("请输入年份（例如2017）：");
				int year = new Scanner(System.in).nextInt();
				calendar.set(Calendar.YEAR, year);
				for (int i = 0; i < 12; i++) {
					calendar.set(Calendar.MONTH, i);
					calendar.set(Calendar.DAY_OF_MONTH, 1);
					printCalendar(calendar);
				}
				System.out.println();
			} else if (code == 2) {
				System.out.println("请输入日期（例如：2017-01-01）：");
				String string = new Scanner(System.in).nextLine();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
				String[] dayOfWeek = {"周日","周一","周二","周三","周四","周五","周六"};
				try {
					Date date = simpleDateFormat.parse(string);
					calendar.setTime(date);
					System.out.println(dayOfWeek[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void printCalendar(Calendar calendar) {
		// TODO 自动生成的方法存根
		System.out.print("\n\n                     " + (calendar.get(Calendar.MONTH) + 1) + "月" + "              \n");
		String string = "日\t一\t二\t三\t四\t五\t六\n";
		System.out.println(string);
		for (int i = 0; i < calendar.get(Calendar.DAY_OF_WEEK) - 1; i++) {
			System.out.print("\t");
		}
		int month = calendar.get(Calendar.MONTH);
		while (calendar.get(Calendar.MONTH) == month) {
			System.out.print(
					calendar.get(Calendar.DAY_OF_MONTH) + ((calendar.get(Calendar.DAY_OF_WEEK) == 7 ? "\n" : "\t")));
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
}
