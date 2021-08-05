package com.example.loginsys.service.impl;

import com.example.loginsys.mapper.UserMapper;
import com.example.loginsys.pojo.User;
import com.example.loginsys.pojo.result.CommonResult;
import com.example.loginsys.service.UserService;
import com.example.loginsys.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2021-08-01 17:19:46
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
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
    public boolean deleteById(Long id) {
        return this.userMapper.deleteById(id) > 0;
    }

    @Override
    public CommonResult<User> register(User user) {
        List<User> users = userMapper.queryAll(new User(user.getName()));
        if(!users.isEmpty() || users.size() > 0) {
            return CommonResult.failed("该用户名已存在！");
        }
        user.setCreateAt(new Date());
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userMapper.insert(user);
        return CommonResult.success(user);
    }

    @Override
    public CommonResult<User> login(User user) {
        List<User> users = userMapper.queryAll(new User(user.getName()));
        if(users.isEmpty() || users.size() == 0) {
            return CommonResult.failed("账号或者密码错误！");
        }

        if(!passwordEncoder.matches(users.get(0).getPassword(),user.getPassword())){
            return CommonResult.failed("密码不正确");
        }

        //
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);




        return null;
    }
}