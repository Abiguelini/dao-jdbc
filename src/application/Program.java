package application;

import db.model.DaoFactory;
import db.model.Seller;
import mode.dao.SellerDao;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.CreateSellerDao();

		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
	}

}
