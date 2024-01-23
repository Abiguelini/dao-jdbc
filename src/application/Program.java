package application;

import java.util.Date;
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

		System.out.println("===== TESTE 2 ======");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller sell : list) {
			System.out.println(sell);
		}

		System.out.println("===== TESTE 3 ======");
		list = sellerDao.findAll();
		for (Seller sell : list) {
			System.out.println(sell);
		}
		
		System.out.println("===== TESTE 4 ======");
		Seller seller1 = new Seller(null, "georgio", "g@gmail.com", new Date(), 200.00,department);	
		sellerDao.insert(seller1);
		System.out.println("inserção com sucesso " + " " +seller1.getId());
	}

}
