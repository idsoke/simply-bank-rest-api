package com.genhijra.api.services.transaksi;

import com.genhijra.api.dao.transaksi.ITabunganDAO;
import com.genhijra.api.entity.transaksi.ReportInquiry;
import com.genhijra.api.entity.transaksi.Tabungan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TabunganService implements ITabunganService {
	
	@Autowired
	private ITabunganDAO dao;

	private static final String DATE ="yyyy-mm-dd";

	@Override
	public List<Tabungan> getTabungan() {
		return dao.getTabungan();
	}

	@Override
	public List<Tabungan> getTabunganByRek(String cif) {
		return dao.getTabunganByRek(cif);
	}

	@Override
	public List<Tabungan> getTabunganByBetweenDate(ReportInquiry reportInquiry) {

		Date start, end = null;

		try {
			start = new SimpleDateFormat(DATE).parse(reportInquiry.getStartDate());
			end = new SimpleDateFormat(DATE).parse(reportInquiry.getEndDate());


		} catch (ParseException e) {
			throw new RuntimeException(e);
		}


		return dao.getTabunganByBetweenDate(start, end);
	}


	@Override
	public Tabungan createTabungan(Tabungan tabungan) {
		return dao.createTabungan(tabungan);
	}

	@Override
	public Tabungan getTabungan(int tabunganId) {
		return dao.getTabungan(tabunganId);
	}


}
