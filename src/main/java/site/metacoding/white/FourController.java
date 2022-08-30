package site.metacoding.white;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.white.domain.Four;
import site.metacoding.white.dto.RespDto;

@RestController
public class FourController {//DS는 IoC에 뜬 컨트롤러를 가져와서 메서드를 때리는것
	
	@GetMapping("/four")//이 방식 안쓴다~ 이렇게 리턴하면 안된다..
	public Four getData() {
		Four four = new Four();
		four.setTitle("제목");
		four.setContent("내용");
		return four;//DS가 Four 오브젝트를 리턴받고 해당 오브젝트를 MessageConverter에게 전달
	}
	
	@GetMapping("/four/data")//이 방식이 표준이긴함!
	public ResponseEntity<?> getData2() {
		Four four = new Four();
		four.setTitle("제목");
		four.setContent("내용");
		//ResponseEntity<Four> response = new ResponseEntity<>(four, HttpStatus.OK);
		return new ResponseEntity<>(four, HttpStatus.OK);//http상태코드
	}
	
	@GetMapping("/four/dto")//body에 리턴하는건 회사가서 쓰기.. 공부는 header에 리턴하는방식으로 하기!(http상태코드)
	public RespDto<?> getData3() {
		Four four = new Four();
		four.setTitle("제목");
		four.setContent("내용");
		return new RespDto<>(1, "성공", four);//응답할 body가 없으면 null
		//제네릭이 아니었으면 오브젝트 엄청 많이 만들어야했을걸...
	}
	
	
}