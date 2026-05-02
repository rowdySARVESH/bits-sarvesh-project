package com.registry.service;

import com.registry.model.Athlete;
import com.registry.model.LiftRecord;
import com.registry.repository.AthleteRepository;
import com.registry.repository.LiftRecordRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PerformanceServiceTest {

    @Mock
    private AthleteRepository athleteRepository;

    @Mock
    private LiftRecordRepository liftRecordRepository;

    @InjectMocks
    private PerformanceService performanceService;

    @Test
    public void testGetAllAthletes() {
        Athlete athlete = new Athlete();
        athlete.setName("Test Athlete");
        when(athleteRepository.findAll()).thenReturn(List.of(athlete));

        List<Athlete> result = performanceService.getAllAthletes();
        assertEquals(1, result.size());
        assertEquals("Test Athlete", result.get(0).getName());
        verify(athleteRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllLiftRecords() {
        LiftRecord record = new LiftRecord();
        record.setLiftType("Deadlift");
        when(liftRecordRepository.findAllRecordsWithAthletes()).thenReturn(List.of(record));

        List<LiftRecord> result = performanceService.getAllLiftRecords();
        assertEquals(1, result.size());
        assertEquals("Deadlift", result.get(0).getLiftType());
    }

    @Test
    public void testSaveLiftRecord() {
        LiftRecord record = new LiftRecord();
        record.setLiftType("Squat");
        record.setWeightKgs(200.0);
        record.setPerformanceDate(LocalDate.now());

        performanceService.saveLiftRecord(record);
        verify(liftRecordRepository, times(1)).save(record);
    }

    @Test
    public void testGetRecordById_NotFound() {
        when(liftRecordRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> performanceService.getRecordById(99L));
    }

    @Test
    public void testGetRecordById_Found() {
        LiftRecord record = new LiftRecord();
        record.setLiftType("Bench");
        when(liftRecordRepository.findById(1L)).thenReturn(Optional.of(record));

        LiftRecord result = performanceService.getRecordById(1L);
        assertEquals("Bench", result.getLiftType());
    }
}
