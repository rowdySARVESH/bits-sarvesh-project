package com.registry.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "athletes")
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long athleteId;

    @NotBlank(message = "Athlete name cannot be blank")
    private String name;

    @Email(message = "Must be a valid email format")
    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;

    private String weightClass;

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LiftRecord> liftRecords;

    // Getters and Setters
    public Long getAthleteId() { return athleteId; }
    public void setAthleteId(Long athleteId) { this.athleteId = athleteId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getWeightClass() { return weightClass; }
    public void setWeightClass(String weightClass) { this.weightClass = weightClass; }
    public List<LiftRecord> getLiftRecords() { return liftRecords; }
    public void setLiftRecords(List<LiftRecord> liftRecords) { this.liftRecords = liftRecords; }
}
