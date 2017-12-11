package braxxi.kursach.server.service;


import braxxi.kursach.commons.entity.EstateEntity;
import braxxi.kursach.commons.entity.UserEntity;
import braxxi.kursach.commons.model.EstimateEstateResponse;
import braxxi.kursach.commons.model.GenerateEstatesRequest;
import braxxi.kursach.commons.model.SearchEstate;
import braxxi.kursach.commons.model.SystemDictionary;
import braxxi.kursach.server.dao.EstateDao;
import braxxi.kursach.server.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DbService {

	@Autowired
	UserDao userDao;

	@Autowired
	EstateDao estateDao;

	public UserEntity isLoginValid(String login, String password) {
		return userDao.getUser(login, password);
	}

	public List<EstateEntity> searchEstate(SearchEstate searchEstate) {
		return estateDao.search(searchEstate);
	}

	public Long addEstate(EstateEntity estate) {
		return estateDao.addEstate(estate);
	}

	public EstateEntity getEstate(Long estateId) {
		return estateDao.getEstate(estateId);
	}

	public void updateEstate(EstateEntity entity) {
		estateDao.updateEstate(entity);
	}

	public SystemDictionary getDistricts() {
		return estateDao.getDistricts();
	}

	public void deleteEstate(Long estateId) {
		estateDao.deleteEstate(estateId);
	}

	public EstimateEstateResponse estimateEstate(EstateEntity requestEstate) {
		return estateDao.estimateEstate(requestEstate);
	}

	public void generateEstate(GenerateEstatesRequest request) {
		estateDao.generateEstate(request);
	}
}
