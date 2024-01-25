package mode.dao;

import java.util.List;

import db.model.Department;
import db.model.Seller;

public interface DepartmentDao {
	void insert(Department obj);
	
	void update(Department obj);

	void deleteById(Integer id);

	Department findById(Integer id);

	List<Seller> findAll();

	List<Seller> FindByDepartment(Department Department);

}
