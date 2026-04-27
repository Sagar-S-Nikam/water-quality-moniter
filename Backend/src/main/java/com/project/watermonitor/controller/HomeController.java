package com.project.watermonitor.controller;

import com.project.watermonitor.model.HomeData;
import com.project.watermonitor.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homes")
public class HomeController {

    @Autowired
    private HomeService homeService;

    // ✅ FIXED: Added "/user" to match Angular's: /api/homes/user/{userId}
    @PostMapping("/user/{userId}")
    public ResponseEntity<HomeData> addHome(@PathVariable Long userId,
                                            @RequestBody HomeData home) {
        HomeData createdHome = homeService.addHome(userId, home);
        return ResponseEntity.ok(createdHome);
    }

    // ✅ FIXED: Added "/user" to match Angular's: /api/homes/user/{userId}
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<HomeData>> getHomes(@PathVariable Long userId) {
        List<HomeData> homes = homeService.getHomesByUser(userId);
        // We return an empty list [] instead of a 404 if no homes exist
        return ResponseEntity.ok(homes);
    }

    // ✅ Get single home: /api/homes/home/{homeId}
    @GetMapping("/home/{homeId}")
    public ResponseEntity<HomeData> getHome(@PathVariable Long homeId) {
        HomeData home = homeService.getHomeById(homeId);
        return ResponseEntity.ok(home);
    }

    // ✅ Delete home: /api/homes/{homeId}
    @DeleteMapping("/{homeId}")
    public ResponseEntity<String> deleteHome(@PathVariable Long homeId) {
        homeService.deleteHome(homeId);
        return ResponseEntity.ok("Home deleted successfully");
    }
}