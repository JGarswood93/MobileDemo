package com.rentalcars.mobiledemo.service;

import com.rentalcars.mobiledemo.model.AirshipRequest;
import com.rentalcars.mobiledemo.model.Audience;
import com.rentalcars.mobiledemo.model.Notification;
import com.rentalcars.mobiledemo.model.Request;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class RequestMapper {


    public AirshipRequest mapRequestToAirShipRequest(Request request) {

        Audience audience = new Audience();
        Notification notification = new Notification();

        audience.setNamed_user(request.getNamedUser());
        notification.setAlert(request.getMessage());
        AirshipRequest airshipRequest = new AirshipRequest();
        airshipRequest.setAudience(audience);
        airshipRequest.setNotification(notification);
        airshipRequest.setDevice_types(new String[]{"ios", "android"});
        return airshipRequest;


    }
}
