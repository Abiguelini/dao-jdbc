package mode.dao;

import java.util.List;

import db.model.Seller;

public interface SellerDao {
	void insert(Seller obj);

	void update(Seller obj);

	void deleteById(Integer id);

	Seller findById(Integer id);

	List<Seller> findAll();
}
