package site.metacoding.white;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.white.domain.Third;

//고급 데이터받기(json, x-www-form-어쩌고, text)

@RestController
public class ThirdController {
	
	@PostMapping("/third")
	public String postData(Third third) {//Request DTO, 요소가 많을 때 한꺼번에 받을 수 있게 해줌
		return "id: "+third.getId()+", title: "+third.getTitle()+", content: "+third.getContent();
	}
	
	//UPDATE third SET title = ?, content = ? WHERE id = ?
	@PutMapping("/third/{id}")
	public String putData(@PathVariable Integer id, Third third) {
		return third.toString(); //위처럼 안써도된다!!!!
	}
	
	@PutMapping("/third/{id}/json")
	public String putJsonData(@PathVariable Integer id, @RequestBody Third third) {//클래스에 값을 넣을 때 json으로 넣도록 바꿔줌
		return third.toString();
	}
}
