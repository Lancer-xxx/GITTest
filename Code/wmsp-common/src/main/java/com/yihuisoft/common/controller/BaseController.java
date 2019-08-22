package com.yihuisoft.common.controller;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.service.CommonService;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dim
 * @Title: BaseController
 * @ProjectName yihuisoft-common
 * @Description: 用于处理公共的controller
 * @version V4.0.0
 * @date 2019/6/20
 */
@RequestMapping("/wmsp")
@RestController
@Validated
public abstract class BaseController<T> {

    @Autowired
    CommonService<T> service;

    /**
     * 查询分页
     * @param pagerVO
     * @return
     */
    @PostMapping(value = "list")
    public OutDTO list(@RequestBody PagerVO<T> pagerVO){
        return service.list(pagerVO);
    }

    /**
     * 查询单条记录
     * @param inVO
     * @return
     */
    @PostMapping(value = "get")
    public OutDTO get( @RequestBody InVO<T> inVO){
        return service.get(inVO.getData());
    }

    /**
     * 查找多条记录
     * @param inVO
     * @return
     */
    @PostMapping(value = "list_all")
    public OutDTO list(@RequestBody InVO<T> inVO){
        return service.listAll(inVO.getData());
    }

    /**
     * 新增
     * @param inVO
     * //@param validators
     * @return
     */
    @PostMapping("save")
    public OutDTO save(@RequestBody InVO<T> inVO){
        return service.save(inVO.getData());
    }

    /**
     * 更新
     * @param inVO
     * //@param validators
     * @return
     */
    @PostMapping("update")
    public OutDTO update(@RequestBody InVO<T> inVO){ return service.updateById(inVO.getData()); }


    /**
     * 删除
     * @param inVO
     * @return
     */
    @PostMapping("delete")
    public OutDTO delete(@RequestBody InVO<T> inVO){
        return service.deleteById(inVO.getData());
    }

}
