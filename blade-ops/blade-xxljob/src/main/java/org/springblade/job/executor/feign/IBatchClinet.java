package org.springblade.job.executor.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: wangwei
 * @Date: 2021/3/21 18:37
 * @Description:
 */
@FeignClient(
	value = "blade-chickenpms"
)
public interface IBatchClinet {
	String API_PREFIX = "/client";
	String BATCH_END = API_PREFIX + "/batch-end";

	@PostMapping(BATCH_END)
	public  void  batchEnd();
}
