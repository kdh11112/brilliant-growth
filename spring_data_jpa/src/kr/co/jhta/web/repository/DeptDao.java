package kr.co.jhta.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import kr.co.jhta.web.dto.DeptDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@Transactional
public class DeptDao implements Dao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<DeptDTO> getDeptList() {
		log.info("em : {}",em);
		
		 
		 return em.createQuery("select b from DeptDTO b order by b.deptno desc").getResultList(); //리스트 출력 list
	}

	@Override
	public void insertData(DeptDTO dto) {
		log.info("insertData() ====>");
		em.persist(dto); //입력 form
		
	}

	@Override
	public DeptDTO getDeptData(int no) {
		
		return em.find(DeptDTO.class, no); //하나만 출력 detail
		//클래스를 써야함
	}

	@Override
	public void updateData(DeptDTO dto) {
		em.merge(dto);//수정 modify
		
	}

	@Override
	public void deleteData(int no) {
		em.remove(em.find(DeptDTO.class, no));//삭제
		
	}

}
