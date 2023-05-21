package com.genhijra.api.controller;

import com.genhijra.api.entity.master.Nasabah;
import com.genhijra.api.services.master.INasabahService;
import com.genhijra.api.util.GenHijraCommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("nasabahservice")
public class NasabahController {

	private static final String DATE ="yyyy-mm-dd";

	Date nowDate;

	String nowTimestamp = DateTimeFormatter.ofPattern(DATE).format(LocalDateTime.now());
	@Autowired
	private INasabahService service;
	
	@GetMapping("nasabah")
	public ResponseEntity<List<Nasabah>> getNasabah(){
		
		List<Nasabah> nasabah = service.getNasabah();
		return new ResponseEntity<List<Nasabah>>(nasabah, HttpStatus.OK);
		
	}
	
	@GetMapping("nasabah/{id}")
	public ResponseEntity<Nasabah> getNasabah(@PathVariable("id") Integer id){
		Nasabah nasabah = service.getNasabah(id);
		return new ResponseEntity<Nasabah>(nasabah, HttpStatus.OK);
	}
	
	@PostMapping("nasabah")
	public ResponseEntity<GenHijraCommonResponse> createNasabah(@RequestBody Nasabah nasabah){

		GenHijraCommonResponse<String> response = new GenHijraCommonResponse<>();


		try {

			boolean cekRekening = service.getNasabahByNorek(nasabah.getNoRekening());
			if(cekRekening == true){

					response.setResponse(nasabah.getNoRekening() + " -> Norekening sudah ada");
					return new ResponseEntity<GenHijraCommonResponse>(response, HttpStatus.BAD_REQUEST);


			}

			Date tanggalLahir = new SimpleDateFormat(DATE).parse(nasabah.getTtl());

			LocalDateTime dateNow = LocalDateTime.now();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Date dateLahir = sdf.parse(nasabah.getTtl());
			Date dateSekarang = sdf.parse(dateNow.toString());

			if(dateLahir.after(dateSekarang)){
				response.setResponse(nasabah.getTtl() + " -> Tanggal lahir tidak valid");
				return new ResponseEntity<GenHijraCommonResponse>(response, HttpStatus.BAD_REQUEST);
			}

		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		if (nasabah.getNama().toString().length() < 3) {
			response.setResponse(nasabah.getNama() + " -> Gunakan minimal 3 digit untuk field nama");
			return new ResponseEntity<GenHijraCommonResponse>(response, HttpStatus.BAD_REQUEST);
		}else{
			Nasabah b = service.createNasabah(nasabah);
			response.setResponse("Data Nasabah berhasil disimpan");
			return new ResponseEntity<GenHijraCommonResponse>(response, HttpStatus.BAD_REQUEST);
		}

	}

}
