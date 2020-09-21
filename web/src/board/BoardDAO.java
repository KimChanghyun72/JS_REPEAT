package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import common.ConnectionManager;
import dept.DeptVO;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;
	
	static BoardDAO instance;
	public static BoardDAO getInstance() {
		if(instance==null)
			instance=new BoardDAO();
		return instance;
	}
	
	public ArrayList<BoardVO> selectAll(BoardVO boardVO) {
		BoardVO resultVO = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT NO, POSTER, SUBJECT, CONTENTS, LASTPOST, VIEWS, FILENAME "
					+ "FROM BOARD";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultVO = new BoardVO();
				resultVO.setNo(rs.getInt("no"));
				resultVO.setPoster(rs.getString("poster"));
				resultVO.setSubject(rs.getString("subject"));
				resultVO.setContents(rs.getString("contents"));
				resultVO.setLastpost(rs.getString("lastpost"));
				resultVO.setViews(rs.getInt("views"));
				resultVO.setFilename(rs.getString("filename"));
				
				list.add(resultVO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
	return list;	
	}
	
	public BoardVO selectOne(BoardVO boardVO) {
		BoardVO resultVO = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT NO, POSTER, SUBJECT, CONTENTS, LASTPOST, VIEWS, FILENAME "
					+ "FROM BOARD WHERE NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,boardVO.getNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultVO = new BoardVO();
				resultVO.setNo(rs.getInt("no"));
				resultVO.setPoster(rs.getString("poster"));
				resultVO.setSubject(rs.getString("subject"));
				resultVO.setContents(rs.getString("contents"));
				resultVO.setLastpost(rs.getString("lastpost"));
				resultVO.setViews(rs.getInt("views"));
				resultVO.setFilename(rs.getString("filename"));
			}else {
				System.out.println("no data");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
	return resultVO;	
	}
	
	public void delete(BoardVO boardVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "delete from board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardVO.getNo());
			int r = pstmt.executeUpdate();
			System.out.println(r+"건이 삭제됨.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		
	}//end of delete
	
	public void update(BoardVO boardVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "update board set subject = ? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVO.getSubject());
			pstmt.setInt(2, boardVO.getNo());
			int r = pstmt.executeUpdate();
			System.out.println(r+"건이 수정됨.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		
	}//end of update
	
	public void insert(BoardVO boardVO) {
		try {
			//1.DB연결
			conn = ConnectionManager.getConnnect();
			conn.setAutoCommit(false);
			//2.sql 구문 실행
			//board 조회
			String seqSql = "select no from seq where tablename = 'board'";
			Statement stmt = conn.createStatement();
			stmt.executeQuery(seqSql);
			ResultSet rs = stmt.executeQuery(seqSql);
			rs.next();
			int no = rs.getInt(1);
			boardVO.setNo(no);
			//보드 번호 업데이트
			seqSql = "update seq set no = no+1 where tablename = 'board' ";
			stmt = conn.createStatement();
			stmt.executeUpdate(seqSql);
			//게시글 등록
			String sql = "insert into board (NO, POSTER, SUBJECT, CONTENTS, LASTPOST, FILENAME) "
					+ " values (?,?,?,?,sysdate ,?)";
			//no = select max(no)+1 from board
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, boardVO.getPoster());
			pstmt.setString(3, boardVO.getSubject());
			pstmt.setString(4, boardVO.getContents());
			pstmt.setString(5, boardVO.getFilename());
			int r = pstmt.executeUpdate();
			conn.commit();
			//3.결과 처리
				System.out.println(r+"건이 처리됨.");
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			//4.연결 해제
			//db에 접속가능한 세션의 수는 제한됨. 따라서 접속끝나면 연결해제해줘야 됨.
			ConnectionManager.close(conn);
		}
		
	}//end of insert
	
}
