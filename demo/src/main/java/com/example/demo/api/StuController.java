package com.example.demo.api;

import com.example.demo.dao.StuDao;
import com.example.demo.dto.QueryStuCondition;
import com.example.demo.dto.StuCommand;
import com.example.demo.entity.Stu;
import com.example.demo.service.StuService;
import com.example.demo.utils.PageParam;
import com.example.demo.utils.PageRequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/stu")
@Api(tags = "学生Api")
public class StuController {

    @Resource
    private StuService stuService;

    @Resource
    private StuDao stuDao;

    @GetMapping("pages")
    @ApiOperation(value = "分页查询")
    public Page<Stu> page(PageParam pageParam, QueryStuCondition condition) {
        PageRequest pageable = PageRequestUtil.getRequest(pageParam);
        return stuService.page(pageable,condition);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "详情查询")
    public Stu get(@PathVariable Long id){
        return stuDao.findById(id).orElseThrow();
    }

    @PostMapping("create")
    @ApiOperation(value = "创建")
    public ResponseEntity create(@RequestBody StuCommand command){
        Stu stu = new Stu();
        stu.setName(command.getName());
        stu.setKey(command.getKey());
        stuDao.save(stu);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新")
    public ResponseEntity update(@PathVariable Long id, @RequestBody StuCommand command) {
        Stu stu = new Stu();
        stu.setId(id);
        stu.setName(command.getName());
        stu.setKey(command.getKey());
        stuDao.save(stu);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public ResponseEntity delete(@PathVariable Long id) {
        stuDao.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
