package org.example.service;


import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MailService {
    private ZoneId zoneId=ZoneId.systemDefault();

    private void setZoneId(ZoneId id){
        this.zoneId=id;
    }

    public String getTime() {
        return ZonedDateTime.now(this.zoneId).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }//这个时间的写法还需要进一步学习一下

    public void sendLoginEmail(){
        System.out.println("send login Email");
    }

    public void sendRegisterEmail(){
        System.out.println("send register Email");
    }
}
