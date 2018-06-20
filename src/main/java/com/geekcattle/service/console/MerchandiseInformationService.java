package com.geekcattle.service.console;

import com.geekcattle.mapper.console.MerchandiseInformationMapper;
import com.geekcattle.model.console.MerchandiseInformation;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author peng
 * date 2018年6月18日23:45:06
 */
@Service
public class MerchandiseInformationService {

    @Autowired
    private MerchandiseInformationMapper merchandiseInformationMapper;

    public List<MerchandiseInformation> getMechandiseInformation(){
        PageHelper.orderBy("merchandise_created_time asc");
        return merchandiseInformationMapper.selectAll();
    }

    public void insertMerchandiseInformation(MerchandiseInformation merchandiseInformation){
        merchandiseInformationMapper.insert(merchandiseInformation);
    }
    public void deleteMerchandiseInformation(MerchandiseInformation merchandiseInformation){
        merchandiseInformationMapper.delete(merchandiseInformation);

    }
    public void updateMerchandiseInformation(MerchandiseInformation merchandiseInformation){
        merchandiseInformationMapper.updateByPrimaryKey(merchandiseInformation);
    }

    public MerchandiseInformation getById(String merchandiseId) {
        return merchandiseInformationMapper.selectByPrimaryKey(merchandiseId);
    }

    public void deleteRoleId(String id) {
        merchandiseInformationMapper.deleteByPrimaryKey(id);
    }
}


