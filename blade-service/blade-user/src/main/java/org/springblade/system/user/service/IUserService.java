/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package org.springblade.system.user.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.core.mp.base.BaseService;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.tool.api.R;
import org.springblade.system.entity.Role;
import org.springblade.system.user.entity.User;
import org.springblade.system.user.entity.UserInfo;
import org.springblade.system.user.entity.UserOauth;
import org.springblade.system.user.enums.UserEnum;
import org.springblade.system.user.excel.UserExcel;
import org.springblade.system.user.vo.UserVO;
import org.springblade.core.mp.support.Query;

import java.util.List;
import java.util.Map;

/**
 * 服务类
 *
 * @author Chill
 */
public interface IUserService extends BaseService<User> {

	/**
	 * 新增用户
	 *
	 * @param user
	 * @return
	 */
	boolean submit(User user);

	/**
	 * 修改用户
	 *
	 * @param user
	 * @return
	 */
	boolean updateUser(User user);

	/**
	 * 修改用户基本信息
	 *
	 * @param user
	 * @return
	 */
	boolean updateUserInfo(User user);

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param user
	 * @param deptId
	 * @param tenantId
	 * @return
	 */
	IPage<User> selectUserPage(IPage<User> page, User user, Long deptId, String tenantId);

	/**
	 * 用户信息
	 *
	 * @param userId
	 * @return
	 */
	UserInfo userInfo(Long userId);

	/**
	 * 用户信息
	 *
	 * @param tenantId
	 * @param account
	 * @return
	 */
	UserInfo userInfo(String tenantId, String account);

	/**
	 * 用户信息
	 *
	 * @param tenantId
	 * @param account
	 * @param userEnum
	 * @return
	 */
	UserInfo userInfo(String tenantId, String account, UserEnum userEnum);

	/**
	 * 用户信息
	 *
	 * @param userOauth
	 * @return
	 */
	UserInfo userInfo(UserOauth userOauth);

	/**
	 * 根据账号获取用户
	 *
	 * @param tenantId
	 * @param account
	 * @return
	 */
	User userByAccount(String tenantId, String account);

	/**
	 * 给用户设置角色
	 *
	 * @param userIds
	 * @param roleIds
	 * @return
	 */
	boolean grant(String userIds, String roleIds);

	/**
	 * 初始化密码
	 *
	 * @param userIds
	 * @return
	 */
	boolean resetPassword(String userIds);

	/**
	 * 修改密码
	 *
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @param newPassword1
	 * @return
	 */
	boolean updatePassword(Long userId, String oldPassword, String newPassword, String newPassword1);

	/**
	 * 删除用户
	 *
	 * @param userIds
	 * @return
	 */
	boolean removeUser(String userIds);

	boolean updateAvatar(String avatar);

	/**
	 * 导入用户数据
	 *
	 * @param data
	 * @param isCovered
	 * @return
	 */
	void importUser(List<UserExcel> data, Boolean isCovered);

	/**
	 * 导出用户数据
	 *
	 * @param queryWrapper
	 * @return
	 */
	List<UserExcel> exportUser(Wrapper<User> queryWrapper);

	/**
	 * 注册用户
	 *
	 * @param user
	 * @param oauthId
	 * @return
	 */
	boolean registerGuest(User user, Long oauthId);

	/**
	 * 配置用户平台
	 *
	 * @param userId
	 * @param userType
	 * @param userExt
	 * @return
	 */
	boolean updatePlatform(Long userId, Integer userType, String userExt);

	/**
	 * 用户详细信息
	 *
	 * @param user
	 * @return
	 */
	UserVO platformDetail(User user);

	/**
	 * 权限获取用户
	 * @param role
	 * @return
	 */
	List<User> selectUserList(Role role);

	/**
	 * 角色获取用户分页
	 * @param user
	 *
	 * @param query
	 * @return
	 */
	R<IPage<User>> getUserPages(User user, Query query);
}
