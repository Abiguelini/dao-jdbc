package application;

import java.util.List;

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
		
		System.out.println("==== TESTE 2 INSERTT ======");
		Department dep2 =  new Department(9, "cosméticos");
		departmentDao.insert(dep2);
		System.out.println("Inseção com sucesso "+dep2.getId());
		
		System.out.println("=== TESTE 3 DELETE BY ID");
		departmentDao.deleteById(9);
		System.out.println("DEPARTAMENTO DELETADO COM SUCESSO");
		
		System.out.println("=== teste 4 update");
		dep = departmentDao.findById(6);;
		dep.setName("Tvs");
		departmentDao.update(dep);
		
		System.out.println("=== teste 5 Lista por ordem");
		List<Department> lista = departmentDao.findAll();
		for(Department dep3 :lista) {
			System.out.println(dep3);
		}
		
		
	}

}
