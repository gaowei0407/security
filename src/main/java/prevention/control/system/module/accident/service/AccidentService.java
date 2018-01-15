package prevention.control.system.module.accident.service;

import prevention.control.system.common.publicEntity.Pagination;
import prevention.control.system.module.accident.entity.Accident;
import prevention.control.system.module.accident.entity.AccidentCategory;
import prevention.control.system.module.user.entity.User;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by 董振 on 2018/1/11.
 */
public interface AccidentService {

    /**
     * 查询所有事故类别
     * @return
     */
   List<AccidentCategory> queryAllAccidentCategory();

    /**
     * 查询所有事故基本信息
     * @return
     */
    Pagination<Accident> queryAllAccident(int pageSize,int PageNo);

    /**
     * 根据事故名称查询事故基本信息
     * @return
     */
    Pagination<Accident> selectAccidentByName(int pageSize,int PageNo,String accidentName);

    int addAccident(Map<String, Object> map) throws ParseException;
}
