/**
*
*
* author : ME
*/

package practice_1018.com.demo;

import java.util.Random;

public class Jdbc01 {

	public static void main(String[] args) {
			Jdbc_method conn = new Jdbc_method();
			conn.connection();
			conn.insert("Kustin", "thisispassword");
	
	}

}
