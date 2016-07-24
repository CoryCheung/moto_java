package org.ibase4j.bus;

import org.ibase4j.core.support.ftp.SftpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhangqinglin_cory on 2016/7/3.
 */
@ComponentScan
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:Spring-test.xml" })
public class InventoryTest {

    @Test
    public void test() {
    }
}
