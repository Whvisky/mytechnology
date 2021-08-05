package com.example.multiservicetransaction.service.impl;

import com.example.multiservicetransaction.mapper.RoleMapper;
import com.example.multiservicetransaction.pojo.Role;
import com.example.multiservicetransaction.pojo.User;
import com.example.multiservicetransaction.mapper.UserMapper;
import com.example.multiservicetransaction.service.RoleService;
import com.example.multiservicetransaction.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2021-08-04 22:02:01
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleService roleService;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userMapper.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userMapper.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userMapper.deleteById(id) > 0;
    }


    @Transactional
    @Override
    public Map<String, Object> addUserAndRole(User user, Role role) {
        Map<String, Object> map = new HashMap<>();
        user = this.insert(user);
        role = roleService.insert(role);
        map.put("user", user);
        map.put("role", role);
        return map;
    }

    @Override
    public Map<String, Object> addUserAndRoleByMapper(User user, Role role) {
        Map<String, Object> map = new HashMap<>();
        userMapper.insert(user);
        roleService.insert(role);
//        roleMapper.insert(role);
        map.put("user", user);
        map.put("role", role);
        return map;
    }
}