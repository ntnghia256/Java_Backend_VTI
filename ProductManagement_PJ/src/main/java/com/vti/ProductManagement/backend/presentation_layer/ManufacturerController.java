package com.vti.ProductManagement.backend.presentation_layer;

import java.sql.SQLException;

import com.vti.ProductManagement.backend.business_layer.IManufacturerService;
import com.vti.ProductManagement.backend.business_layer.ManufacturerService;
import com.vti.ProductManagement.backend.entity.Manufacturer;

public class ManufacturerController {
	private IManufacturerService manufacturerService;
	
	public ManufacturerController() {
		manufacturerService = new ManufacturerService();
	}
	
	public Manufacturer getManufacturerById(int id) throws ClassNotFoundException, SQLException {
		return manufacturerService.getManufacturerById(id);
	}
}
