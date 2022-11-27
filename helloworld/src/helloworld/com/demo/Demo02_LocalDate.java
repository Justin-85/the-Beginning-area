/**
*
*
* author : ME
*/

package helloworld.com.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.swing.text.SimpleAttributeSet;

public class Demo02_LocalDate {
	
	public static void main(String args[]) {
		
		LocalDateTime DateTimenow = LocalDateTime.now();
		LocalDate Datenow = LocalDate.now();
		LocalTime Timenow = LocalTime.now();
		
		Datenow = Datenow.plusYears(5); // 加
		Datenow = Datenow.minusYears(6); // 減
		
		Timenow = Timenow.now().plusMinutes(30);
		
		System.out.println(DateTimenow);
		System.out.println("年份為"+Datenow.getYear());
		
		System.out.println(Timenow);
		
		//加 、 減 
		//token 時間 維持30分鐘 可以用LocateTime
		//isAfter isBefore  between 比對時間
		
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // MM 月份 mm 分鐘
		String xx = sdf.format(today);
		System.out.println("日期為"+ xx);
		try {
			System.out.println("字串轉時間 "+sdf.parse("2022-10-10"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//parse 字串轉時間 
		//format 時間轉字串
		
		
	}

}
