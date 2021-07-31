package org.springblade.job.executor.jobhandler.chickenpms;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.AllArgsConstructor;
import org.springblade.job.executor.feign.IBatchClinet;
import org.springframework.stereotype.Component;

/**
 * @author: wangwei
 * @Date: 2021/3/21 22:20
 * @Description:
 */
@Component
@AllArgsConstructor
public class BatchXxlJob {

	private IBatchClinet batchClinet;

	/**
	 *  称重记录同步任务
	 * @return
	 * @throws Exception
	 */
	@XxlJob("batchEndJobHandler")
	public ReturnT<String> batchEndJobHandler(String param)throws Exception{
		XxlJobLogger.log("批次已完成同步任务执行开始");
		batchClinet.batchEnd();
		XxlJobLogger.log("批次已完成同步任务执行结束");
		return ReturnT.SUCCESS;
	}
}
