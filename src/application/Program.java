package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.model.DaoFactory;
import db.model.Department;
import db.model.Seller;
import mode.dao.SellerDao;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.CreateSellerDao();

		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		Scanner sc = new Scanner(System.in);

		System.out.println("===== TESTE 2 Find by Department ======");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller sell : list) {
			System.out.println(sell);
		}

		System.out.println("===== TESTE 3 Find All ======");
		list = sellerDao.findAll();
		for (Seller sell : list) {
			System.out.println(sell);
		}

		System.out.println("===== TESTE 4 Insert ======");
		Seller seller1 = new Seller(null, "teste", "g@gmail.com", new Date(), 200.00, department);
		sellerDao.insert(seller1);
		System.out.println("inserção com sucesso " + " " + seller1.getId());

		System.out.println("==== TESTE 5 ======");
		seller = sellerDao.findById(2);
		seller.setName("Dario");
		sellerDao.update(seller);
		System.out.println("Uptade confirmado! ");

		System.out.println("=== TESTE 6 DELETE  ===");
		System.out.println("Entre com o Id que deseja deletar");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Pronto!!");

		sc.close();
	}

}
