package db.model;

import db.DB;
import mode.dao.DepartmentDao;
import mode.dao.SellerDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
		public static SellerDao CreateSellerDao() {
			return new SellerDaoJDBC(DB.getConnection());
			
		}
		
		public static DepartmentDao CreateDepDao(){
			return new DepartmentDaoJDBC(DB.getConnection());
		}
}
