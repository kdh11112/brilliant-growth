package kr.co.jhta.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.jhta.web.vo.BoardVO;

public class BoardDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "scott";
	String password = "tiger";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sb = new StringBuffer();
	
	public BoardDAO() {
			
		try {
			//2.드라이버로딩
			Class.forName(driver);
			//3.Connection
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패");
		}catch (SQLException e) {
			System.out.println("DB연결실패");
			e.printStackTrace();
		}
	}
	
	public BoardVO selectOne(int i){
		sb.setLength(0);
		sb.append("SELECT WRITER, TITLE, CONTENTS ,HITS ,REGDATE FROM BOARD WHERE BNO = ?");
		BoardVO vo = null;
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, i);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				int hits = rs.getInt("hits");
				String regdate = rs.getString("regdate");
				vo = new BoardVO();
				vo.setBno(i);
				vo.setWriter(writer);
				vo.setTitle(title);
				vo.setContents(contents);
				vo.setHits(hits);
				vo.setRegdate(regdate);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public int getTotalCount() {		
		sb.setLength(0);
		sb.append("SELECT count(*) FROM BOARD");
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public ArrayList<BoardVO> selectAll(int i ,int j){
		//최근 데이터 20개만 가져오기
		ArrayList<BoardVO> list = new ArrayList<>();
		sb.setLength(0);
		sb.append("SELECT	RN,BNO,WRITER,TITLE,CONTENTS,REGDATE,HITS,IP,STATUS FROM( ");
		sb.append("SELECT 	ROWNUM RN,BNO,WRITER,TITLE,CONTENTS,REGDATE,HITS,IP,STATUS FROM ( ");
		sb.append("SELECT 	BNO,WRITER,TITLE,CONTENTS,REGDATE,HITS,IP,STATUS FROM BOARD b ORDER BY BNO DESC) WHERE ROWNUM <= ?)WHERE RN >= ? ");
		

		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, j);
			pstmt.setInt(2, i);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String regdate = rs.getString("regdate");
				int hits = rs.getInt("hits");
				String ip = rs.getString("ip");
				int status = rs.getInt("status");
				BoardVO vo = new BoardVO();
				vo.setBno(bno);
				vo.setWriter(writer);
				vo.setTitle(title);
				vo.setContents(contents);
				vo.setRegdate(regdate);
				vo.setHits(hits);
				vo.setIp(ip);
				vo.setStatus(status);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public void addOne(BoardVO vo2) {
		sb.setLength(0);
		sb.append("INSERT INTO BOARD VALUES(BOARD_BNO_SEQ.NEXTVAL,?,?,?,SYSDATE,0,?,1)");
		//상태정보 : 	1. 정상글
		//			2.블라인드처리
		//			3.경찰요청
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo2.getWriter());
			pstmt.setString(2, vo2.getTitle());
			pstmt.setString(3, vo2.getContents());
			pstmt.setString(4, vo2.getIp());
			
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
	public void updateOne(BoardVO vo) {
		sb.setLength(0);
		sb.append("UPDATE BOARD SET TITLE = ?, CONTENTS = ?,regdate = sysdate WHERE BNO = ?");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());
			pstmt.setInt(3, vo.getBno());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	public void deleteOne(int i) {
		sb.setLength(0);
		sb.append("DELETE FROM BOARD WHERE BNO = ?");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, i);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

	
	public void close() {
		
		try {
		if(rs != null)rs.close();
		if(conn != null)conn.close();
		if(pstmt != null)pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
}

}