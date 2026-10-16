package com.lastma.data.repositories;

import com.lastma.data.models.Officer;
import java.util.ArrayList;

public interface OfficerRepository {
    Officer save(Officer officer);
    Officer findById(int id);
    Officer findByBadgeNumber(String badgeNumber);
    ArrayList findAll();
    public long count();
    public void deleteById(int id);
    public void delete(Officer officer);
    public void deleteAll();
    public boolean existsById(int id);
}
