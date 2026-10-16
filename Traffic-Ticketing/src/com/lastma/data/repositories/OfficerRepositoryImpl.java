package com.lastma.data.repositories;

import com.lastma.data.models.Officer;
import java.util.ArrayList;

public class OfficerRepositoryImpl implements OfficerRepository {
    private ArrayList officers = new ArrayList();
    private int lastGeneratedId = 0;

    @Override
    public Officer save(Officer officer) {
        if (officer == null) {
            return null;
        }

        if (officer.getId() == 0) {
            lastGeneratedId = lastGeneratedId + 1;
            officer.setId(lastGeneratedId);
            officers.add(officer);
        } else {
            boolean isFound = false;
            for (int count = 0; count < officers.size(); count++) {
                Officer existingOfficer = (Officer) officers.get(count);
                if (existingOfficer.getId() == officer.getId()) {
                    officers.set(count, officer);
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                if (officer.getId() > lastGeneratedId) {
                    lastGeneratedId = officer.getId();
                }
                officers.add(officer);
            }
        }
        return officer;
    }

    @Override
    public Officer findById(int id) {
        for (int count = 0; count < officers.size(); count++) {
            Officer currentOfficer = (Officer) officers.get(count);
            if (currentOfficer.getId() == id) {
                return currentOfficer;
            }
        }
        return null;
    }

    @Override
    public Officer findByBadgeNumber(String badgeNumber) {
        if (badgeNumber == null) {
            return null;
        }
        for (int count = 0; count < officers.size(); count++) {
            Officer currentOfficer = (Officer) officers.get(count);
            if (currentOfficer.getBadgeNumber() != null && currentOfficer.getBadgeNumber().equalsIgnoreCase(badgeNumber)) {
                return currentOfficer;
            }
        }
        return null;
    }

    @Override
    public ArrayList findAll() {
        ArrayList allOfficers = new ArrayList();
        for (int count = 0; count < officers.size(); count++) {
            allOfficers.add(officers.get(count));
        }
        return allOfficers;
    }

    @Override
    public long count() {
        return officers.size();
    }

    @Override
    public void deleteById(int id) {
        for (int count = 0; count < officers.size(); count++) {
            Officer currentOfficer = (Officer) officers.get(count);
            if (currentOfficer.getId() == id) {
                officers.remove(count);
                break;
            }
        }
    }

    @Override
    public void delete(Officer officer) {
        if (officer != null) {
            deleteById(officer.getId());
        }
    }

    @Override
    public void deleteAll() {
        officers.clear();
        lastGeneratedId = 0;
    }

    @Override
    public boolean existsById(int id) {
        Officer foundOfficer = findById(id);
        return foundOfficer != null;
    }
}
