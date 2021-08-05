package com.example.multiservicetransaction.service;

import com.example.multiservicetransaction.pojo.Role;
import com.example.multiservicetransaction.pojo.User;
import java.util.List;
import java.util.Map;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2021-08-04 22:01:59
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    /**
     * 插入自己service数据时，调用其它service插入其它实体数据
     * @param user
     * @param role
     * @return
     */
    Map<String, Object> addUserAndRole(User user, Role role);

    /**
     * 插入自己mapper数据时，调用其它mapper插入其它实体数据
     * @param user
     * @param role
     * @return
     */
    Map<String, Object> addUserAndRoleByMapper(User user, Role role);

}