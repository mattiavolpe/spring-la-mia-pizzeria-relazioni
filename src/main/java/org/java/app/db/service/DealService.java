package org.java.app.db.service;

import org.java.app.db.pojo.Deal;
import org.java.app.db.repo.DealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealService {
	@Autowired DealRepo dealRepo;
	
	public void saveDeal(Deal deal) {
		dealRepo.save(deal);
	}
}
