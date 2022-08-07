package com.intern.secondproject.service.impl;

import com.intern.secondproject.dao.pojo.Atype;
import com.intern.secondproject.dao.pojo.Btype;
import com.intern.secondproject.dao.pojo.Ctype;
import com.intern.secondproject.dao.pojo.JsonResult;
import com.intern.secondproject.mapper.QueryMapper;
import com.intern.secondproject.mapper.sql.QueryMapperSql;
import com.intern.secondproject.service.QueryService;
import com.intern.secondproject.util.DatabaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@SuppressWarnings("rawtypes")
public class QueryServiceImpl implements QueryService {
    @Autowired
    QueryMapper queryMapper;



    @Override
    public JsonResult delete(String table, String pk) {
        int temp=0;
        if ("A".equals(table)){
             temp= queryMapper.deleteA(pk);
        }
        if("B".equals(table)){
            temp=queryMapper.deleteB(pk);
        }

        return JsonResult.success(HttpStatus.OK.value(), Integer.toString(temp) );
    }


    @Override
    public JsonResult importData(String username, String password, String dbName, String filePath) {
        int temp = 0;
        try {
            DatabaseUtils.restore(username,password,dbName,filePath);
            return JsonResult.success(HttpStatus.OK.value(), Integer.toString(temp));
        }  catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getCause().getMessage());
        }

    }

    @Override
    public JsonResult exportData(String username, String password, String dbName, String tableName, String filePath) {
        int temp = 0;
        try {
            DatabaseUtils.backup(username,password,dbName,tableName,filePath);
            return JsonResult.success(HttpStatus.OK.value(), Integer.toString(temp));
        }  catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getCause().getMessage());
        }

    }

    @Override
    public JsonResult query(String table, String keyWord) {
        Object temp =new Object();
        if("A".equals(table)){
            List<Atype>atype =  queryMapper.queryA(keyWord);
            return JsonResult.success(atype,HttpStatus.OK.getReasonPhrase());
        }
        if ("B".equals(table)){
            List<Btype> btype=queryMapper.queryB(keyWord);
            return JsonResult.success(btype,HttpStatus.OK.getReasonPhrase());
        }

        if("C".equals(table)){
            List<Ctype> ctype=queryMapper.queryC(keyWord);
            return JsonResult.success(ctype,HttpStatus.OK.getReasonPhrase());
        }

        return JsonResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    @Override
    public JsonResult deleteByClick(String keyWord) {
        QueryMapperSql queryMapperSql=new QueryMapperSql();
        System.out.println(queryMapperSql.deleteByClickSql(keyWord));
        int temp = -1;
        temp = queryMapper.deleteByClick(keyWord);
        if (temp >=0) {
            return JsonResult.success(HttpStatus.OK.value(), Integer.toString(temp));
        } else {
            return JsonResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), Integer.toString(temp));
        }
    }

    @Override
    public JsonResult updateA(Atype type) {
        int temp=0;
        temp = queryMapper.updateA(type);
        if (temp == 1) {
            return JsonResult.success(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        } else {
            return JsonResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), Integer.toString(temp));
        }
    }

    @Override
    public JsonResult updateB(Btype type) {
        int temp=0;
        temp = queryMapper.updateB(type);
        if (temp == 1) {
            return JsonResult.success(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        } else {
            return JsonResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), Integer.toString(temp));
        }
    }

    @Override
    public JsonResult insertA(Atype type) {
        int temp=0;
       temp = queryMapper.insertA(type);
        if (temp == 1) {
            return JsonResult.success(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        } else {
            return JsonResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), Integer.toString(temp));
        }
    }

    @Override
    public JsonResult insertB(Btype type) {
        int temp=0;
        temp = queryMapper.insertB(type);
        if (temp == 1) {
            return JsonResult.success(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        } else {
            return JsonResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), Integer.toString(temp));
        }
    }

    @Override
    public JsonResult calculateC(String keyWord) {
        int temp=0;
        temp = queryMapper.calculateC(keyWord);
        if (temp == 1) {
            List<Ctype> ctype= queryMapper.queryC(keyWord);
            return JsonResult.success(ctype, HttpStatus.OK.getReasonPhrase());
        } else {
            return JsonResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), Integer.toString(temp));
        }
    }
}
