package site.metacoding.white.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter //없으면 json으로 converting이 안됨!
@AllArgsConstructor
public class RespDto<T> {//제네릭, Object타입도 가능하지만 다운캐스팅이 필요해서 좀 불편함
	private Integer code; // -1 실패, 1 성공
	private String msg; // 통신결과를 메세지로 담기
	private T body; // 실제 응답해야하는 Body 값
}
