package com.example.btl.model;

import com.example.btl.model.dto.CusView;
import com.example.btl.model.entities.Setting;
import com.example.btl.repository.CustomerRepository;
import com.example.btl.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.TimerTask;

@Configuration
public class SendMailJob extends TimerTask {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MailModel mailModel;
    @Autowired
    private SettingRepository settingRepository;

    public void startSendMail(List<CusView> views, Setting setting){
        System.out.println("Setting status auto: "+setting.getStatusAu()+" - Setting status warning: "+setting.getStatusWar());
        for (CusView view: views){
            System.out.println("Status: "+view.getStatusC());
            if(view.getStatusC() == 1 && setting.getStatusAu()==1){
                String msg= "CÔNG TY NƯỚC SẠCH HÀ NỘI\n" +
                        "MST: 0012123123\n" +
                        "Điện thoại:0274747474\n" +
                        "Số tài khoản:01278234982340 - Ngân hàng BIDV chi nhánh HN\n" +
                        "-----------------------------------------------------------\n" +
                        "Kính gửi: "+view.getName()+", \n" +
                        "Địa chỉ: "+view.getAddress()+",\n\n"+
                        "Số nước: "+view.getNumWater()+" - khối nước tiêu thụ(m3): "+view.getVolume()
                        +" - Đơn giá: "+view.getPrice()+"k vnđ"+" - Thành tiền: "+(view.getPrice()* view.getVolume()*1000)+"Vnđ";

                System.out.println(msg);
                mailModel.sendEmail(view.getEmail(), "Thông báo đóng tiền nước",msg);
            }

            if(view.getStatusC() == 2 && setting.getStatusWar()==1){
                String msg= "CÔNG TY NƯỚC SẠCH HÀ NỘI\n" +
                        "MST: 0012123123\n" +
                        "Điện thoại:0274747474\n" +
                        "Số tài khoản:01278234982340 - Ngân hàng BIDV chi nhánh HN\n" +
                        "-----------------------------------------------------------\n" +
                        "-------------------THÔNG BÁO NHẮC NHỞ ĐÓNG TIỀN------------\n"+
                        "Kính gửi: "+view.getName()+", \n" +
                        "Địa chỉ: "+view.getAddress()+",\n\n"+
                        "Số nước: "+view.getNumWater()+" - khối nước tiêu thụ(m3): "+view.getVolume()
                        +" - Đơn giá: "+view.getPrice()+"k vnđ"+" - Thành tiền: "+(view.getPrice()* view.getVolume()*1000)+"Vnđ";

                System.out.println(msg);
                mailModel.sendEmail(view.getEmail(), "Thông báo đóng tiền nước",msg);
            }
        }
    }

    @Override
    public void run() {
        List<CusView> views = customerRepository.findAllByStatus();
        System.out.println("Size view: "+views.size());
        Setting setting = settingRepository.findById(1);
        if(setting.getStatusAu()==1 || setting.getStatusWar()==1){
            startSendMail(views, setting);
        }
    }
}
