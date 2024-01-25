package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import db.model.Department;
import db.model.Seller;
import mode.dao.DepartmentDao;

public class DepartmentDaoJDBC implements DepartmentDao {
	Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement Ps = null;
		try {
			Ps = conn.prepareStatement("INSERT INTO Department " + "(Id, Name) " + "VALUES " + "(?, ?");
			Ps.setInt(1, obj.getId());
			Ps.setString(2, obj.getName());
			Ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException("Erro ao inserir um novo departamento");
		}
	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement Ps = null;
		ResultSet Rt = null;
		try {
			Ps = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
			Ps.setInt(1, id);
			Rt = Ps.executeQuery();
			if (Rt.next()) {
				Department obj = new Department();
				obj.setId(Rt.getInt("Id"));
				obj.setName(Rt.getString("Name"));
				return obj;
			}
			

		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			DB.closeStatement(Ps);
			DB.closeResultSet(Rt);

		}
		return null;

	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> FindByDepartment(Department Department) {
		// TODO Auto-generated method stub
		return null;
	}

}
