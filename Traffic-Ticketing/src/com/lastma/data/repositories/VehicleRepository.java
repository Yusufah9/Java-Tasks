package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;
import java.util.ArrayList;

public interface VehicleRepository {
    Vehicle save(Vehicle vehicle);
    Vehicle findById(int id);
    Vehicle findByPlateNumber(String plateNumber);
    ArrayList findByDriverId(int driverId);
    ArrayList findAll();
    long count();
    void deleteById(int id);
    void delete(Vehicle vehicle);
    void deleteAll();
    boolean existsById(int id);
}
