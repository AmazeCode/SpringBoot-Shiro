package com.amazecode.shiro.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description: 书籍SerVice
 * @author: zhangyadong
 * @Date: 2020/6/27 16:58
 * @version: V1.0
 */
public interface BookService {

    /**
     * 新增书籍
     */
    JSONObject addBook(JSONObject jsonObject);

    /**
     * 书籍列表
     */
    JSONObject listBook(JSONObject jsonObject);

    /**
     * 修改书籍
     */
    JSONObject updateBook(JSONObject jsonObject);
}
