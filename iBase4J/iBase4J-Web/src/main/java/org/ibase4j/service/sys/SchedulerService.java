package org.ibase4j.service.sys;

import java.util.Map;

import org.ibase4j.core.support.Assert;
import org.ibase4j.model.generator.TaskFireLog;
import org.ibase4j.model.generator.TaskGroup;
import org.ibase4j.model.generator.TaskScheduler;
import org.ibase4j.model.scheduler.TaskScheduled;
import org.ibase4j.model.scheduler.TaskSchedulerBean;
import org.ibase4j.provider.scheduler.SchedulerProvider;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:16:20
 */
@Service
public class SchedulerService {
	@Reference // 依赖调度服务
	private SchedulerProvider schedulerProvider;

	public PageInfo<TaskScheduled> getAllJobDetail() {
		PageInfo<TaskScheduled> pageInfo = new PageInfo<TaskScheduled>();
		pageInfo.setList(schedulerProvider.getAllTaskDetail());
		pageInfo.setPages(1);
		pageInfo.setSize(pageInfo.getList().size());
		return pageInfo;
	}

	public boolean execTask(String taskGroup, String taskName) {
		Assert.notNull(taskGroup, "TASKGROUP");
		Assert.notNull(taskName, "TASKNAME");
		return schedulerProvider.execTask(taskGroup, taskName);
	}

	public boolean openTask(String taskGroup, String taskName) {
		Assert.notNull(taskGroup, "TASKGROUP");
		Assert.notNull(taskName, "TASKNAME");
		return schedulerProvider.openCloseTask(taskGroup, taskName, "start");
	}

	public boolean closeTask(String taskGroup, String taskName) {
		Assert.notNull(taskGroup, "TASKGROUP");
		Assert.notNull(taskName, "TASKNAME");
		return schedulerProvider.openCloseTask(taskGroup, taskName, "stop");
	}

	public PageInfo<TaskGroup> queryGroup(Map<String, Object> params) {
		return schedulerProvider.queryGroup(params);
	}

	public PageInfo<TaskSchedulerBean> queryScheduler(Map<String, Object> params) {
		return schedulerProvider.queryScheduler(params);
	}

	public PageInfo<TaskFireLog> queryLog(Map<String, Object> params) {
		return schedulerProvider.queryLog(params);
	}

	/**
	 * @param id
	 * @return
	 */
	public TaskGroup queryGroupById(Integer id) {
		Assert.notNull(id, "ID");
		return schedulerProvider.getGroupById(id);
	}

	/**
	 * @param record
	 */
	public void addGroup(TaskGroup record) {
		schedulerProvider.updateGroup(record);
	}

	/**
	 * @param record
	 */
	public void updateGroup(TaskGroup record) {
		Assert.notNull(record.getId(), "ID");
		schedulerProvider.updateGroup(record);
	}

	/**
	 * @param id
	 * @return
	 */
	public TaskScheduler querySchedulerById(Integer id) {
		Assert.notNull(id, "ID");
		return schedulerProvider.getSchedulerById(id);
	}

	/**
	 * @param record
	 */
	public void addScheduler(TaskScheduler record) {
		schedulerProvider.updateScheduler(record);
	}

	/**
	 * @param record
	 */
	public void updateScheduler(TaskScheduler record) {
		Assert.notNull(record.getId(), "ID");
		schedulerProvider.updateScheduler(record);
	}
}
