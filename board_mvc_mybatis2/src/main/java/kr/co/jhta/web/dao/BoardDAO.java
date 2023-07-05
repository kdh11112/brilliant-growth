package kr.co.jhta.web.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.jhta.web.vo.BoardVO;
import kr.co.jhta.web.vo.StartEnd;

public class BoardDAO {
	
	public SqlSessionFactory factory;
	
	public BoardDAO() {
			
		try {
			//설계도
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			//건설노동자
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			//공장
			factory = builder.build(r);
			//설계도 닫기
			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public BoardVO selectOne(int i){
		return null;
	}
	
	public int getTotalCount() {		
		SqlSession ss = factory.openSession(true);
		Object obj = ss.selectOne("kr.co.jhta.board.getTotal");
		int result = (Integer)obj;
		
		return result;
	}
	
	public List<BoardVO> selectAll(int startNo ,int endNo){
		SqlSession ss = factory.openSession(true);
		StartEnd se = new StartEnd(startNo,endNo);
		List<BoardVO> list = ss.selectList("kr.co.jhta.board.AllSelectBoard",se);

		return list;
	}
	
	public void addOne(BoardVO vo2) {

	}
	
	public void updateOne(BoardVO vo) {

	}

	public void deleteOne(int i) {

	}

	public void close() {
		
	
	}

}