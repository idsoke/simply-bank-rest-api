package com.genhijra.api.dao.transaksi;

import com.genhijra.api.entity.transaksi.Tabungan;

import java.util.Date;
import java.util.List;

public interface ITabunganDAO {
	
	List<Tabungan> getTabungan();
	Tabungan getTabungan(int tabId);
	Tabungan createTabungan(Tabungan tabungan);

	List<Tabungan> getTabunganByRek(String cif);

	List<Tabungan> getTabunganByBetweenDate(Date startDate, Date endDate);

}
