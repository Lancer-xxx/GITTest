package com.yihuisoft.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.mapper.AbstractMapper;
import com.yihuisoft.common.service.CommonService;
import com.yihuisoft.common.util.app.CheckUtils;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.vo.PagerVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 *
 * @param <D> 数据对象
 * //@param <T> mybatis mapper映射
 */
public class CommonServiceImpl<D> implements CommonService<D> {

    //@Lazy
    @Autowired
    AbstractMapper<D> mapper;

    @Override
    public OutDTO<D> getById(Integer id) {
        D d = (D) mapper.getById(id);
        return OutDTOFactory.getSucceedOutDTO()
                .putInfo(d);
    }

    public static final int defaultPageNo = 1;

    public static final int defaulPageSize = 10;

    @Override
    public OutDTO<D> list(PagerVO<D> pagerVO) {
        // 分页查询，默认返回第一页，一页返回10条
        int pageNo = defaultPageNo;
        int pageSize = defaulPageSize;

        if(pagerVO != null && pagerVO.getPageMessage() != null){
            pageNo = pagerVO.getPageMessage().getPageNo() == null ? defaultPageNo : pagerVO.getPageMessage().getPageNo();
            pageSize = pagerVO.getPageMessage().getPageSize() == null ? defaulPageSize : pagerVO.getPageMessage().getPageSize();
        }

        PageHelper.startPage(pageNo, pageSize);
        List<D> list = mapper.list(pagerVO);

        // 用PageInfo对结果进行包装
        PageInfo<D> page = new PageInfo<D>(list);

        // 封装返回信息
        return OutDTOFactory.getSucceedOutDTO()
                .putList(list)
                .setSumCount(page.getTotal());
    }

    @Override
    public OutDTO<D> updateById(D d) {
        int result = mapper.updateById(d);
        return CheckUtils.checkUpdate(result);
    }

    @Override
    public OutDTO<D> deleteById(D d) {
        int result = mapper.deleteById(d);
        return CheckUtils.checkDelete(result);
    }

    @Override
    public OutDTO<D> save(D d) {
        // 检查存在性
        int result = mapper.save(d);
        return result > 0 ?  OutDTOFactory.getSucceedOutDTO(): OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_INSERT);
    }

    @Override
    public OutDTO<D> get(D d) {
        D result = mapper.get(d);
        return OutDTOFactory.getSucceedOutDTO()
                .putInfo(result);
    }


    @Override
    public OutDTO<D> listAll(D d) {
        List<D> result = mapper.listAll(d);
        return OutDTOFactory.getSucceedOutDTO()
                .putList(result).setSumCount( result == null ? 0 : (long) result.size());
    }
}
