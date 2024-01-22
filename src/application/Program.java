package application;

import java.util.List;

import db.model.DaoFactory;
import db.model.Department;
import db.model.Seller;
import mode.dao.SellerDao;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.CreateSellerDao();

		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("=====TESTE 2 ======");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller sell : list) {
			System.out.println(sell);
		}

		System.out.println("=====TESTE 3 ======");
		list = sellerDao.findAll();
		for (Seller sell : list) {
			System.out.println(sell);
		}
	}

}
