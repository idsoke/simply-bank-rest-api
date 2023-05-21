package com.genhijra.api.services.master;

import com.genhijra.api.entity.master.Nasabah;

import java.util.List;

public interface INasabahService {
	
	List<Nasabah> getNasabah();
	Nasabah createNasabah(Nasabah book);
	Nasabah getNasabah(int bookId);
	boolean getNasabahByNorek(String norek);

}
