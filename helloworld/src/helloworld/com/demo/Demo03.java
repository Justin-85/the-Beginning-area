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
			String y = scn.next();

			if ("Q".equals(y)) {
				System.out.println("OVER");
				break;
			} else {
				int xx = Integer.valueOf(y); // 變成數值
				total += xx;
				System.out.println("您輸入的數字相加 :" + total);

			}

		}
	}

}
