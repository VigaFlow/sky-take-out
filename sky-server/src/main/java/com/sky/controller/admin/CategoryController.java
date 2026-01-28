package com.sky.controller.admin;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.*;
import com.sky.entity.Employee;
import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import com.sky.service.EmployeeService;
import com.sky.utils.JwtUtil;
import com.sky.vo.EmployeeLoginVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/admin")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     *
     * @param categoryDTO
     * @return
     */
    @PostMapping("/category")
    @ApiOperation("新增分类")
  public Result save(@RequestBody CategoryDTO categoryDTO) {
        log.info("新增分类：{}", categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * 分类分页查询
     *
     * @param categoryPageQueryDTO
     * @return
     */

    @GetMapping("/category/page")
    @ApiOperation("菜品分类分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("菜品分页查询，参数为：{}", categoryPageQueryDTO);
        PageResult pageResult =categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据id删除分类
     *
     * @param id
     * @return
     */
    @DeleteMapping("/category")
    @ApiOperation("根据id删除分类")
    public Result deleteById(Long id) {
        log.info("根据id删除分类：{}", id);
        categoryService.deleteById(id);
        return Result.success();
    }

    /**
     * 修改分类
     *
     * @param categoryDTO
     * @return
     */
    @PutMapping("/category")
    @ApiOperation("修改分类")
    public Result update(@RequestBody CategoryDTO categoryDTO) {
        log.info("修改分类：{}", categoryDTO);
        categoryService.update(categoryDTO);
        return Result.success();
    }

    /**
     * 启用禁用分类
     *
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/category/status/{status}")
    @ApiOperation("启用禁用分类")
    public Result enableOrDisable(@PathVariable Integer status, Long id) {
        log.info("启用禁用分类：status={}, id={}", status, id);
        categoryService.enableOrDisable(status, id);
        return Result.success();
    }
}
