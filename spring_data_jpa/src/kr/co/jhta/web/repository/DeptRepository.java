package kr.co.jhta.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.jhta.web.dto.DeptDTO;

@Repository
public interface DeptRepository extends JpaRepository<DeptDTO, Integer>{
	List<DeptDTO> findByDname(String dname); //findOne인거 잘은 모르겠지만 findOne은 사용불가로 인하여 findBy~~형식으로 구현?? 하는게 편할듯함
	DeptDTO findByDeptno(int deptno);
	
	//save(S) : 새로운 엔터티를 저장하고 ,이미 잇는 엔터티는 수정
	//delete(T) : 엔터티는 하나 삭제 , 내부적으로 entityManager.remove() 호출
	//findOne(ID) : 엔터티는 하나 조회
	//findAll : 모든 엔터티 조회
}
