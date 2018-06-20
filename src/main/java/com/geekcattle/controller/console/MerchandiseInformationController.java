package com.geekcattle.controller.console;

import com.geekcattle.model.console.MerchandiseInformation;
import com.geekcattle.service.console.MerchandiseInformationService;
import com.geekcattle.util.DateUtil;
import com.geekcattle.util.ReturnUtil;
import com.geekcattle.util.UuidUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.expression.Lists;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/console/merchandise")
public class MerchandiseInformationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MerchandiseInformationService merchandiseInformationService;

    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(Model model) {
        return "/console/merchandise/index";
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap List(MerchandiseInformation merchandiseInformation){
        ModelMap map = new ModelMap();
        List<MerchandiseInformation> listMerchandiseInformation = merchandiseInformationService.getMechandiseInformation();
        map.put("pageInfo",new PageInfo<MerchandiseInformation>(listMerchandiseInformation));
        map.put("queryParam",merchandiseInformation);
        return ReturnUtil.Success("操作成功",map,null);
    }


    @RequestMapping(value = "/from", method = {RequestMethod.GET})
    public String from(MerchandiseInformation merchandiseInformation,Model model){
        if (!StringUtils.isEmpty(merchandiseInformation.getMerchandiseId())){
            merchandiseInformation = merchandiseInformationService.getById(merchandiseInformation.getMerchandiseId());
        }
        model.addAttribute("merchandiseInformation",merchandiseInformation);
        return "console/merchandise/from";
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ResponseBody
    public ModelMap save(@Valid MerchandiseInformation merchandiseInformation){
        try {
            if(StringUtils.isEmpty(merchandiseInformation.getMerchandiseId())){
                merchandiseInformation.setMerchandiseId(UuidUtil.getUUID());
                merchandiseInformation.setMerchandiseCreateTime(DateUtil.getCurrentTime());
                merchandiseInformation.setMerchandiseUpdatedTime(DateUtil.getCurrentTime());
                merchandiseInformationService.insertMerchandiseInformation(merchandiseInformation);
            } else {
                merchandiseInformation.setMerchandiseCreateTime(merchandiseInformationService.getById(merchandiseInformation.getMerchandiseId()).getMerchandiseCreatedTime());
                merchandiseInformation.setMerchandiseUpdatedTime(DateUtil.getCurrentTime());
                merchandiseInformationService.updateMerchandiseInformation(merchandiseInformation);
            }
            return ReturnUtil.Success("操作成功",null,"/console/merchandise/index");
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.Error("操作失败",null,null);
        }
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap delete(String[] ids) {
        try {
            if ("null".equals(ids) || "".equals(ids)) {
                return ReturnUtil.Error("Error", null, null);
            } else {
                for (String id : ids) {
                   merchandiseInformationService.deleteRoleId(id);
                }
                return ReturnUtil.Success("操作成功", null, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.Error("操作失败", null, null);
        }
    }

}
