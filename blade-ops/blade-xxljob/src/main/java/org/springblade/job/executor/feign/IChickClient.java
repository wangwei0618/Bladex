package org.springblade.job.executor.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: wangwei
 * @Date: 2021/1/16 21:43
 * @Description:
 */
@FeignClient(
	value = "blade-chickenpms"
//	fallback = ISysClientFallback.class
)
public interface IChickClient {
	String API_PREFIX = "/client";
	String SUPPLY= API_PREFIX + "/supply";
	String SUPPLY_SYNC_TSAT=SUPPLY+"/sync-tsat";
	String SUPPLY_PAST = SUPPLY_SYNC_TSAT+"/past";
	String SUPPLY_CANCEL = SUPPLY_SYNC_TSAT+"/cancel";
	String OBSOLETE = API_PREFIX+"/obsolete";
	String OBSOLETE_SYNC_TAST=OBSOLETE+"/sync-tsat";
	String OBSOLETE_PAST = OBSOLETE_SYNC_TAST+"/past";
	String OBSOLETE_CANCEL = OBSOLETE_SYNC_TAST+"cancel";

	String FARMER_INFO_BY_TYPE = API_PREFIX + "/farmer-info-by-type";

	/**
	 * 饲料申报通过
	 */
	@GetMapping(SUPPLY_PAST)
    void  supplyPastSyncTast ();

	/**
	 * 饲料申报取消
	 */
	@GetMapping(SUPPLY_CANCEL)
	void supplyCancelSyncTast();

	/**
	 * 死淘通过
	 */
	@GetMapping(OBSOLETE_PAST)
    void obsoletePastSyncTast();

	/**
	 * 死淘取消
	 */
    @GetMapping(OBSOLETE_CANCEL)
	void obsoleteCancelSyncTast();

}
