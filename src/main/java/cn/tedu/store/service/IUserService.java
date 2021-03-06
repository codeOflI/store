package cn.tedu.store.service;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserConflictException;
import cn.tedu.store.service.ex.UserNotFoundException;

/**
 * 用户数据的业务层接口
 */
public interface IUserService {

	/**
	 * 用户注册
	 * @param user 用户数据
	 * @throws UserConflictException 用户名冲突的异常
	 * @throws InsertException 插入数据失败的异常
	 */
	void reg(User user) 
			throws UserConflictException, InsertException;
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 包括了主要信息的用户对象，有：用户id，用户名
	 * @throws UserNotFoundException 用户名不存在，或用户数据已经被标记为删除时，出现此异常
	 * @throws PasswordNotMatchException 验证密码失败时出现此异常
	 */
	User login(String username, String password)
			throws UserNotFoundException, PasswordNotMatchException;
	
	/**
	 * 修改密码
	 * @param uid 用户id
	 * @param oldPassword 原密码
	 * @param newPassword 新密码
	 * @throws UserNotFoundException 用户数据不存在
	 * @throws PasswordNotMatchException 原密码错误
	 * @throws UpdateException 更新数据异常
	 */
	void changePassword(
			Integer uid, String oldPassword, String newPassword) 
				throws UserNotFoundException, 
					PasswordNotMatchException, 
					UpdateException;
	
	/**
	 * 修改用户资料
	 * @param user 用户数据，至于封装用户的id
	 * @throws UpdateException 更新数据异常
	 * @throws UserNotFoundException 用户数据不存在
	 */
	void changeInfo(User user) 
			throws UpdateException, 
				UserNotFoundException;
	
	/**
	 * 修改用户的头像
	 * @param uid 用户的id
	 * @param avatar 头像的路径
	 * @throws UserNotFoundException 用户数据不存在
	 * @throws UpdateException 更新数据异常
	 */
	void changeAvatar(Integer uid, String avatar) 
			throws UserNotFoundException, UpdateException;
	
	/**
	 * 根据用户的id获取用户数据
	 * @param uid 用户的id
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	User getByUid(Integer uid);
	
}






