/**
*
*
* author : ME
*/

package tw.com.imsoft.test;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
		System.out.println("demo111");
		System.out.println("demo222");
		System.out.println("demo333");
		Scanner sc = new Scanner(System.in);
		String get = sc.next();
		System.out.println(get+args);
		System.out.println(args);
		
	}

}
