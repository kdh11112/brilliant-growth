package kr.co.jhta.web.service;

import java.util.List;

import kr.co.jhta.web.dto.DeptDTO;

public interface DService {

	public List<DeptDTO> getDeptList();

	public void insertData(DeptDTO dto);

	public DeptDTO getDeptData(int no);

	public void updateData(DeptDTO dto);

	public void deleteData(int no);
}
