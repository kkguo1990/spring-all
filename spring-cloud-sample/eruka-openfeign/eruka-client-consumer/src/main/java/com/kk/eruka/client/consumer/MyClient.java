package com.kk.eruka.client.consumer;

import com.kk.eruka.common.api.SchedualServiceHi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-hi",path = "/say")
public interface MyClient extends SchedualServiceHi {
}
