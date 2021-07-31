package org.springblade.job.executor.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: wangwei
 * @Date: 2021/2/27 1:09
 * @Description:
 */
@FeignClient(
	value = "blade-chickenpms"
)
public interface IRecodeTaskClient {
	String API_PREFIX = "/client";
	String RECORD_PREFIX = API_PREFIX+"/record";

	String WEIGHT_PREFIX = RECORD_PREFIX+"/weight";

	String VACCINE_PREFIX = RECORD_PREFIX+"/vaccine";

	String FEED__PREFIX = RECORD_PREFIX+"/feed";


	@PostMapping(WEIGHT_PREFIX)
	void updateWeightPush();
	@PostMapping(VACCINE_PREFIX)
	void updateVaccinePush();
	@PostMapping(FEED__PREFIX)
	void  updateFeedPush();

}
