package com.example.btl.repository;

import com.example.btl.model.entities.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, Integer> {
    Setting findById(int id);
}
