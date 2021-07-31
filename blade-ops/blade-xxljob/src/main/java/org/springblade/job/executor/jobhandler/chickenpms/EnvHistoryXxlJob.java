package org.springblade.job.executor.jobhandler.chickenpms;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.AllArgsConstructor;
import org.springblade.job.executor.feign.IEnvClient;
import org.springframework.stereotype.Component;

/**
 * @author: wangwei
 * @Date: 2021/3/4 2:01
 * @Description:
 */
@Component
@AllArgsConstructor
public class EnvHistoryXxlJob {

	private IEnvClient envClient;

	/**
	 *  称重记录同步任务
	 * @return
	 * @throws Exception
	 */
	@XxlJob("envHistoryJobHandler")
	public ReturnT<String> envHistoryJobHandler(String param)throws Exception{
		XxlJobLogger.log("环控同步任务执行开始");
		envClient.envHistorySysnc();
		XxlJobLogger.log("环控同步任务执行结束");
		return ReturnT.SUCCESS;
	}
}
