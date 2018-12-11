package com.sail.main;

import com.sail.config.ProfileConfig;
import com.sail.domain.DemoBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes={DemoConfig.class})
//为什么我用DemoConfig.class也pass 因为我在DemoConfig上的注解为@WiselyConiguration，开启了自动包扫描，读出别的文件中的bean，改成@Configuration就不会出问题了
@ContextConfiguration(classes={ProfileConfig.class})//书上的配置类
@ActiveProfiles("prod")//改为dev时失败
public class DemoBeanIntegrationTests {

    @Autowired
    private DemoBean demoBean;

    @Test
    public void prodBeanShouldInject(){
        String expected = "from production profile";
        String actual = demoBean.getContent();
        Assert.assertEquals(expected, actual);
    }

}
