/**
*
*
* author : ME
*/

package helloworld.com.demo;

import java.util.Scanner;

public class Demo03 {

	public static void main(String[] args) {
		
		Demo demo = new Demo();
		demo.a();
		
		Integer x = 2;
		int c = Integer.valueOf("123");

		// valueof 字串 變 數字

		Scanner scn = new Scanner(System.in);

		int total = 0;

		while (true) {
			System.out.print("請輸入數字 :");
			String y = scn.next(); // 這行 判斷 使用者輸入的東西 下.next() 才能讀到使用者輸入的東西

			if ("Q".equals(y)) {
				System.out.println("OVER");
				break;
			} else {
				int xx = Integer.valueOf(y); // 變成數值 從字串 轉變成數字
				total += xx;
				System.out.println("您輸入的數字相加 :" + total);

			}
			//後面做 累加的動作 1.宣告另一個物件 2.把累加的結果儲存進這個物件裡面 
			

		}
	}

}
