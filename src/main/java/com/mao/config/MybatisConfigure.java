package com.mao.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author mao by 14:31 2019/11/22
 */
public class MybatisConfigure {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("config/mybatis_config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }

}