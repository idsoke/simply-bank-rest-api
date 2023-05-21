package com.genhijra.api.services.transaksi;

import com.genhijra.api.entity.transaksi.ReportInquiry;
import com.genhijra.api.entity.transaksi.Tabungan;

import java.util.List;

public interface ITabunganService {
	
	List<Tabungan> getTabungan();
	Tabungan createTabungan(Tabungan tabungan);
	Tabungan getTabungan(int tabunganId);
	List<Tabungan> getTabunganByRek(String cif);

	List<Tabungan> getTabunganByBetweenDate(ReportInquiry reportInquiry);






}
