package com.song.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Song
 * @date 2020/06/27
 */
@RestController
@Slf4j
public class ComputeController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public int add(@RequestParam("a") Integer a,
                   @RequestParam("b") Integer b
    ) {
        ServiceInstance instance = client.getLocalServiceInstance();
        log.info("[add]host->{},service_id->{}", instance.getHost(), instance.getServiceId());
        return a + b;
    }
}
