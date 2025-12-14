package com.zhb.zhbspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * JDBC
 *
 * @author zhb on 2022/4/11
 */
@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/all")
    public List<Map<String, Object>> userList() {
        String sql = "select * from admin";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/findById/{id}")
    public Map<String, Object> Admin(@PathVariable("id") int ids) {
        System.out.println("id--->" + ids);
        String sql = "select * from admin where id = '"+ids+"'";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
        //Map<String, Object> map1 = jdbcTemplate.queryForMap(sql, 1, 2);
        return map;
    }

}
