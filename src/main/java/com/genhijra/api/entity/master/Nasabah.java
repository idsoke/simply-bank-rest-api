package com.genhijra.api.entity.master;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="nasabah")
public class Nasabah implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="nama")
	private String nama;


	@Column(name="norekening")
	private String noRekening;

	public String getNoRekening() {
		return noRekening;
	}

	public void setNoRekening(String noRekening) {
		this.noRekening = noRekening;
	}

	@Column(name="ttl")
	private String ttl;

	@Column(name="alamat")
	private String alamat;

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTtl() {
		return ttl;
	}

	public void setTtl(String ttl) {
		this.ttl = ttl;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
