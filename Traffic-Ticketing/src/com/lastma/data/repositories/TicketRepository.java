package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;
import java.util.ArrayList;

public interface TicketRepository {
    Ticket save(Ticket ticket);
    Ticket findById(int id);
    ArrayList findByDriverId(int driverId);
    ArrayList findByPlateNumber(String plateNumber);
    ArrayList findAll();
    long count();
    void deleteById(int id);
    void delete(Ticket ticket);
    void deleteAll();
    boolean existsById(int id);
}
