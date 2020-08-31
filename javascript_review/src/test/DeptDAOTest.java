package test;

import java.util.ArrayList;

public class DeptDAOTest {
	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
		//dao.insert(new DeptVO(1200, "호올스"));
		dao.delete(new DeptVO(1200,"러ㅗ키"));
//		DeptVO resultVO = dao.selectOne(new DeptVO(110));
//		if(resultVO!=null) {
//			System.out.println(resultVO.toString());
//			System.out.println(resultVO.getDepartment_id());
//			System.out.println(resultVO.getDepartment_name());
//		}
		ArrayList<DeptVO> list = dao.selectAll(null);
		System.out.println(list);
		
	}
}