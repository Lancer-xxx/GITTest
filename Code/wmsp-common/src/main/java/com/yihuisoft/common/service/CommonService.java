package com.yihuisoft.common.service;

import com.yihuisoft.common.dto.InDTO;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.InVO;
import com.yihuisoft.common.vo.PagerVO;
import org.springframework.stereotype.Service;

public interface CommonService<T> {

    /**
     * 按id查询 对象
     * @param id
     */
    public OutDTO<T> getById(Integer id);


    /**
     * 按查询条件查询分页
     * @param inVO
     */
    public OutDTO<T> list(PagerVO<T> inVO);


    /**
     * 按id 更新对象
     * @param t
     */
    public OutDTO<T> updateById(T t);


    /**
     * 按id删除对象
     * @param t
     */
    public OutDTO<T> deleteById(T t);


    /**
     * 查找实体对象
     * @param t
     */
    public OutDTO<T> get(T t);

    /**
     * 创建实体对象
     * @param t
     */
    public OutDTO<T> save(T t);

    /**
     * 查询所有的对象
     * @param t
     */
    public OutDTO listAll(T t);
}
