package com.rentalcars.mobiledemo.model;

import lombok.Data;

@Data
public class AirshipResponse {

    private String[] push_ids;

    private String[] localized_ids;

    private String operation_id;

    private String[] message_ids;

    private String ok;

    private String[] content_urls;


}
