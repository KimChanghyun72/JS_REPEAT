package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dev.common.ConnectionManager;
import com.dev.model.MemberVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;
	
	//싱글톤
	static MemberDAO instance;
	public static MemberDAO getInstance() {
		if(instance==null)
			instance=new MemberDAO();
		return instance;
	}
	
	public ArrayList<MemberVO> selectAll(MemberVO memberVO) {
		MemberVO resultVO = null;
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT ID, PASSWORD, JOB, REASON, GENDER, MAILSEND, HOBBY, REGDATE "
					+ "FROM MEMBER";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultVO = new MemberVO();
				
				resultVO.setId(rs.getString("id"));
				resultVO.setPassword(rs.getString("password"));
				resultVO.setJob(rs.getString("job"));
				resultVO.setReason(rs.getString("reason"));
				resultVO.setGender(rs.getString("gender"));
				resultVO.setMailsend(rs.getString("mailsend"));
				resultVO.setHobby(rs.getString("hobby"));
				resultVO.setRegdate(rs.getString("regdate"));
				
				
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
			String sql = "SELECT ID, PASSWORD, JOB, REASON, GENDER, MAILSEND, HOBBY, REGDATE "
					+ "FROM MEMBER WHERE ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,memberVO.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultVO = new MemberVO();
				
				resultVO.setId(rs.getString("id"));
				resultVO.setPassword(rs.getString("password"));
				resultVO.setJob(rs.getString("job"));
				resultVO.setReason(rs.getString("reason"));
				resultVO.setGender(rs.getString("gender"));
				resultVO.setMailsend(rs.getString("mailsend"));
				resultVO.setHobby(rs.getString("hobby"));
				resultVO.setRegdate(rs.getString("regdate"));
				
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
	
	public int delete(MemberVO memberVO) {
		int r= 0;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE FROM MEMBER WHERE ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			r = pstmt.executeUpdate();
			System.out.println(r+"건이 삭제됨.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		return r;
	}//end of delete
	
	public void update(MemberVO memberVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "UPDATE MEMBER SET REASON = ? , WHERE ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getReason());
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
	
	public int insert(MemberVO memberVO) {
		int r=0;
		try {
			//1.DB연결
			conn = ConnectionManager.getConnnect();
			//2.sql 구문 실행
			String sql = "insert into MEMBER (id, password, JOB, REASON, GENDER, MAILSEND, HOBBY, REGDATE) "
						+ " values (?,?,?,?,?,?,?,sysdate)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPassword());
			pstmt.setString(3, memberVO.getJob());
			pstmt.setString(4, memberVO.getReason());
			pstmt.setString(5, memberVO.getGender());
			pstmt.setString(6, memberVO.getMailsend());
			pstmt.setString(7, memberVO.getHobby());
			
			r = pstmt.executeUpdate();
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
		return r;
		
	
		
	}//end of insert
	
	//메일수신회원수 : SELECT COUNT(ID) FROM MEMBER WHERE MAILSEND = 'accept'
	public int getMailsendCnt() {
		int cnt = 0;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT COUNT(ID) FROM MEMBER WHERE MAILSEND = 'accept'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt(1);
			
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return cnt;
	}
	
	//성별인원수 : select gender, count(id) cnt from member group by gender
	public List<HashMap<String, Object>> getGenderCnt(){
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT GENDER, COUNT(ID) CNT FROM MEMBER GROUP BY GENDER";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("gender", rs.getString("gender"));
				map.put("cnt", rs.getInt("cnt"));
				list.add(map);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		
		return list;
	}
	
}
