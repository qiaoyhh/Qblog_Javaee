package com.qyh.myblog_javaee;

import com.qyh.myblog_javaee.model.BaseBean;
import com.qyh.myblog_javaee.model.BlogBean;
import com.qyh.myblog_javaee.service.BlogService;
import com.qyh.myblog_javaee.service.UserService;
import com.qyh.myblog_javaee.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyblogJavaeeApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    private String phone = "18810159097";
    private String password = "123456";
    private String userName = "qyh";
    private String userId = "8aa75bda-a799-493f-a34f-0252a6cfeb33";

    @Test
    public void getphoneIsRegist() {
        boolean phoneIsRegist = userService.getPhoneIsRegist(phone);
        System.out.println(phoneIsRegist);
    }

    @Test
    public void regist() {
        BaseBean baseBean = userService.addUserInfo(phone, password, userName);
        System.out.println("regist=" + baseBean.toString());
    }

    @Test
    public void login() {
        BaseBean baseBean = userService.login(phone, password);
        System.out.println("login=" + baseBean.toString());
    }

    @Test
    public void getBlogListById() {
        List<BlogBean> blogList = blogService.getBlogListById(userId);

        System.out.println("blogList===" + blogList.toString());

    }

    @Test
    public void getBlogListByType() {
        List<BlogBean> blogList = blogService.getBlogListByType(1, 1, 10);
        System.out.println("blogList===" + blogList.size());
    }

}
