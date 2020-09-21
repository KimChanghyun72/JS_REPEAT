package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.ConnectionManager;

public class DeptDAO {
	//전역변수, 모든 메서드에 공통으로 사용되는 변수.
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;
	
	//전체조회(페이징)
	public ArrayList<DeptVO> selectAll(DeptVO deptVO) {
		DeptVO resultVO = null;
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String where = " where 1=1";
			if(deptVO.getDepartment_name()!=null) {
				where += " and department_name like '%' || ? || '%' ";
			}
			
			String sql = "select a.* from ( select rownum rn, b.* from ( " 
					+ " SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID mgr_id, LOCATION_ID "
					+ " FROM HR.DEPARTMENTS "
					+ where
					+ " ORDER BY DEPARTMENT_ID"
					+ " ) b ) a where rn between ? and ?";
			pstmt = conn.prepareStatement(sql);
			int pos = 1;
			if(deptVO.getDepartment_name()!=null) {
				pstmt.setString(pos++, deptVO.getDepartment_name());
			}
			pstmt.setInt(pos++, deptVO.getFirst());
			pstmt.setInt(pos, deptVO.getLast());
			//pstmt.setInt(1,deptVO.getDepartment_id());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultVO = new DeptVO();
				resultVO.setDepartment_id(rs.getInt(1));
				resultVO.setDepartment_name(rs.getString("department_name"));
				resultVO.setManager_id(rs.getInt("mgr_id"));
				resultVO.setLocation_id(rs.getInt("LOCATION_ID"));
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
	public DeptVO selectOne(DeptVO deptVO) {
		DeptVO resultVO = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID mgr_id, LOCATION_ID "
					+ "FROM HR.DEPARTMENTS WHERE DEPARTMENT_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,deptVO.getDepartment_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultVO = new DeptVO();
				resultVO.setDepartment_id(rs.getInt(1));
				resultVO.setDepartment_name(rs.getString("department_name"));
				resultVO.setManager_id(rs.getInt("mgr_id"));
				resultVO.setLocation_id(rs.getInt("LOCATION_ID"));
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
	
	public void delete(DeptVO deptVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE FROM HR.DEPARTMENTS WHERE DEPARTMENT_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptVO.getDepartment_id());
			int r = pstmt.executeUpdate();
			System.out.println(r+"건이 삭제됨.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		
	}//end of delete
	
	public void update(DeptVO deptVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "UPDATE HR.DEPARTMENTS SET DEPARTMENT_NAME = ? WHERE DEPARTMENT_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptVO.getDepartment_name());
			pstmt.setInt(2, deptVO.getDepartment_id());
			int r = pstmt.executeUpdate();
			System.out.println(r+"건이 수정됨.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.close(null, pstmt, conn);
		}
		
	}//end of update
	
	public void insert(DeptVO deptVO) {
		try {
			//1.DB연결
			conn = ConnectionManager.getConnnect();
			//2.sql 구문 실행
			String sql = "INSERT INTO HR.DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME) "
						+ " values ("+ deptVO.getDepartment_id() + ", '"+ deptVO.getDepartment_name() +"')";
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
	
	public int count(DeptVO deptVO) {
		int cnt = 0;
		try {
			conn = ConnectionManager.getConnnect();
			String where = " where 1=1";
			if(deptVO.getDepartment_name()!=null) {
				where += " and department_name like '%' || ? || '%' ";
			}
			
			String sql = "select count(*) from hr.departments" + where;
			pstmt = conn.prepareStatement(sql);
			int pos = 1;
			if(deptVO.getDepartment_name()!=null) {
				pstmt.setString(pos++, deptVO.getDepartment_name());
			}
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(conn);
		}
		return cnt;
	}
}
