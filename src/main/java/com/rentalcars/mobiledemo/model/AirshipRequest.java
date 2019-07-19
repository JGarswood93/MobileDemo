package com.rentalcars.mobiledemo.model;

import lombok.Data;

@Data
public class AirshipRequest {

    private Notification notification;

    private Audience audience;

    private String[] device_types;


}
