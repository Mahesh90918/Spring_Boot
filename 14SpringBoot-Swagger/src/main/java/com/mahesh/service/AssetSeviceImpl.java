package com.mahesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.dao.AssetRepo;
import com.mahesh.model.Asset;
@Service
public class AssetSeviceImpl implements AssetService {

	@Autowired 
	AssetRepo repo;
	
	@Override
	public void save(Asset asset) {
		repo.save(asset);
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public void update(Asset asset) {
		repo.save(asset);
	}

	@Override
	public Asset getByAssetID(Integer id) {
		return repo.findById(id).get() ;
		
	}

	@Override
	public List<Asset> getAllAssets() {
		return repo.findAll();
	}

}
