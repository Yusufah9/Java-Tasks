package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;
import java.util.ArrayList;

public class VehicleRepositoryImpl implements VehicleRepository {
    private ArrayList vehicles = new ArrayList();
    private int lastGeneratedId = 0;

    @Override
    public Vehicle save(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }

        if (vehicle.getId() == 0) {
            lastGeneratedId = lastGeneratedId + 1;
            vehicle.setId(lastGeneratedId);
            vehicles.add(vehicle);
        } else {
            boolean isFound = false;
            for (int count = 0; count < vehicles.size(); count++) {
                Vehicle existingVehicle = (Vehicle) vehicles.get(count);
                if (existingVehicle.getId() == vehicle.getId()) {
                    vehicles.set(count, vehicle);
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                if (vehicle.getId() > lastGeneratedId) {
                    lastGeneratedId = vehicle.getId();
                }
                vehicles.add(vehicle);
            }
        }
        return vehicle;
    }

    @Override
    public Vehicle findById(int id) {
        for (int count = 0; count < vehicles.size(); count++) {
            Vehicle currentVehicle = (Vehicle) vehicles.get(count);
            if (currentVehicle.getId() == id) {
                return currentVehicle;
            }
        }
        return null;
    }

    @Override
    public Vehicle findByPlateNumber(String plateNumber) {
        if (plateNumber == null) {
            return null;
        }
        for (int count = 0; count < vehicles.size(); count++) {
            Vehicle currentVehicle = (Vehicle) vehicles.get(count);
            if (currentVehicle.getPlateNumber() != null && currentVehicle.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                return currentVehicle;
            }
        }
        return null;
    }

    @Override
    public ArrayList findByDriverId(int driverId) {
        ArrayList driverVehicles = new ArrayList();
        for (int count = 0; count < vehicles.size(); count++) {
            Vehicle currentVehicle = (Vehicle) vehicles.get(count);
            if (currentVehicle.getDriverId() == driverId) {
                driverVehicles.add(currentVehicle);
            }
        }
        return driverVehicles;
    }

    @Override
    public ArrayList findAll() {
        ArrayList allVehicles = new ArrayList();
        for (int count = 0; count < vehicles.size(); count++) {
            allVehicles.add(vehicles.get(count));
        }
        return allVehicles;
    }

    @Override
    public long count() {
        return vehicles.size();
    }

    @Override
    public void deleteById(int id) {
        for (int count = 0; count < vehicles.size(); count++) {
            Vehicle currentVehicle = (Vehicle) vehicles.get(count);
            if (currentVehicle.getId() == id) {
                vehicles.remove(count);
                break;
            }
        }
    }

    @Override
    public void delete(Vehicle vehicle) {
        if (vehicle != null) {
            deleteById(vehicle.getId());
        }
    }

    @Override
    public void deleteAll() {
        vehicles.clear();
        lastGeneratedId = 0;
    }

    @Override
    public boolean existsById(int id) {
        Vehicle foundVehicle = findById(id);
        return foundVehicle != null;
    }
}
