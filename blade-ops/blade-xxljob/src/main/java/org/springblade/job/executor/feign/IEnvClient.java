package org.springblade.job.executor.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: wangwei
 * @Date: 2021/3/3 21:18
 * @Description:
 */
@FeignClient(
	value = "blade-chickenpms"
)
public interface IEnvClient {
	String API_PREFIX = "/client";

	String ENV_HISTORY_SYNC=API_PREFIX+"/envhistory/sysnc";

	@GetMapping(ENV_HISTORY_SYNC)
	void  envHistorySysnc();


}
