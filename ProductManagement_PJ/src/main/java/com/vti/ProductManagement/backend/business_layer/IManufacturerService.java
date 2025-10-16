package com.vti.ProductManagement.backend.business_layer;

import java.sql.SQLException;

import com.vti.ProductManagement.backend.entity.Manufacturer;

public interface IManufacturerService {
	Manufacturer getManufacturerById(int id) throws SQLException, ClassNotFoundException;

}
