package chapter20_JDBC;

import java.util.List;

public class EmployeeTest {

	public static void main(String[] args) {
		//-- 5
		EmployeeDao dao = new EmployeeDao();
		
		//-- 7
		dao.getStatement();
		
		//-- 9		
		List<EmployeeVo> list = dao.getList();
		
		list.forEach((employee) -> {
			System.out.print(employee.getEmpId() + "\t");
			System.out.print(employee.getEmpName() + "\t");
			System.out.print(employee.getHireDate() + "\t");
			System.out.print(employee.getSalary() + "\n");
		});
		
		//-- 11
//		dao.close();
	}

}
