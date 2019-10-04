package com.xuyang.springboot.admin.controller;

import com.xuyang.springboot.admin.model.Files;
import com.xuyang.springboot.admin.service.FilesService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Data
@RestController
public class FilesController {

    @Autowired
    private FilesService filesService;

    @RequestMapping(value = "insertFiles", method = RequestMethod.POST)
    public String insertFiles(@RequestBody Files files) throws Exception{
        filesService.insertFiles(files);
        return "新增成功";
    }

    @RequestMapping(value = "updateFiles", method = RequestMethod.POST)
    public String updateFiles(@RequestBody Files files) throws Exception{
        filesService.updateFiles(files);
        return "修改成功";
    }

    @RequestMapping(value = "deleteFiles", method = RequestMethod.POST)
    public String deleteFiles(@RequestBody Files files) throws Exception{
        filesService.deleteFiles(files);
        return "删除成功";
    }

    @RequestMapping(value = "getFilesList", method = RequestMethod.POST)
    public List<Files> getFilesList(@RequestBody Files files) throws Exception {
        List<Files> filesList = filesService.filesList(files);
        return filesList;
    }

    @RequestMapping(value = "getFilesPageList", method = RequestMethod.POST)
    public List<Files> getFilesPageList(@RequestBody Files files) throws Exception {
        String pageIndex = files.getPageIndex();
        String pageSize = files.getPageSize();
        List<Files> filesList = filesService.filesList(files, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
        return filesList;
    }
}
