package com.lastma.data.repositories;

import com.lastma.data.models.Driver;
import java.util.ArrayList;

public class DriverRepositoryImpl implements DriverRepository {
    private ArrayList drivers = new ArrayList();
    private int lastGeneratedId = 0;

    @Override
    public Driver save(Driver driver) {
        if (driver == null) {
            return null;
        }

        if (driver.getId() == 0) {
            lastGeneratedId = lastGeneratedId + 1;
            driver.setId(lastGeneratedId);
            drivers.add(driver);
        } else {
            boolean isFound = false;
            for (int count = 0; count < drivers.size(); count++) {
                Driver existingDriver = (Driver) drivers.get(count);
                if (existingDriver.getId() == driver.getId()) {
                    drivers.set(count, driver);
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                if (driver.getId() > lastGeneratedId) {
                    lastGeneratedId = driver.getId();
                }
                drivers.add(driver);
            }
        }
        return driver;
    }

    @Override
    public Driver findById(int id) {
        for (int count = 0; count < drivers.size(); count++) {
            Driver currentDriver = (Driver) drivers.get(count);
            if (currentDriver.getId() == id) {
                return currentDriver;
            }
        }
        return null;
    }

    @Override
    public Driver findByLicenseNumber(String licenseNumber) {
        if (licenseNumber == null) {
            return null;
        }
        for (int count = 0; count < drivers.size(); count++) {
            Driver currentDriver = (Driver) drivers.get(count);
            if (currentDriver.getLicenseNumber() != null && currentDriver.getLicenseNumber().equalsIgnoreCase(licenseNumber)) {
                return currentDriver;
            }
        }
        return null;
    }

    @Override
    public ArrayList findAll() {
        ArrayList allDrivers = new ArrayList();
        for (int count = 0; count < drivers.size(); count++) {
            allDrivers.add(drivers.get(count));
        }
        return allDrivers;
    }

    @Override
    public long count() {
        return drivers.size();
    }

    @Override
    public void deleteById(int id) {
        for (int count = 0; count < drivers.size(); count++) {
            Driver currentDriver = (Driver) drivers.get(count);
            if (currentDriver.getId() == id) {
                drivers.remove(count);
                break;
            }
        }
    }

    @Override
    public void delete(Driver driver) {
        if (driver != null) {
            deleteById(driver.getId());
        }
    }

    @Override
    public void deleteAll() {
        drivers.clear();
        lastGeneratedId = 0;
    }

    @Override
    public boolean existsById(int id) {
        Driver foundDriver = findById(id);
        return foundDriver != null;
    }
}
