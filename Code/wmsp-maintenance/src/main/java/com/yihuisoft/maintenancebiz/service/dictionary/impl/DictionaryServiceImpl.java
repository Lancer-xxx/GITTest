package com.yihuisoft.maintenancebiz.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.dto.ResultEnum;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.CopyUtils;
import com.yihuisoft.common.util.StringUtil;
import com.yihuisoft.common.util.app.CheckUtils;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.util.app.SnowFlakeIdWorker;
import com.yihuisoft.common.vo.PageMessage;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryListDTO;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryListSelectDTO;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionarySaveDTO;
import com.yihuisoft.maintenancebiz.dto.dictionary.DictionaryUpdateDTO;
import com.yihuisoft.maintenancebiz.entity.dictionary.Dictionary;
import com.yihuisoft.maintenancebiz.entity.dictionary.DictionaryListDO;
import com.yihuisoft.maintenancebiz.entity.dictionary.DictionaryListSelectDO;
import com.yihuisoft.maintenancebiz.mapper.dictionary.DictionaryMapper;
import com.yihuisoft.maintenancebiz.mapper.dictionary.DictionaryTypeMapper;
import com.yihuisoft.maintenancebiz.service.dictionary.DictionaryService;
import com.yihuisoft.maintenancebiz.service.dictionary.DictionaryTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 字典项业务实现层
* @author laijd
* @date 2019-08-13 15:06
* @version V4.0.2
*/
@Service
public class DictionaryServiceImpl implements DictionaryService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
   private  DictionaryMapper dictionaryMapper;
    @Autowired
    private DictionaryTypeService dictionaryTypeService;
    /**
     * 保存字典项信息
     *
     * @param dictionarySaveDTO
     * @return OutDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OutDTO saveDictionary(DictionarySaveDTO dictionarySaveDTO) {
        try{
            Dictionary dictionary = new Dictionary();
            CopyUtils.copy(dictionarySaveDTO, dictionary);
            //判断字典类别有效
            if(!dictionaryTypeService.checkParamExists("",dictionary.getDictTypeCode(),null,false)){
                logger.info(ResultEnum.ERROR_MAINTANCE_EXIST_DICT_DICT_TYPE_CODE.getMessage());
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_MAINTANCE_EXIST_DICT_DICT_TYPE_CODE);
            }

            //字典项名称验重
            if(checkParamExists(dictionary.getDictName(),"",null,false,dictionary.getDictTypeCode())){
                logger.info(ResultEnum.ERROR_MAINTANCE_EXIST_DICT_NAME.getMessage());
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_MAINTANCE_EXIST_DICT_NAME);
            }
            //字典值标识验重
            if(checkParamExists("", dictionary.getDictValue(),null,false,dictionary.getDictTypeCode())){
                logger.info(ResultEnum.ERROR_MAINTANCE_EXIST_DICT_CODE.getMessage());
                return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_MAINTANCE_EXIST_DICT_CODE);
            }
            dictionary.setId(SnowFlakeIdWorker.generateId());
            dictionary.setCreateTime(new Date());
            dictionary.setUpdateUserid(dictionary.getCreateUserid());
            dictionary.setUpdateTime(new Date());
            int res = dictionaryMapper.insert(dictionary);
            if (res == 1) {
                return OutDTOFactory.getSucceedOutDTO();
            }
        }catch(Exception e){
            logger.error("saveDictionary:"+e);
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_INSERT);
        }
        return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_INSERT);
    }

    /**
     * 修改字典项信息：修改页面修改，修改排序，修改状态：启用/禁用
     *
     * @param dictionaryUpdateDTO
     * @return OutDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OutDTO updateDictionary(DictionaryUpdateDTO dictionaryUpdateDTO) {
        int result;
        try {
            Dictionary dictionary = new Dictionary();
            CopyUtils.copy(dictionaryUpdateDTO, dictionary);
            //启禁用/修改排序时，不改变字典项名称，无需验重
            if(StringUtil.notEmpty(dictionary.getDictName())) {
                //字典类别名称验重
                if (checkParamExists(dictionary.getDictName(), "", dictionary.getId(), true,dictionary.getDictTypeCode())) {
                    logger.info(ResultEnum.ERROR_MAINTANCE_EXIST_DICT_NAME.getMessage());
                    return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_MAINTANCE_EXIST_DICT_NAME);
                }
            }
            dictionary.setUpdateTime(new Date());
            result = dictionaryMapper.updateByPrimaryKeySelective(dictionary);
        }catch (Exception e){
            logger.error("updateDictionary:"+e);
            throw new ApplicationException(ResultEnum.ERROR_UPDATE);
        }
        return CheckUtils.checkUpdate(result);
    }

    /**
     * 查询字典项信息列表
     *
     * @param dictionaryListDTO
     * @param pageMessage
     * @return OutDTO
     */
    @Override
    public OutDTO listDictionary(DictionaryListDTO dictionaryListDTO, PageMessage pageMessage) {
        List<DictionaryListDO> dictionaryListDOS;
        PageInfo<DictionaryListDO> page;
        try{
            // 检查分页信息
            pageMessage = PageMessage.check(pageMessage);
            PageHelper.startPage(pageMessage.getPageNo(), pageMessage.getPageSize());

            Dictionary dictionary = new Dictionary();
            CopyUtils.copy(dictionaryListDTO,dictionary);

            dictionaryListDOS = dictionaryMapper.listDictionary(dictionary);
            page = new PageInfo<DictionaryListDO>(dictionaryListDOS);
        }catch (Exception e){
            logger.error("listDictionary:"+e);
            return OutDTOFactory.getFailOutDTO(ResultEnum.ERROR_SYSTEM_REQUEST);
        }
        return OutDTOFactory.getSucceedOutDTO().putList(dictionaryListDOS).setSumCount(page.getTotal());
    }

    /**
     * 前端下拉框调用字典数据接口
     *
     * @param dictionaryListSelectDTO 状态，字典类别标识
     * @return OutDTO
     */
    @Override
    public OutDTO listDictionarySelect(DictionaryListSelectDTO dictionaryListSelectDTO) {
        Dictionary dictionary = new Dictionary();
        CopyUtils.copy(dictionaryListSelectDTO, dictionary);
        List<DictionaryListSelectDO> dictionaryListSelectDOList = dictionaryMapper.listDictionarySelect(dictionary);
        return OutDTOFactory.getSucceedOutDTO().putList(dictionaryListSelectDOList);
    }

    /**
     * 根据字典类别标识查询出该列别下的所有字典项，并封装成map返回，供其模块间调用
     *
     * @param dictTypeCode
     * @return OutDTO  Map<String,Object> key=dictValue,value=dictName
     */
    @Override
    public Map<String, Object> listDictionaryByDictCodeType(String dictTypeCode) {
        Map<String,Object> dictionaryMap = new HashMap<>(16);
        try {
            Dictionary dictionary = new Dictionary();
            dictionary.setDictTypeCode(dictTypeCode);
            List<DictionaryListSelectDO> dictionaryListSelectDOList = dictionaryMapper.listDictionarySelect(dictionary);
            for (DictionaryListSelectDO selectDO : dictionaryListSelectDOList) {
                dictionaryMap.put(selectDO.getDictValue(), selectDO.getDictName());
            }
        }catch (Exception e){
            logger.error("listDictionaryByDictCodeType："+e);
        }
        return dictionaryMap;
    }

    /**
     * 校验字典项名称/标识是否重复
     * @param  dictName 字典项名称
     * @param dictValue 字典值
     * @param id 字典类别ID
     * @param isUpdate true:修改字典类别信息，false:新增字典类别信息
     * @return boolean true:重复，false：不重复
     */
    private boolean checkParamExists(String dictName,String dictValue,Long id,boolean isUpdate,String dictTypeCode){
        Dictionary dictionary = new Dictionary();
        dictionary.setDictValue(dictValue);
        dictionary.setDictName(dictName);
        dictionary.setDictTypeCode(dictTypeCode);
        dictionary.setId(id);

        List<Long> dictIdList = dictionaryMapper.checkParamExists(dictionary);
        if (!ObjectUtils.isEmpty(dictIdList)) {
            return true;
        }
        return false;
    }
}
