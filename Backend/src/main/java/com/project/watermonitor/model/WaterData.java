package com.project.watermonitor.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class WaterData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double ph;
    private double turbidity;
    private double temperature;
    private String status;

    private LocalDateTime timestamp;

    // 🔹 Getters
    public Long getId() {
        return id;
    }

    public double getPh() {
        return ph;
    }

    public double getTurbidity() {
        return turbidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // 🔹 Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public void setTurbidity(double turbidity) {
        this.turbidity = turbidity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}