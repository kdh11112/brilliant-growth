package kr.co.jhta.web.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="department1")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptDTO {

	@Id//pk
	@GeneratedValue(strategy= GenerationType.SEQUENCE)//시퀀스생성
	int deptno;
	String dname;
	@Column(length=50, nullable=false) //null 사용 허용할꺼니? 기본이 false
	String loc;
}
