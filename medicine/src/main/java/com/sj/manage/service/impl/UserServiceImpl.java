package com.sj.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.sj.manage.domain.Course;
import com.sj.manage.mapper.UserMapper;
import com.sj.manage.domain.User;
import com.sj.manage.service.IUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户管理Service业务层处理
 * 
 * @author sj
 * @date 2023-04-15
 */
@Service
public class UserServiceImpl implements IUserService 
{
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户管理
     * 
     * @param id 用户管理主键
     * @return 用户管理
     */
    @Override
    public User selectUserById(Long id)
    {
        return userMapper.selectUserById(id);
    }

    /**
     * 查询用户管理列表
     * 
     * @param user 用户管理
     * @return 用户管理
     */
    @Override
    public List<User> selectUserList(User user)
    {
        return userMapper.selectUserList(user);
    }

    /**
     * 新增用户管理
     * 
     * @param user 用户管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertUser(User user)
    {
        int rows = userMapper.insertUser(user);
        insertCourse(user);
        return rows;
    }

    /**
     * 修改用户管理
     * 
     * @param user 用户管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateUser(User user)
    {
        userMapper.deleteCourseByUserId(user.getId());
        insertCourse(user);
        return userMapper.updateUser(user);
    }

    /**
     * 批量删除用户管理
     * 
     * @param ids 需要删除的用户管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteUserByIds(String ids)
    {
        userMapper.deleteCourseByUserIds(Convert.toStrArray(ids));
        return userMapper.deleteUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户管理信息
     * 
     * @param id 用户管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteUserById(Long id)
    {
        userMapper.deleteCourseByUserId(id);
        return userMapper.deleteUserById(id);
    }

    /**
     * 新增课程管理信息
     * 
     * @param user 用户管理对象
     */
    public void insertCourse(User user)
    {
        List<Course> courseList = user.getCourseList();
        Long id = user.getId();
        if (StringUtils.isNotNull(courseList))
        {
            List<Course> list = new ArrayList<Course>();
            for (Course course : courseList)
            {
                course.setUserId(id);
                list.add(course);
            }
            if (list.size() > 0)
            {
                userMapper.batchCourse(list);
            }
        }
    }
}
