package com.example.btl.model;

import com.example.btl.model.dto.CusView;
import com.example.btl.model.dto.CustomerService;
import com.example.btl.model.entities.Customer;
import com.example.btl.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

@Configuration
public class SendMailJob extends TimerTask {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MailModel mailModel;

    public void startSendMail(){
        new Thread(new Runnable() {
            @Override
            public void run() {


            }
        }).start();
    }

    @Override
    public void run() {
        List<CusView> views = customerRepository.findAllByStatus();
        System.out.println("Size view: "+views.size());
        for (CusView view: views){
            System.out.println("Status: "+view.getStatusC());
            if(view.getStatusC() == 1){
                String msg= "CÔNG TY NƯỚC SẠCH HÀ NỘI\n" +
                        "MST: 0012123123\n" +
                        "Điện thoại:0274747474\n" +
                        "Số tài khoản:01278234982340 - Ngân hàng BIDV chi nhánh HN\n" +
                        "-----------------------------------------------------------\n" +
                        "Kính gửi: "+view.getName()+", \n" +
                        "Địa chỉ: "+view.getAddress()+",\n\n"+
                        "Số nước: "+view.getNumWater()+" - khối nước tiêu thụ(m3): "+view.getVolume()
                        +" - Đơn giá: "+view.getPrice()+" - Thành tiền: "+(view.getPrice()* view.getVolume())+"Vnđ";

                System.out.println(msg);
                mailModel.sendEmail(view.getEmail(), "Thông báo đóng tiền nước",msg);
            }

            if(view.getStatusC() == 2){

            }
        }
    }
}
