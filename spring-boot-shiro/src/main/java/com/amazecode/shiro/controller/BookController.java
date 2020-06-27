package com.amazecode.shiro.controller;

import com.alibaba.fastjson.JSONObject;
import com.amazecode.shiro.service.BookService;
import com.amazecode.shiro.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 *  @Description: 书籍控制类
 *  @author: zhangyadong
 *  @Date: 2020/6/27 16:40
 *  @version: V1.0
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 查询书籍列表
     */
    @RequiresPermissions("book:list")
    @GetMapping("/listBook")
    public JSONObject listArticle(HttpServletRequest request) {
        return bookService.listBook(CommonUtil.request2Json(request));
    }

    /**
     * 添加书籍
     */
    @RequiresPermissions("book:add")
    @PostMapping("/addBook")
    public JSONObject addBook(@RequestBody JSONObject requestJson){
        requestJson.put("createTime",new Date());
        CommonUtil.hasAllRequired(requestJson, "bookName,bookCode,status,createUser,createTime");
        return bookService.addBook(requestJson);
    }

    /**
     * 修改书籍
     */
    @RequiresPermissions("article:update")
    @PostMapping("/updateBook")
    public JSONObject updateArticle(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id,status");
        return bookService.updateBook(requestJson);
    }
}
