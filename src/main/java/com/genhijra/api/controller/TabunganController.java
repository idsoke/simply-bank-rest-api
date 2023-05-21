package com.genhijra.api.controller;

import com.genhijra.api.entity.transaksi.ReportInquiry;
import com.genhijra.api.entity.transaksi.Tabungan;
import com.genhijra.api.util.GenHijraCommonResponse;
import com.genhijra.api.services.transaksi.ITabunganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("tabunganservice")
public class TabunganController {
	
	@Autowired
	private ITabunganService service;
	
	@GetMapping("tabungan")
	public ResponseEntity<List<Tabungan>> getTabungan(){
		List<Tabungan> tabungan = service.getTabungan();
		return new ResponseEntity<List<Tabungan>>(tabungan, HttpStatus.OK);
	}

	@GetMapping("tabungan/{norek}")
	public ResponseEntity<List<Tabungan>> getTabunganByRek(@PathVariable("norek") String norek){
		List<Tabungan> tabungan = service.getTabunganByRek(norek);
		return new ResponseEntity<List<Tabungan>>(tabungan, HttpStatus.OK);
	}

//	@GetMapping("tabungan/{startDate}/{endDate}/")
//	public ResponseEntity<List<Tabungan>> getTabunganByDate(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
//		List<Tabungan> tabungan = service.getTabunganByBetweenDate(startDate , endDate);
//		return new ResponseEntity<List<Tabungan>>(tabungan, HttpStatus.OK);
//	}
	
	@GetMapping("books/{id}")
	public ResponseEntity<Tabungan> getTabungan(@PathVariable("id") Integer id){
		Tabungan tabungan = service.getTabungan(id);
		return new ResponseEntity<Tabungan>(tabungan, HttpStatus.OK);
	}


	@PostMapping("tabungan")
	public ResponseEntity<GenHijraCommonResponse> createBook(@RequestBody Tabungan tabungan){

		GenHijraCommonResponse<String> response = new GenHijraCommonResponse<>();

			if(tabungan.getJumlah().doubleValue() < 0) {


				response.setResponse("Nilai transaksi tidak diizinkan Minus : " + tabungan.getJumlah());
				return new ResponseEntity<GenHijraCommonResponse>(response, HttpStatus.BAD_REQUEST);

			}else{

				Tabungan b = service.createTabungan(tabungan);
				response.setResponse("Transaksi Berhasil");

				return new ResponseEntity<GenHijraCommonResponse>(response, HttpStatus.OK);

			}

	}

	@GetMapping("getTabunganByBetweenDate")
	public ResponseEntity<List<Tabungan>> getTabunganByBetweenDate(@RequestBody ReportInquiry reportInquiry){
		List<Tabungan> tabungan = service.getTabunganByBetweenDate(reportInquiry);
		return new ResponseEntity<List<Tabungan>>(tabungan, HttpStatus.OK);
	}
	

	

}
