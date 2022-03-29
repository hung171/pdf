package com.example.btl.controller;

import com.example.btl.model.entities.Setting;
import com.example.btl.repository.SettingRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingController {
    @Autowired
    private SettingRepository settingRepository;

    @PostMapping("/setting")
    public JSONObject setting(@RequestBody Setting body)
    {
        JSONObject js= new JSONObject();
        Setting setting = settingRepository.findById(1);
        System.out.println(body.getStatusAu()+" - "+body.getStatusWar());
        setting.setStatusAu(body.getStatusAu());
        setting.setStatusWar(body.getStatusWar());
        settingRepository.save(setting);
        js.put("code","00");
        return js;
    }
}
