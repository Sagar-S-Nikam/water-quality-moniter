package com.project.watermonitor.service;

import com.project.watermonitor.model.WaterData;
import com.project.watermonitor.repository.WaterDataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

//@Service
//public class SensorSimulator {
//
//    private final WaterDataRepository repository;
//    private boolean isSimulating = false;
//
//    public SensorSimulator(WaterDataRepository repository) {
//        this.repository = repository;
//    }
//
//    public void start() {
//        this.isSimulating = true;
//    }
//
//    public void stop() {
//        this.isSimulating = false;
//    }
//
//    public WaterData generateData() {
//        // Create new object
//        WaterData data = new WaterData();
//
//        // 1. Simulate the values
//        double ph = Math.round((6.0 + Math.random() * 3.0) * 100.0) / 100.0;
//        double turb = Math.round((Math.random() * 10.0) * 100.0) / 100.0;
//        double temp = Math.round((20.0 + Math.random() * 5.0) * 100.0) / 100.0;
//
//        // 2. Set the current Local Time
//        data.setTimestamp(LocalDateTime.now());
//
//        data.setPh(ph);
//        data.setTurbidity(turb);
//        data.setTemperature(temp);
//
//        // 3. Check against Thresholds
//        // Logic: pH (6.5-8.5 is safe), Turbidity (< 5.0 is safe)
//        if (ph < 6.5 || ph > 8.5 || turb > 5.0) {
//            data.setStatus("DANGER");
//        } else {
//            data.setStatus("SAFE");
//        }
//
//        // 4. Stored in DB
//        // We only save if the simulator has been "started"
//        if (isSimulating) {
//            return repository.save(data);
//        }
//
//        return data; // Return unsaved data if simulator is "stopped"
//    }
//}


import com.project.watermonitor.model.WaterData;
import com.project.watermonitor.repository.WaterDataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorSimulator {

    // 1. Dependency Injection: The service uses the repository
    private final WaterDataRepository repository;
    private boolean isSimulating = false;

    public SensorSimulator(WaterDataRepository repository) {
        this.repository = repository;
    }

    // --- DASHBOARD METHODS ---

    /**
     * This calls your custom repository method to get sorted data for the graph.
     */
    public List<WaterData> getHistory() {
        return repository.findAllByOrderByTimestampAsc();
    }

    public void start() {
        this.isSimulating = true;
    }

    public void stop() {
        this.isSimulating = false;
    }

    // --- SIMULATION LOGIC ---

    public WaterData generateData() {
        WaterData data = new WaterData();

        // Simulate values
        double ph = Math.round((6.0 + Math.random() * 3.0) * 100.0) / 100.0;
        double turb = Math.round((Math.random() * 10.0) * 100.0) / 100.0;
        double temp = Math.round((20.0 + Math.random() * 5.0) * 100.0) / 100.0;

        data.setTimestamp(LocalDateTime.now());
        data.setPh(ph);
        data.setTurbidity(turb);
        data.setTemperature(temp);

        // Logic: pH (6.5-8.5 is safe), Turbidity (< 5.0 is safe)
        if (ph < 6.5 || ph > 8.5 || turb > 5.0) {
            data.setStatus("DANGER");
        } else {
            data.setStatus("SAFE");
        }

        // 2. Persistence: Using the repository to save data
        if (isSimulating) {
            return repository.save(data);
        }

        return data;
    }
}