package com.genhijra.api.dao.master;

import com.genhijra.api.entity.master.Nasabah;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class NasabahDAO implements INasabahDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all nasabah available in database and return it as List<nasabah>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Nasabah> getNasabah() {
		
		String hql = "FROM Nasabah as atcl ORDER BY atcl.id";
		return (List<Nasabah>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular nasabah detail by given nasabah id
	 */
	@Override
	public Nasabah getNasabah(int nasId) {
		
		return entityManager.find(Nasabah.class, nasId);
	}



	/**
	 * This method is responsible to create new nasabah in database
	 */
	@Override
	public Nasabah createNasabah(Nasabah nasabah) {
		entityManager.persist(nasabah);
		Nasabah b = getLastInsertedNasabah();
		return b;
	}

	private Nasabah getLastInsertedNasabah(){
		String hql = "from Nasabah order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Nasabah nasabah = (Nasabah)query.getSingleResult();
		return nasabah;
	}

	@Override
	public List<Nasabah> getNasabahByNorek(String noRekening) {
		String hql = "from Nasabah t where t.noRekening = :noRekening order by t.id DESC";
		Query query = entityManager.createQuery(hql);
		query.setParameter("noRekening", noRekening);
		return (List<Nasabah>) query.getResultList();
	}

}
