package application;

import db.model.DaoFactory;
import db.model.Department;
import mode.dao.DepartmentDao;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.CreateDepDao();
		
		System.out.println("=========== TESTE 1 ========");
		System.out.println("FIND BY ID: ");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
	}

}
