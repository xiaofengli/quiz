package com.quiz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.quiz.repository.QuizRepository;
import io.swagger.annotations.ApiOperation;

@Controller
public class QuizController {
	@Autowired
	QuizRepository quizRepo;

	@GetMapping("/quiz/question/{id}")
	@ApiOperation(value = "get question info")
	public ResponseEntity<?> getQestions(@PathVariable int id) {
		//List<Map<String, Object>> account = quitzRepo.getQuestionById(id);
		List<Map<String, Object>> account = new ArrayList<>();
		HashMap<String, Object> response = new HashMap<>();
		response.put("Options", account);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/*
	@PostMapping("/fidelity/banktransfer/etl")
	@ApiOperation(value = "Process data for bank transfer csv file")
	public ResponseEntity<?> bankTransferETL() {
		HashMap<String, ArrayList<BankTransferRecord>> map = bankTransferParser.parse();
		HashMap<String, Object> response = new HashMap<>();
		response.put("Records", map);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/fidelity/banktransfer/all")
	public ResponseEntity<?> showAllBankTransfer(Model model) {
		List<BankTransferRecord> list = bankTransferRepository.findAll();
		HashMap<String, Object> response = new HashMap<>();
		response.put("BankTransfers", list);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Daily earning per day")
	@GetMapping("/fidelity/closeposition/gainloss/daily")
	public ResponseEntity<?> getEarningBySoldDate() {
		ArrayList<?> objs = gainlossRepo.getEarningBySoldDate();
		return new ResponseEntity<>(objs, HttpStatus.OK);
	}
	

	@ApiOperation(value = "Get all gains, raw data")
	@GetMapping("/fidelity/closeposition/gainloss/account/all")
	public ResponseEntity<?> showAllStocksGainsByAccount() {
		ArrayList<?> obj = gainlossRepo.getEarningYTDAllAccounts();
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@ApiOperation(value = "Get total of short_term, long_term and date range.")
	@GetMapping("/fidelity/closeposition/gainloss/summary")
	public ResponseEntity<?> getTotalEarningSummary() {
		ArrayList<?> obj = gainlossRepo.getTotalEarningSummary();
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	// Stock performance analysis
	@ApiOperation(value = "Get total of short_term, long_term and date range.")
	@GetMapping("/fidelity/closeposition/gainloss/stock/totalearning")
	public ResponseEntity<?> getEarningsBySymbolOrderByTotalEarning() {
		ArrayList<?> obj = gainlossRepo.getEarningsBySymbolOrderByTotalEarning();
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	// Stock performance analysis
	@ApiOperation(value = "Get total of short_term, long_term and date range.")
	@RequestMapping("/fidelity/closeposition/gainloss/stock/eps")
	public ResponseEntity<?> getEarningsBySymbolOrderByEarningPerShare() {
		ArrayList<?> obj = gainlossRepo.getEarningsBySymbolOrderByEarningPerShare();
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add Stock Symbol Information")
	@RequestMapping(value= "/fidelity/stock/add",  method=RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<?> addStockSymbolInfo(@RequestBody StockSymbol symbol) {
		stockSymbolRepository.save(symbol);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add Stock Symbol Meta Information")
	@RequestMapping(value = "/fidelity/stockmeta/add", method=RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<?> addStockSymbolMetaInfo(@RequestBody MultiValueMap<String, String> formData) {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add Stock Wash Sale Symbol Information")
	@PostMapping(value= "/fidelity/stock/wash/add")
	// TODO try to see if we can serlize to washsale symbol object, the map is working, it is ok.
	public ResponseEntity<?> addWashSaleSymbol(@RequestBody Map<String, Object> map) {
		System.out.println("testing testing");
		//washSaleRepo.save(symbol);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
   */
}