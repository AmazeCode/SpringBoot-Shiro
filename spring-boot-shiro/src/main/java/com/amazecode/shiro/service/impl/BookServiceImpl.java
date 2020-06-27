package com.amazecode.shiro.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amazecode.shiro.dao.BookDao;
import com.amazecode.shiro.service.BookService;
import com.amazecode.shiro.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  @Description: 书籍Service实现
 *  @author: zhangyadong
 *  @Date: 2020/6/27 17:00
 *  @version: V1.0
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addBook(JSONObject jsonObject) {
        bookDao.addBook(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject listBook(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = bookDao.countBook(jsonObject);
        List<JSONObject> list = bookDao.listBook(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateBook(JSONObject jsonObject) {
        bookDao.updateBook(jsonObject);
        return CommonUtil.successJson();
    }
}
