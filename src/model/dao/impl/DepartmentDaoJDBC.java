package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			Ps = conn.prepareStatement("INSERT INTO Department " + "(Id, Name) " + "VALUES " + "(?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			Ps.setInt(1, obj.getId());
			Ps.setString(2, obj.getName());
			int linhasAfetadas = Ps.executeUpdate();

			if (linhasAfetadas > 0) {
				ResultSet rt = Ps.getGeneratedKeys();
				if (rt.next()) {
					int id = rt.getInt(1);
					obj.setId(id);
					DB.closeResultSet(rt);
				} else {
					throw new DbException("Nenhuma linha afetada");
				}
			}
		} catch (SQLException e) {
			throw new DbException("Erro ao inserir um novo departamento");
		}
	}

	@Override
	public void update(Department obj) {
		PreparedStatement Ps = null;
		try {
			Ps = conn.prepareStatement("UPDATE department " + "SET Name = ? " + "WHERE Id = ?");
			Ps.setString(1, obj.getName());
			Ps.setInt(2, obj.getId());

			Ps.executeUpdate();

		} catch (SQLException e) {
			e.getMessage();
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement Ps = null;
		try {
			Ps = conn.prepareStatement("DELETE FROM department where Id = ?");
			Ps.setInt(1, id);
			Ps.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(Ps);
		}
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
	public List<Department> findAll() {
		PreparedStatement Ps = null;
		ResultSet Rs = null;
		try {
			Ps = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
			Rs = Ps.executeQuery();
			List<Department> lista = new ArrayList<>();
			
			while(Rs.next()) {
				Department obj = new Department();
				obj.setId(Rs.getInt("Id"));
				obj.setName(Rs.getString("Name"));
				lista.add(obj);
				
			}
			return lista;
			

		} catch (SQLException e) {
			e.getMessage();
		}finally {
			DB.closeStatement(Ps);
			DB.closeResultSet(Rs);
		}
		return null;
		
	}

	@Override
	public List<Seller> FindByDepartment(Department Department) {
		return null;
	}

}
