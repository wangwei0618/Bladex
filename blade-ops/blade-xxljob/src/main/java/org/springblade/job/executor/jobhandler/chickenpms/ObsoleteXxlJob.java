package org.springblade.job.executor.jobhandler.chickenpms;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springblade.job.executor.feign.IChickClient;

import org.springframework.stereotype.Component;

/**
 * @author: wangwei
 * @Date: 2021/1/19 5:23
 * @Description:
 */
@Component
@AllArgsConstructor
public class ObsoleteXxlJob {
	private static final Logger logger = LoggerFactory.getLogger(ObsoleteXxlJob.class);

	private IChickClient chickClient;

	/**
	 *  死淘通过任务执
	 * @return
	 * @throws Exception
	 */
	@XxlJob("obsoletePastJobHandler")
	public ReturnT<String> obsoletePastJobHandler(String param)throws Exception{
		XxlJobLogger.log("死淘申报通过任务执行开始");
		chickClient.obsoletePastSyncTast();
		XxlJobLogger.log("死淘申报通过任务执行结束");
		return ReturnT.SUCCESS;
	}

	/**
	 *  死淘取消任务执
	 * @return
	 * @throws Exception
	 */
	@XxlJob("obsoleteCancelJobHandler")
	public ReturnT<String> obsoleteCancelJobHandler(String param)throws Exception{
		XxlJobLogger.log("死淘申报取消任务执行开始");
		chickClient.obsoleteCancelSyncTast();
		XxlJobLogger.log("死淘申报取消任务执行结束");
		return ReturnT.SUCCESS;
	}
}
