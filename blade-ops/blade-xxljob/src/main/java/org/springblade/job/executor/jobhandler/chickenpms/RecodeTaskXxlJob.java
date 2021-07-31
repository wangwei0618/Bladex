package org.springblade.job.executor.jobhandler.chickenpms;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.AllArgsConstructor;
import org.springblade.job.executor.feign.IRecodeTaskClient;
import org.springframework.stereotype.Component;

/**
 * @author: wangwei
 * @Date: 2021/2/27 12:08
 * @Description:
 */
@Component
@AllArgsConstructor
public class RecodeTaskXxlJob {
	private IRecodeTaskClient recodeTaskClient;


	/**
	 *  称重记录同步任务
	 * @return
	 * @throws Exception
	 */
	@XxlJob("weightJobHandler")
	public ReturnT<String> weightJobHandler(String param)throws Exception{
		XxlJobLogger.log("称重记录同步任务执行开始");
		recodeTaskClient.updateWeightPush();
		XxlJobLogger.log("称重记录同步任务执行结束");
		return ReturnT.SUCCESS;
	}

	/**
	 *  免疫记录同步任务
	 * @return
	 * @throws Exception
	 */
	@XxlJob("vaccineJobHandler")
	public ReturnT<String> vaccineJobHandler(String param)throws Exception{
		XxlJobLogger.log("免疫记录同步任务执行开始");
		recodeTaskClient.updateVaccinePush();
		XxlJobLogger.log("免疫记录同步任务执行结束");
		return ReturnT.SUCCESS;
	}

	/**
	 *  饲喂记录同步
	 * @return
	 * @throws Exception
	 */
	@XxlJob("feedJobHandler")
	public ReturnT<String> feedJobHandler(String param)throws Exception{
		XxlJobLogger.log("饲喂记录同步任务执行开始");
		recodeTaskClient.updateFeedPush();
		XxlJobLogger.log("饲喂记录同步任务执行结束");
		return ReturnT.SUCCESS;
	}
}
