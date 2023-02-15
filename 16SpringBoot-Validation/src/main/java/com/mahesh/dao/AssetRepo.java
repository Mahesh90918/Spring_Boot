package com.mahesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.model.Asset;

public interface AssetRepo extends JpaRepository<Asset, Integer> {

}
