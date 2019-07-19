package com.rentalcars.mobiledemo.controller;

import com.rentalcars.mobiledemo.model.AirshipRequest;
import com.rentalcars.mobiledemo.model.AirshipResponse;
import com.rentalcars.mobiledemo.model.Request;
import com.rentalcars.mobiledemo.service.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class PushController {

    @Autowired
    private RequestMapper requestMapper;
    private RestTemplate restTemplate = new RestTemplate();

    @PostMapping(value = "/send")
    public ResponseEntity postSendMessage(@RequestBody Request request) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.set("Accept", "application/vnd.urbanairship+json; version=3");
        headers.setBasicAuth("VsVJCFUpSEqZ_5G0_ItE5w", "IEsQCGE5QjOgyPr4ujDUbw");

        HttpEntity<AirshipRequest> asrequest = new HttpEntity<>(requestMapper.mapRequestToAirShipRequest(request), headers);

        try {
            AirshipResponse response = restTemplate.postForObject("https://go.urbanairship.com/api/push/", asrequest, AirshipResponse.class);
        } catch (Exception e) {

            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("OK", HttpStatus.OK);
    }


}
