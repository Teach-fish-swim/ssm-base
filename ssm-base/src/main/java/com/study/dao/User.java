package com.study.dao;


import com.study.service.UserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface User {
        public UserBean getUserBean(@Param("id") Integer id);
        public List<UserBean> getAllUser();
        public UserBean getUserBeanWhere(@Param("id") Integer id, @Param("name") String name);
        public void insertOne(@Param("name") String name, @Param("age") int age);
}
