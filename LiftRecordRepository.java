package com.registry.repository;

import com.registry.model.LiftRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LiftRecordRepository extends JpaRepository<LiftRecord, Long> {
    // Custom query fulfilling the Inner Join requirement and optimizing fetch plan
    @Query("SELECT r FROM LiftRecord r JOIN FETCH r.athlete")
    List<LiftRecord> findAllRecordsWithAthletes();
}
