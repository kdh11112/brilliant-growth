package kr.co.jhta.web.dto;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	private int bno;
	private String writer;
	private String title;
	private String contents;
	private String regdate;
	private int hits;
	private String ip;
	private int status;

}
