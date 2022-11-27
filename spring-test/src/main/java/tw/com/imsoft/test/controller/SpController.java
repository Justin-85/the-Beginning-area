/**
*
*
* author : ME
*/

package tw.com.imsoft.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpController {
	
	@RequestMapping(name="/test")
	public void test() {
		System.out.println("test");
	}
	
	@GetMapping(name="/count")
	public String count() {
		return "this is a count";
	}
	
	@PostMapping(name="/one")
	public Integer one() {
		return 1;
	}
}
