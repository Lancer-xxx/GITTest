package com.yihuisoft.maintenancebiz.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.app.CheckUtils;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.util.app.SnowFlakeIdWorker;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryTypeListDTO;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryTypeSaveDTO;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryTypeUpdateDTO;
import com.yihuisoft.maintenancebiz.entity.dictionary.DictionaryListDO;
import com.yihuisoft.maintenancebiz.entity.dictionary.DictionaryType;
import com.yihuisoft.maintenancebiz.entity.dictionary.DictionaryTypeListDO;
import com.yihuisoft.maintenancebiz.mapper.dictionary.DictionaryTypeMapper;
import com.yihuisoft.maintenancebiz.service.dictionary.DictionaryTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
/**
* 字典管理-字典类别实现层
* @author laijd
* @date 2019-08-13 13:56
* @version V4.0.2
*/
@Service
public class DictionaryTypeServiceImpl implements DictionaryTypeService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    DictionaryTypeMapper dictionaryTypeMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OutDTO saveDictionaryType(DictionaryTypeSaveDTO dictionaryTypeSaveDTO) {
        try {
            DictionaryType dictionaryType = new DictionaryType();
            CopyUtils.copy(dictionaryTypeSaveDTO, dictionaryType);
            //字典类别名称验重
            if(checkParamExists(dictionaryType.getDictTypeName(),"",null,false)){
                logger.info(ResultEnum.ERROR_MAINTANCE_EXIST_DICT_TYPE_NAME.getMessage());
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_MAINTANCE_EXIST_DICT_TYPE_NAME);
            }
            //字典类别标识验重
            if(checkParamExists("", dictionaryType.getDictTypeCode(),null,false)){
                logger.info(ResultEnum.ERROR_MAINTANCE_EXIST_DICT_TYPE_CODE.getMessage());
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_MAINTANCE_EXIST_DICT_TYPE_CODE);
            }
            dictionaryType.setId(SnowFlakeIdWorker.generateId());
            dictionaryType.setCreateTime(new Date());
            dictionaryType.setUpdateUserid(dictionaryType.getCreateUserid());
            dictionaryType.setUpdateTime(new Date());
            int res = dictionaryTypeMapper.insert(dictionaryType);
            if (res == 1) {
                return OutDTOFactory.getSucceedOutDTO();
            }
        }catch(Exception e){
            logger.error("saveDictionaryType:"+e);
            throw new ApplicationException(ResultEnum.ERROR_INSERT);
        }
        return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_INSERT);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OutDTO updateDictionaryType(DictionaryTypeUpdateDTO dictionaryTypeUpdateDTO) {
        int result;
        try {
            DictionaryType dictionaryType = new DictionaryType();
            CopyUtils.copy(dictionaryTypeUpdateDTO, dictionaryType);
            //字典类别名称验重
            if (checkParamExists(dictionaryType.getDictTypeName(), "", dictionaryType.getId(), true)) {
                logger.info(ResultEnum.ERROR_MAINTANCE_EXIST_DICT_TYPE_NAME.getMessage());
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_MAINTANCE_EXIST_DICT_TYPE_NAME);
            }
            dictionaryType.setUpdateTime(new Date());

            result = dictionaryTypeMapper.updateByPrimaryKeySelective(dictionaryType);
        }catch (Exception e){
            logger.error("updateDictionaryType:"+e);
            throw new ApplicationException(ResultEnum.ERROR_UPDATE);
        }
        return CheckUtils.checkUpdate(result);
    }

    @Override
    public OutDTO listDictionaryType(DictionaryTypeListDTO dictionaryTypeListDTO, PageMessage pageMessage) {
        List<DictionaryTypeListDO> dictionaryTypeList;
        PageInfo<DictionaryTypeListDO> page;
        try{
            // 检查分页信息
            pageMessage = PageMessage.check(pageMessage);
            PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());

            DictionaryType dictionaryType = new DictionaryType();
            CopyUtils.copy(dictionaryTypeListDTO,dictionaryType);

            dictionaryTypeList = dictionaryTypeMapper.listDictionaryTypes(dictionaryType);
            page = new PageInfo<DictionaryTypeListDO>(dictionaryTypeList);
        }catch (Exception e){
            logger.error("listDictionaryType:" + e);
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_SYSTEM_REQUEST);
        }
        return OutDTOFactory.getSucceedOutDTO().putList(dictionaryTypeList).setSumCount(page.getTotal());
    }

     /**
      * 校验字典类别名称/标识是否重复
      * @param  dictTypeName 字典类别名称
      * @param dictTypeCode 字典类别标识
      * @param id 字典类别ID
      * @param isUpdate true:修改字典类别信息，false:新增字典类别信息
      * @return boolean true:重复，false：不重复
      */
    public boolean checkParamExists(String dictTypeName,String dictTypeCode,Long id,boolean isUpdate){
        DictionaryType dictionaryType = new DictionaryType();
        dictionaryType.setDictTypeCode(dictTypeCode);
        dictionaryType.setDictTypeName(dictTypeName);
        dictionaryType.setId(id);

        List<Long> dictTypeIdList = dictionaryTypeMapper.checkParamExists(dictionaryType);
        if(!ObjectUtils.isEmpty(dictTypeIdList)){
            return true;
        }
        return false;
    }
}
