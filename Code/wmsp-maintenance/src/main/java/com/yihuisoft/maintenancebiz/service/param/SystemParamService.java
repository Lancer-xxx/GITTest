package com.yihuisoft.maintenancebiz.service.param;

import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.maintenancebiz.entity.param.SystemParam;

/**
 * @author wangxin
 * @version V4.0.0
 * @Description:
 * @Title:
 * @ProjectName yihuisoft-authority
 * @date 2019/7/8
 */
public interface SystemParamService{

    /**
     * 按查询条件查询分页
     * @param inVO
     * @return
     */
    public OutDTO<SystemParam> list(PagerVO<SystemParam> inVO);


    /**
     * 按id 更新对象
     * @param systemParam
     * @return
     */
    public OutDTO<SystemParam> updateById(SystemParam systemParam);


    /**
     * 按id删除对象
     * @param systemParam
     * @return
     */
    public OutDTO<SystemParam> deleteById(SystemParam systemParam);


    /**
     * 查找实体对象
     * @param systemParam
     * @return
     */
    public OutDTO<SystemParam> get(SystemParam systemParam);

    /**
     * 创建实体对象
     * @param systemParam
     * @return
     */
    public OutDTO<SystemParam> save(SystemParam systemParam);

    /**
     * 查询所有的对象
     * @param systemParam
     * @return
     */
    public OutDTO listAll(SystemParam systemParam);

    /**
     * 校验参数名称存在
     * @param data
     * @return
     */
    boolean validateParamNameExist(SystemParam data);
}
