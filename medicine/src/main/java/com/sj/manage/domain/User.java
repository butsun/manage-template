package com.sj.manage.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户管理对象 user
 * 
 * @author sj
 * @date 2023-04-15
 */
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键id */
    @Excel(name = "自增主键id")
    private Long id;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String name;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 邮箱地址 */
    @Excel(name = "邮箱地址")
    private String mail;

    /** 性别 */
    @Excel(name = "性别")
    private Integer gender;

    /** 用户类型 */
    @Excel(name = "用户类型")
    private Integer type;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer del;

    /** 课程管理信息 */
    private List<Course> courseList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setMail(String mail) 
    {
        this.mail = mail;
    }

    public String getMail() 
    {
        return mail;
    }
    public void setGender(Integer gender) 
    {
        this.gender = gender;
    }

    public Integer getGender() 
    {
        return gender;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setDel(Integer del) 
    {
        this.del = del;
    }

    public Integer getDel() 
    {
        return del;
    }

    public List<Course> getCourseList()
    {
        return courseList;
    }

    public void setCourseList(List<Course> courseList)
    {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("phone", getPhone())
            .append("mail", getMail())
            .append("gender", getGender())
            .append("type", getType())
            .append("del", getDel())
            .append("courseList", getCourseList())
            .toString();
    }
}
