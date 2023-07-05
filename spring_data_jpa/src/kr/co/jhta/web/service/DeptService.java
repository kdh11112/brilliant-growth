package kr.co.jhta.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.web.dto.DeptDTO;
import kr.co.jhta.web.repository.DeptRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@EnableJpaRepositories("kr.co.jhta.web.repository")
public class DeptService implements DService{

	@Autowired
	DeptRepository repository;
	
	@Override
	public List<DeptDTO> getDeptList() {
		log.info("getDeptList ==========>");
		return repository.findAll();
	}

	@Override
	public void insertData(DeptDTO dto) {
		repository.save(dto); //새로운 엔터티를 저장하고 , 이미 있는 엔터티는 수정함
		
	}

	@Override
	public DeptDTO getDeptData(int no) {
		
		return repository.findByDeptno(no); //no로 셀렉트

	}

	@Override
	public void updateData(DeptDTO dto) {
		repository.save(dto); //수정 입력 둘다됨
	}

	@Override
	public void deleteData(int no) {
		repository.deleteById(no);
		
	}

}
