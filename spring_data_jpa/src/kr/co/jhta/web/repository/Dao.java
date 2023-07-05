package kr.co.jhta.web.repository;

import java.util.List;

import kr.co.jhta.web.dto.DeptDTO;

public interface Dao {
	
	public List<DeptDTO> getDeptList();

	public void insertData(DeptDTO dto);

	public DeptDTO getDeptData(int no);

	public void updateData(DeptDTO dto);

	public void deleteData(int no);

}
