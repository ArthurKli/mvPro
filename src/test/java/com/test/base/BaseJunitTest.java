package com.test.base;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by Kai Li on 14-1-5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-content.xml"})
public class BaseJunitTest extends AbstractTransactionalJUnit4SpringContextTests {


    @Before
    public void before(){
        System.out.println("Begin Test");
    }

    @Override
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        // TODO Auto-generated method stub
        super.setDataSource(dataSource);
    }


}
