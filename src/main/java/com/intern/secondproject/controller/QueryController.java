package com.intern.secondproject.controller;

import com.intern.secondproject.dao.pojo.Atype;
import com.intern.secondproject.dao.pojo.Btype;
import com.intern.secondproject.dao.pojo.JsonResult;
import com.intern.secondproject.service.QueryService;
import com.intern.secondproject.util.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@SuppressWarnings({"unchecked", "rawtypes"})
public class QueryController {
    @Autowired
    QueryService queryService;

    LogUtils logUtils = LogUtils.getInstance();

    @PostMapping("/insertA")
    public  JsonResult insertA(@RequestBody Atype type) {
        log.info("insertA << ( Atype: " + logUtils.printObjectAsLog(type) +")");
        JsonResult result = queryService.insertA(type);
        log.info("insertA >> (" + logUtils.printObjectAsLog(result) + ")");
        return result;
    }

    @PostMapping("/insertB")
    public  JsonResult insertB(@RequestBody Btype type) {
        log.info("insertB << ( Btype: " + logUtils.printObjectAsLog(type) + ")");
        JsonResult result = queryService.insertB(type);
        log.info("insertB >> (" + logUtils.printObjectAsLog(result) + ")");
        return result;
    }

    @PostMapping("/updateA")
    public <T> JsonResult updateA(@RequestBody Atype type) {
        log.info("update << ( Atype: " + logUtils.printObjectAsLog(type) +  ")");
        JsonResult result = queryService.updateA(type);
        log.info("update >> (" + logUtils.printObjectAsLog(result) + ")");
        return result;
    }

    @PostMapping("/updateB")
    public <T> JsonResult updateB(@RequestBody Btype type) {
        log.info("update << ( Btype: " + logUtils.printObjectAsLog(type) +")");
        JsonResult result = queryService.updateB(type);
        log.info("update >> (" + logUtils.printObjectAsLog(result) + ")");
        return result;
    }

    @PostMapping("/delete")
    public JsonResult delete(String table, String pk) {
        log.info("delete << ( String: "+table+", String: " + pk + ")");
        JsonResult result = queryService.delete(table,pk);
        log.info("delete >> (" + logUtils.printObjectAsLog(result) + ")");
        return result;
    }

    @PostMapping("/import")
    public JsonResult importSQL(String username,String password, String dbName, String filePath) {
        log.info("importSQL << (String: " + username +",String: "+dbName + ", String: " + filePath + ")");
        JsonResult result = queryService.importData(username,password,dbName , filePath);
        log.info("importSQL >> (" + logUtils.printObjectAsLog(result) + ")");
        return result;
    }

    @PostMapping("/export")
    public JsonResult exportSQL(String username,String password,String dbName, String tableName, String filePath) {
        log.info("exportSQL << (String: " + username +",String: "+dbName +",String: "+ tableName + ", String: " + filePath + ")");
        JsonResult result = queryService.exportData(username,password,dbName,tableName, filePath);
        log.info("exportSQL >> (" + logUtils.printObjectAsLog(result) + ")");
        return result;
    }

    @PostMapping("/query")
    public JsonResult query(String table, String keyWord) {
        log.info("query << (String: " + table + ", String: " + keyWord + ")");
        JsonResult result = queryService.query(table, keyWord);
        log.info("query >> (" + logUtils.printObjectAsLog(result) + ")");
        return result;
    }

    @GetMapping("/deleteByClick")
    public JsonResult deleteByClick(String keyWord) {
        log.info("deleteB << (String: "+keyWord +")");
        JsonResult result = queryService.deleteByClick(keyWord);
        log.info("deleteB >> (" + logUtils.printObjectAsLog(result) + ")");
        return result;
    }

    @PostMapping("/calculateC")
    public JsonResult calculateC(String keyWord) {
        log.info("calculateC << (String: "+keyWord+")");
        JsonResult result = queryService.calculateC(keyWord);
        log.info("calculateC >> (" + logUtils.printObjectAsLog(result) + ")");
        return result;
    }





}
