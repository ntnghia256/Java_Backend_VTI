package com.vti.ProductManagement.backend.business_layer;

import java.sql.SQLException;

import com.vti.ProductManagement.backend.data_layer.IManufacturerRepository;
import com.vti.ProductManagement.backend.data_layer.ManufacturerRepository;
import com.vti.ProductManagement.backend.entity.Manufacturer;

public class ManufacturerService implements IManufacturerService {
	private IManufacturerRepository manufacturerRepository;
	
	public ManufacturerService() {
		manufacturerRepository = new ManufacturerRepository();
	}

	@Override
	public Manufacturer getManufacturerById(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return manufacturerRepository.getManufacturerById(id);
	}

}
