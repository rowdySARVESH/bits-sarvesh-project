package com.registry.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "lift_records")
public class LiftRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    @NotBlank(message = "Lift type (Squat/Bench/Deadlift) is mandatory")
    private String liftType;

    @Min(value = 0, message = "Weight cannot be negative")
    private Double weightKgs;

    @NotNull(message = "Performance date is required")
    private LocalDate performanceDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "athlete_id", nullable = false)
    @NotNull(message = "Athlete must be assigned")
    private Athlete athlete;

    // Getters and Setters
    public Long getRecordId() { return recordId; }
    public void setRecordId(Long recordId) { this.recordId = recordId; }
    public String getLiftType() { return liftType; }
    public void setLiftType(String liftType) { this.liftType = liftType; }
    public Double getWeightKgs() { return weightKgs; }
    public void setWeightKgs(Double weightKgs) { this.weightKgs = weightKgs; }
    public LocalDate getPerformanceDate() { return performanceDate; }
    public void setPerformanceDate(LocalDate performanceDate) { this.performanceDate = performanceDate; }
    public Athlete getAthlete() { return athlete; }
    public void setAthlete(Athlete athlete) { this.athlete = athlete; }
}
