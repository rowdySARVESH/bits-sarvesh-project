package com.registry.repository;

import com.registry.model.Athlete;
import com.registry.model.LiftRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class LiftRecordRepositoryTest {

    @Autowired
    private LiftRecordRepository liftRecordRepository;

    @Autowired
    private AthleteRepository athleteRepository;

    @Test
    public void testFindAllRecordsWithAthletes() {
        Athlete athlete = new Athlete();
        athlete.setName("Test Lifter");
        athlete.setEmail("test@registry.sys");
        athleteRepository.save(athlete);

        LiftRecord record = new LiftRecord();
        record.setLiftType("Squat");
        record.setWeightKgs(200.0);
        record.setPerformanceDate(LocalDate.now());
        record.setAthlete(athlete);
        liftRecordRepository.save(record);

        List<LiftRecord> records = liftRecordRepository.findAllRecordsWithAthletes();
        assertFalse(records.isEmpty());
        assertNotNull(records.get(0).getAthlete());
        assertEquals("Test Lifter", records.get(0).getAthlete().getName());
    }
}
