package com.amazecode.shiro.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 书籍Dao
 * @author: zhangyadong
 * @Date: 2020/6/27 16:47
 * @version: V1.0
 */
@Repository
public interface BookDao {

    /**
     * 书籍列表
     */
    List<JSONObject> listBook(JSONObject jsonObject);

    /**
     * 新增书籍
     */
    int addBook(JSONObject jsonObject);

    /**
     * 统计书籍总数
     */
    int countBook(JSONObject jsonObject);

    /**
     * 删除书籍
     */
    int updateBook(JSONObject jsonObject);
}
