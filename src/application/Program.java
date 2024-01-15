package application;

import java.util.Date;

import db.model.Department;
import db.model.Seller;

public class Program {

	public static void main(String[] args) {
		Department dp = new Department(1, "Livros");
		System.out.println(dp);
		Seller seller = new Seller(21, "bob", "bob@gmailcom", new  Date(), 2100.00, dp);
		System.out.println(seller);
	}

}
