package com.lastma.data.repositories;

import com.lastma.data.models.Driver;
import java.util.ArrayList;

public interface DriverRepository {
    Driver save(Driver driver);
    Driver findById(int id);
    Driver findByLicenseNumber(String licenseNumber);
    ArrayList findAll();
    public long count();
    public void deleteById(int id);
    public void delete(Driver driver);
    public void deleteAll();
    public boolean existsById(int id);
}
