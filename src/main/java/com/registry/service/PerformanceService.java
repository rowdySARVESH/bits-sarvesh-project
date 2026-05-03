package com.registry.service;

import com.registry.model.Athlete;
import com.registry.model.LiftRecord;
import com.registry.repository.AthleteRepository;
import com.registry.repository.LiftRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PerformanceService {

    private final AthleteRepository athleteRepository;
    private final LiftRecordRepository liftRecordRepository;

    public PerformanceService(AthleteRepository athleteRepository, LiftRecordRepository liftRecordRepository) {
        this.athleteRepository = athleteRepository;
        this.liftRecordRepository = liftRecordRepository;
    }

    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }

    public List<LiftRecord> getAllLiftRecords() {
        // Calls the custom JOIN FETCH query to prevent N+1 degradation
        return liftRecordRepository.findAllRecordsWithAthletes();
    }

    public void saveLiftRecord(LiftRecord record) {
        liftRecordRepository.save(record);
    }

    public LiftRecord getRecordById(Long id) {
        return liftRecordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Record ID: " + id));
    }
}
