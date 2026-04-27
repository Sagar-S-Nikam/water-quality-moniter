//package com.project.watermonitor.service;
//
//public class HomeService {
//}

package com.project.watermonitor.service;

import com.project.watermonitor.model.HomeData;
import com.project.watermonitor.model.UserData;
import com.project.watermonitor.repository.HomeDataRepository;
import com.project.watermonitor.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    @Autowired
    private HomeDataRepository homeRepository;

    @Autowired
    private UserDataRepository userRepository;

    // ✅ Add new home
    public HomeData addHome(Long userId, HomeData home) {
        UserData user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        home.setUser(user);
        return homeRepository.save(home);
    }

    // ✅ Get all homes of a user
    public List<HomeData> getHomesByUser(Long userId) {
        return homeRepository.findByUserId(userId);
    }

    // ✅ Get single home (used for simulation)
    public HomeData getHomeById(Long homeId) {
        return homeRepository.findById(homeId)
                .orElseThrow(() -> new RuntimeException("Home not found"));
    }

    // ✅ Delete home (optional)
    public void deleteHome(Long homeId) {
        homeRepository.deleteById(homeId);
    }
}
