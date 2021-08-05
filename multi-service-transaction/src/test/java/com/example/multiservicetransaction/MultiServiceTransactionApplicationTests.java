package com.example.multiservicetransaction;

import com.example.multiservicetransaction.pojo.Role;
import com.example.multiservicetransaction.pojo.User;
import com.example.multiservicetransaction.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 结论：
 *      就是在方法里加上@Transactional注解，方法里调用其它mapper或者service（无论自己有没有@Transactional注解）
 *      去插入多个表数据，只要出错，全部回滚
 */
@SpringBootTest
class MultiServiceTransactionApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setName("gary");
        user.setPassword("111111");
        Role role = new Role();
//        userService.addUserAndRole(user, role);
        userService.addUserAndRoleByMapper(user, role);
    }

}
