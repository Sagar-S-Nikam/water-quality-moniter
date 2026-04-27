package com.project.watermonitor.controller;

import com.project.watermonitor.model.WaterData;
import com.project.watermonitor.repository.WaterDataRepository;
import com.project.watermonitor.service.SensorSimulator;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
//
//@RestController
//@RequestMapping("/api/simulator")
//@CrossOrigin   // important for Angular
//public class SimulatorController {
//
//    private final SensorSimulator simulator;
//
//    public SimulatorController(SensorSimulator simulator) {
//        this.simulator = simulator;
//    }
//
//    @PostMapping("/start")
//    public Map<String,String> start() {
//        simulator.start();
//        return Map.of("Message","Started");
//    }
//
//    @PostMapping("/stop")
//    public Map<String,String>stop() {
//        simulator.stop();
//        return Map.of("message","Stopped");
//    }
//
//    @GetMapping("/data")
//    public WaterData getData() {
//        return simulator.generateData();
//    }
//
//
//}

@RestController
@RequestMapping("/api/simulator")
@CrossOrigin // Essential for Angular/React to connect
public class SimulatorController {

    private final SensorSimulator simulator;
    private final WaterDataRepository repository; // Added repository access

    public SimulatorController(SensorSimulator simulator, WaterDataRepository repository) {
        this.simulator = simulator;
        this.repository = repository;
    }

    @PostMapping("/start")
    public Map<String,String> start() {
        simulator.start();
        return Map.of("message", "Started");
    }

    @PostMapping("/stop")
    public Map<String,String> stop() {
        simulator.stop();
        return Map.of("message", "Stopped");
    }

    // 1. FOR LIVE VALUES: Generates a single new reading
    @GetMapping("/data")
    public WaterData getLiveData() {
        return simulator.generateData();
    }

    // 2. FOR THE GRAPH: Fetches all stored data from the database
    @GetMapping("/history")
    public List<WaterData> getStoredData() {
        return repository.findAllByOrderByTimestampAsc();
    }
}