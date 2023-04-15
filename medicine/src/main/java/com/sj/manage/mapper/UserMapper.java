package com.sj.manage.mapper;

import java.util.List;
import com.sj.manage.domain.User;
import com.sj.manage.domain.Course;

/**
 * 用户管理Mapper接口
 * 
 * @author sj
 * @date 2023-04-15
 */
public interface UserMapper 
{
    /**
     * 查询用户管理
     * 
     * @param id 用户管理主键
     * @return 用户管理
     */
    public User selectUserById(Long id);

    /**
     * 查询用户管理列表
     * 
     * @param user 用户管理
     * @return 用户管理集合
     */
    public List<User> selectUserList(User user);

    /**
     * 新增用户管理
     * 
     * @param user 用户管理
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改用户管理
     * 
     * @param user 用户管理
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 删除用户管理
     * 
     * @param id 用户管理主键
     * @return 结果
     */
    public int deleteUserById(Long id);

    /**
     * 批量删除用户管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserByIds(String[] ids);

    /**
     * 批量删除课程管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCourseByUserIds(String[] ids);
    
    /**
     * 批量新增课程管理
     * 
     * @param courseList 课程管理列表
     * @return 结果
     */
    public int batchCourse(List<Course> courseList);
    

    /**
     * 通过用户管理主键删除课程管理信息
     * 
     * @param id 用户管理ID
     * @return 结果
     */
    public int deleteCourseByUserId(Long id);
}
