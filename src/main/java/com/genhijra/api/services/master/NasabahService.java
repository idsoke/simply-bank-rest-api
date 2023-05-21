package com.genhijra.api.services.master;

import com.genhijra.api.entity.master.Nasabah;
import com.genhijra.api.dao.master.INasabahDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NasabahService implements INasabahService {
	
	@Autowired
	private INasabahDAO dao;

	@Override
	public List<Nasabah> getNasabah() {
		return dao.getNasabah();
	}

	@Override
	public Nasabah createNasabah(Nasabah book) {
		return dao.createNasabah(book);
	}

	@Override
	public Nasabah getNasabah(int bookId) {
		return dao.getNasabah(bookId);
	}

	@Override
	public boolean getNasabahByNorek(String norek) {

		if (dao.getNasabahByNorek(norek).size() < 1)
		 return false;
		else
			return true;
	}


}
