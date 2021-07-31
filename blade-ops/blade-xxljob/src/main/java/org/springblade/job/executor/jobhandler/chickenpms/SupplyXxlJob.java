package org.springblade.job.executor.jobhandler.chickenpms;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springblade.job.executor.feign.IChickClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author: wangwei
 * @Date: 2021/1/19 5:22
 * @Description:
 */
@Component
@AllArgsConstructor
public class SupplyXxlJob {
	private static final Logger logger = LoggerFactory.getLogger(SupplyXxlJob.class);

	private IChickClient chickClient;
	/**
	 * 饲料申报通过任务
	 */
	@XxlJob("supplyPastJobHandler")
	public ReturnT<String> supplyPastJobHandler(String param) throws Exception {
		XxlJobLogger.log("饲料申报通过任务执行开始");
		chickClient.supplyPastSyncTast();
		XxlJobLogger.log("饲料申报通过任务执行结束");

		return ReturnT.SUCCESS;
	}

	/**
	 *  饲料取消过任务执
	 * @return
	 * @throws Exception
	 */
	@XxlJob("supplyCancelJobHandler")
	public ReturnT<String> supplyCancelJobHandler(String param)throws Exception{
		XxlJobLogger.log("饲料取消任务执行开始");
		chickClient.supplyCancelSyncTast();
		XxlJobLogger.log("饲料取消任务执行结束");
		return ReturnT.SUCCESS;
	}

}
