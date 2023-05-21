package com.genhijra.api.dao.transaksi;

import com.genhijra.api.entity.transaksi.Tabungan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class TabunganDAO implements ITabunganDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all books available in database and return it as List<Book>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Tabungan> getTabungan() {
		
		String hql = "FROM Tabungan as atcl ORDER BY atcl.id";
		return (List<Tabungan>) entityManager.createQuery(hql).getResultList();
	}


	@Override
	public List<Tabungan> getTabunganByRek(String cifVal) {
		String hql = "from Tabungan t where t.noRekening = :noRekening order by t.id DESC";
		Query query = entityManager.createQuery(hql);
		query.setParameter("noRekening", cifVal);
		//query.setMaxResults(1);
		//Tabungan tabungan = (Tabungan) query.getResultList();
		return (List<Tabungan>) query.getResultList();
	}

	@Override
	public List<Tabungan> getTabunganByBetweenDate(Date startDate, Date endDate) {
		String hql = "from Tabungan t where t.tranDate  >= :startDate and t.tranDate <= :endDate order by t.id DESC";
		Query query = entityManager.createQuery(hql);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		return (List<Tabungan>) query.getResultList();
	}

	;

	/**
	 * This method is responsible to get a particular Book detail by given book id 
	 */
	@Override
	public Tabungan getTabungan(int bookId) {
		
		return entityManager.find(Tabungan.class, bookId);
	}

	/**
	 * This method is responsible to create new book in database
	 */
	@Override
	public Tabungan createTabungan(Tabungan tabungan) {
		entityManager.persist(tabungan);
		Tabungan b = getLastInsertedTabungan();
		return b;
	}



	/**
	 * This method will get the latest inserted record from the database and return the object of Book class
	 * @return book
	 */
	private Tabungan getLastInsertedTabungan(){
		String hql = "from Tabungan order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Tabungan tabungan = (Tabungan) query.getSingleResult();
		return tabungan;
	}

}
