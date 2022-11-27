/**
*
*
* author : ME
*/

package tw.com.example.imsoft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayController {
	
	@RequestMapping("/play")
	public void play() {
		System.out.println("play#start");
	}
	
	@RequestMapping("/stop")
	public String stop() {
		return "press stop";
	}
	
	@RequestMapping("/one")
	public Integer one() {
		return 1;
	}
	
	

}
