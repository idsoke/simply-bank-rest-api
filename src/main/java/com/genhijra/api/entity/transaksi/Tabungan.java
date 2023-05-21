package com.genhijra.api.entity.transaksi;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tabungan")
public class Tabungan implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="norek")
	private String noRekening;

	@Column(name="jenis_transaksi")
	private Integer jenisTransaksi;

	public Integer getJenisTransaksi() {
		return jenisTransaksi;
	}

	public void setJenisTransaksi(Integer jenisTransaksi) {
		this.jenisTransaksi = jenisTransaksi;
	}

	@Column(name="jumlah")
	private BigDecimal jumlah;

	public BigDecimal getJumlah() {
		return jumlah;
	}

	public void setJumlah(BigDecimal jumlah) {
		this.jumlah = jumlah;
	}

	@Column(name="tran_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tranDate;

	public String getNoRekening() {
		return noRekening;
	}

	public void setNoRekening(String noRekening) {
		this.noRekening = noRekening;
	}

	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
