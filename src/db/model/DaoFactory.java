package db.model;

import db.DB;
import mode.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
		public static SellerDao CreateSellerDao() {
			return new SellerDaoJDBC(DB.getConnection());
			
		}
}
