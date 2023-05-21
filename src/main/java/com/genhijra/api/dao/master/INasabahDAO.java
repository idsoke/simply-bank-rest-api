package com.genhijra.api.dao.master;
import com.genhijra.api.entity.master.Nasabah;


import java.util.List;

public interface INasabahDAO {
	
	List<Nasabah> getNasabah();
	Nasabah getNasabah(int nasId);
	List<Nasabah> getNasabahByNorek(String norek);
	Nasabah createNasabah(Nasabah nasabah);

}
