package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import db.model.Department;
import db.model.Seller;
import mode.dao.SellerDao;

public class SellerDaoJDBC implements SellerDao {
	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement Ps = null;
		ResultSet Rs = null;
		try {
			Ps = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ? ");
			Ps.setInt(1, id);
			Rs = Ps.executeQuery();

			if (Rs.next()) {
				Department dp = instanciateDeparment(Rs);
				Seller seller = instanciateSeller(Rs, dp);

				return seller;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		finally {
			DB.closeStatement(Ps);
			DB.closeResultSet(Rs);

		}
	}

	private Seller instanciateSeller(ResultSet Rs, Department dp) throws SQLException {
		Seller seller = new Seller();
		seller.setId(Rs.getInt("Id"));
		seller.setName(Rs.getString("Name"));
		seller.setEmail(Rs.getString("email"));
		seller.setSalaryBase(Rs.getDouble("BaseSalary"));
		seller.setDepartment(dp);
		return seller;
	}

	private Department instanciateDeparment(ResultSet Rs) throws SQLException {
		Department dp = new Department();
		dp.setId(Rs.getInt("DepartmentId"));
		dp.setName(Rs.getString("DepName"));
		return dp;
	}

	@Override
	public List<Seller> findAll() {

		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement Ps = null;
		ResultSet Rs = null;
		try {
			Ps = conn.prepareStatement(
							"SELECT seller.*,department.Name as DepName " 
							+ "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " 
							+ "WHERE DepartmentId = ? " + "ORDER BY Name");

			Ps.setInt(1, department.getId());

			Rs = Ps.executeQuery();

			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();

			while (Rs.next()) {

				Department dep = map.get(Rs.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = instanciateDeparment(Rs);
					map.put(Rs.getInt("DepartmentId"), dep);
					
				}

				Seller obj = instanciateSeller(Rs, dep);
				list.add(obj);

				
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		finally {
			DB.closeStatement(Ps);
			DB.closeResultSet(Rs);

		}
	}

}
