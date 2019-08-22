package com.yihuisoft.authoritybiz.controller.organization;

import com.yihuisoft.authoritybiz.dto.organization.OrganizationCheckDTO;
import com.yihuisoft.authoritybiz.dto.organization.OrganizationDTO;
import com.yihuisoft.authoritybiz.entity.organization.Organization;
import com.yihuisoft.authoritybiz.service.organization.OrganizationService;
import com.yihuisoft.common.dto.OutDTO;
import com.yihuisoft.common.exception.ApplicationException;
import com.yihuisoft.common.util.app.OutDTOFactory;
import com.yihuisoft.common.util.excel.BeanToExcel;
import com.yihuisoft.common.util.excel.ExcelDataFormatter;
import com.yihuisoft.common.vo.InVO;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 * 机构管理控制层
 * @author laijd
 * @date 2019/06/25
 * @version V4.0.0
 * */

@RestController
@RequestMapping("/wmsp/authority/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    /**
     * 查询机构信息数据接口
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/get")
    public OutDTO getOrganization(@Validated @RequestBody InVO<OrganizationDTO> inVO){
        return organizationService.getOrganization(inVO.getData());
    }

    /**
     * 查询下级机构树接口
     * @param inVO
     * @return OutDTO
     * @throws InterruptedException
     * @throws ApplicationException
     */
    @PostMapping(value = "/list_sub_organizations_tree")
    public OutDTO listSubOrganizationsTree(@Validated @RequestBody InVO<OrganizationDTO> inVO) throws InterruptedException, ApplicationException {
        return organizationService.listSubOrganizationsTree(inVO.getData());
    }
    /**
     * 导出机构信息,根据机构编码查询当前机构及其子机构信息 qryOrgnListByOrgnCode
     * @param inVO
     * @param response
     * @throws Exception
     * @date 2019/07/5 14:21
     * @author laijd
     * 4.0.1版本需求中删除机构详情的导出功能
     */
    @Deprecated
    @PostMapping(value = "/export")
    @ResponseBody
    public void downloadOrganization(@Validated @RequestBody InVO<OrganizationDTO> inVO, HttpServletResponse response) throws Exception {
        List<Organization> list = organizationService.listSubOrganizations(inVO.getData());
        //格式化Excel
        ExcelDataFormatter edf = new ExcelDataFormatter();
        Workbook wb = BeanToExcel.getWorkBook(list, edf);
        response.setCharacterEncoding("UTF-8");
        // 设置contentType为excel格式
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("机构.xls", "utf-8"));
        response.flushBuffer();
        wb.write(response.getOutputStream());
    }

    /**
     * 根据机构code递归查询子机构及其下级所有机构
     * (现场服务调用 queryCurUser2,qryOrgnListByOrgnCode 都调用该方法)
     * 客户列表，
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/list_sub_organizations")
    public OutDTO listSubOrganizations(@RequestBody InVO<OrganizationDTO> inVO){
        List<Organization> organizationList = organizationService.listSubOrganizations(inVO.getData());
        return OutDTOFactory.getSucceedOutDTO().putList(organizationList);
    }

    /**
     * 机构信息校验
     * @param inVO
     * @return OutDTO
     */
    @PostMapping(value = "/check")
    public OutDTO checkOrganization(@RequestBody InVO<OrganizationCheckDTO> inVO){
        return organizationService.checkOrganization(inVO.getData());
    }

}
