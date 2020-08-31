package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import board.BoardVO;
import common.ConnectionManager;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;
	
	public ArrayList<MemberVO> selectAll(MemberVO memberVO) {
		MemberVO resultVO = null;
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT ID, PASSWORD, NAME, TEL "
					+ "FROM MEMBER";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultVO = new MemberVO();
				resultVO.setName(rs.getString("id"));
				resultVO.setPassword(rs.getString("password"));
				resultVO.setName(rs.getString("name"));
				resultVO.setTel(rs.getString("tel"));
				
				
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
	
	public MemberVO selectOne(MemberVO memberVO) {
		MemberVO resultVO = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT ID, PASSWORD, NAME, TEL "
					+ "FROM BOARD WHERE ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,memberVO.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultVO = new MemberVO();
				resultVO.setId(rs.getString("id"));
				resultVO.setPassword(rs.getString("password"));
				resultVO.setName(rs.getString("name"));
				resultVO.setTel(rs.getString("tel"));
				
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
	
	public void delete(MemberVO memberVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "delete from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			int r = pstmt.executeUpdate();
			System.out.println(r+"건이 삭제됨.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		
	}//end of delete
	
	public void update(MemberVO memberVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "update MEMBER set tel = ? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getTel());
			pstmt.setString(2, memberVO.getId());
			int r = pstmt.executeUpdate();
			System.out.println(r+"건이 수정됨.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		
	}//end of update
	
	public void insert(MemberVO memberVO) {
		try {
			//1.DB연결
			conn = ConnectionManager.getConnnect();
			//2.sql 구문 실행
			String sql = "insert into MEMBER (id, password, name, tel) "
						+ " values ('"+ memberVO.getId() + "', '"+ memberVO.getPassword() + "', '"
						+ memberVO.getName() + "', '" + memberVO.getTel() + "')";
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			//3.결과 처리
				System.out.println(r+"건이 처리됨.");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//4.연결 해제
			//db에 접속가능한 세션의 수는 제한됨. 따라서 접속끝나면 연결해제해줘야 됨.
			ConnectionManager.close(conn);
		}
		
	}//end of insert
}
