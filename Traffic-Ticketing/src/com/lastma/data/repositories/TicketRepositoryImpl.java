package com.lastma.data.repositories;

import com.lastma.data.models.Ticket;
import java.util.ArrayList;

public class TicketRepositoryImpl implements TicketRepository {
    private ArrayList tickets = new ArrayList();
    private int lastGeneratedId = 0;

    @Override
    public Ticket save(Ticket ticket) {
        if (ticket == null) {
            return null;
        }

        if (ticket.getId() == 0) {
            lastGeneratedId = lastGeneratedId + 1;
            ticket.setId(lastGeneratedId);
            tickets.add(ticket);
        } else {
            boolean isFound = false;
            for (int count = 0; count < tickets.size(); count++) {
                Ticket existingTicket = (Ticket) tickets.get(count);
                if (existingTicket.getId() == ticket.getId()) {
                    tickets.set(count, ticket);
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                if (ticket.getId() > lastGeneratedId) {
                    lastGeneratedId = ticket.getId();
                }
                tickets.add(ticket);
            }
        }
        return ticket;
    }

    @Override
    public Ticket findById(int id) {
        for (int count = 0; count < tickets.size(); count++) {
            Ticket currentTicket = (Ticket) tickets.get(count);
            if (currentTicket.getId() == id) {
                return currentTicket;
            }
        }
        return null;
    }

    @Override
    public ArrayList findByDriverId(int driverId) {
        ArrayList driverTickets = new ArrayList();
        for (int count = 0; count < tickets.size(); count++) {
            Ticket currentTicket = (Ticket) tickets.get(count);
            if (currentTicket.getDriverId() == driverId) {
                driverTickets.add(currentTicket);
            }
        }
        return driverTickets;
    }

    @Override
    public ArrayList findByPlateNumber(String plateNumber) {
        ArrayList plateTickets = new ArrayList();
        if (plateNumber == null) {
            return plateTickets;
        }
        for (int count = 0; count < tickets.size(); count++) {
            Ticket currentTicket = (Ticket) tickets.get(count);
            if (currentTicket.getPlateNumber() != null && currentTicket.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                plateTickets.add(currentTicket);
            }
        }
        return plateTickets;
    }

    @Override
    public ArrayList findAll() {
        ArrayList allTickets = new ArrayList();
        for (int count = 0; count < tickets.size(); count++) {
            allTickets.add(tickets.get(count));
        }
        return allTickets;
    }

    @Override
    public long count() {
        return tickets.size();
    }

    @Override
    public void deleteById(int id) {
        for (int count = 0; count < tickets.size(); count++) {
            Ticket currentTicket = (Ticket) tickets.get(count);
            if (currentTicket.getId() == id) {
                tickets.remove(count);
                break;
            }
        }
    }

    @Override
    public void delete(Ticket ticket) {
        if (ticket != null) {
            deleteById(ticket.getId());
        }
    }

    @Override
    public void deleteAll() {
        tickets.clear();
        lastGeneratedId = 0;
    }

    @Override
    public boolean existsById(int id) {
        Ticket foundTicket = findById(id);
        return foundTicket != null;
    }
}
