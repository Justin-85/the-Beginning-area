/**
*
*
* author : ME
*/

package helloworld.com.demo;



public class testString {

	public static void main(String[] args) {
//		String x = new String(hiddenPlateNo("ABC-123"));
//		System.out.println(x);
		
		for(int i = 0 ; i<10 ; i++ ) {
			String x = new String(hiddenPlateNo("ABC-123"));
			System.out.println(x);
			
		}
		
	}
	
	public static String hiddenPlateNo(String plateNo) {
		String[] subArray = plateNo.split("-");
		String sub1, sub2 = "";
		String star = "*";
		
		sub1 =subArray[0].substring(0, subArray[0].length()-1);
		sub2 =subArray[1].substring(1);
		
		return sub1 + star +"-" +star + sub2;	
	}

}
