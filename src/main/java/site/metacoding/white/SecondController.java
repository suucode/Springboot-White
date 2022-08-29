package site.metacoding.white;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//데이터 받기
//GET-> http body가 없음, QueryString, Path Variable->Form태그로도 가능(method를 get으로바꾸기)->브라우저 (주소뒤에 ? 붙이기)
//POST, PUT-> http body에 데이터를 담아준다 -> Form태그를 POST로 보낸다-> JS로도 가능
//DELETE->http body가 없음

//where절에 걸리는것은 주소에 담아주는데 다음 두가지가 있지..? 
//PathVariable은 보통 pk만 건다
//QueryString는 pk가 아닌걸 찾을 때 사용하는게 요즘 프로토콜!

@RestController
public class SecondController {
	@GetMapping("/second/{id}") //PK(id)가 1인 것
	public String getData(@PathVariable Integer id) {
		return "id: "+id;
	}
	
	//QueryString은 ﻿x-www-form-urlencoded타입이다.
	@GetMapping("/second")
	public String getData2(String title, String content) {
		return "title: "+title+",content: "+content;
	}
	
	//BR -> title=제목&content=내용, x-www-어쩌고(content-type)
	@PostMapping("/second")
	public String postData(String title, String content) {//스프링의 파싱 기본전략: x-www-form-어쩌고
		return "title: "+title+",content: "+content;
	}
	
	@PutMapping("/second")
	public String putData(String title, String content) {
		return "title: "+title+",content: "+content;
	}
	
	@DeleteMapping("/second/{id}")
	public String deleteData(@PathVariable Integer id) {
		return id+" delete ok";
	}
}
