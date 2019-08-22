package com.yihuisoft.maintenancebiz.service.screen.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.service.impl.CommonServiceImpl;
import com.yihuisoft.common.vo.PagerVO;
import com.yihuisoft.maintenancebiz.dto.SystemScreenDTO;
import com.yihuisoft.maintenancebiz.entity.screen.SystemScreen;
import com.yihuisoft.maintenancebiz.mapper.screen.SystemScreenMapper;
import com.yihuisoft.maintenancebiz.service.screen.SystemScreenService;
import com.yihuisoft.maintenancebiz.validator.systemscreen.ScreenExistingValidator;
import com.yihuisoft.maintenancebiz.validator.systemscreen.ScreenImageAliasNameValidator;
import com.yihuisoft.maintenancebiz.validator.systemscreen.ScreenImageSizeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * @author dim
 * @version V4.0.0
 * @Title:
 * @ProjectName WMSP
 * @Description:
 * @date 2019/6/25
 */
@Service
public class SystemScreenServiceImpl extends CommonServiceImpl<SystemScreen> implements SystemScreenService {

    @Autowired
    SystemScreenMapper systemScreenMapper;

    @Override
    public OutDTO<SystemScreenDTO> search(PagerVO<SystemScreenDTO> pagerVO) {
        // 分页查询，默认返回第一页，一页返回10条
        int pageNo = defaultPageNo;
        int pageSize = defaulPageSize;

        if(pagerVO != null && pagerVO.getPageMessage() != null){
            pageNo = pagerVO.getPageMessage().getPageNo() == null ? defaultPageNo : pagerVO.getPageMessage().getPageNo();
            pageSize = pagerVO.getPageMessage().getPageSize() == null ? defaulPageSize : pagerVO.getPageMessage().getPageSize();
        }

        PageHelper.startPage(pageNo, pageSize);
        List<SystemScreen> list = systemScreenMapper.search(pagerVO);

        // 用PageInfo对结果进行包装
        PageInfo<SystemScreen> page = new PageInfo<>(list);

        // 封装返回信息
        return com.yihuisoft.common.util.app.OutDTOFactory.getSucceedOutDTO()
                .putList(list)
                .setSumCount(page.getTotal());
    }



    @Autowired
    ScreenImageAliasNameValidator screenImageAliasNameValidator;

    @Override
    public OutDTO validateAndUpdate(@Validated({ScreenImageAliasNameValidator.class, ScreenImageSizeValidator.class,ScreenExistingValidator.class})
                             @Valid SystemScreen systemScreen){

        systemScreen.setUpdateTime(Date.from(Instant.now()));
        return this.updateById(systemScreen);
    }

    /**
     * 校验文件别名是否存在
     *
     * @param systemScreen
     * @return
     */
    @Override
    public boolean validateFileAliasNameExist(SystemScreen systemScreen) {
        boolean entityHasFileAliasName =  false;

        SystemScreen systemScreenBean = new SystemScreen();
        systemScreenBean.setFileAliasName(systemScreen.getFileAliasName());
        systemScreenBean.setId(systemScreen.getId());

        List<SystemScreen> systemScreenList = this.listAll(systemScreenBean).getListData();

        if(systemScreenList != null && !systemScreenList.isEmpty()){
            entityHasFileAliasName = true;
        }

        return entityHasFileAliasName;
    }

}
