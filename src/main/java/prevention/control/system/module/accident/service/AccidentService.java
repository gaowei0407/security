package prevention.control.system.module.accident.service;

import org.apache.ibatis.annotations.Param;
import prevention.control.system.common.publicEntity.Pagination;
import prevention.control.system.module.accident.entity.*;
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
    Pagination<Accident> queryAllAccident(int pageSize, int PageNo);

    /**
     * 事故类别id查询事故基本信息
     * @return
     */
    Pagination<Accident> queryAllAccidentByCategoryId(int pageSize, int PageNo, String accidentCategoryId);

    /**
     * 根据事故名称查询事故基本信息
     * @return
     */
    Pagination<Accident> selectAccidentByName(int pageSize, int PageNo, String accidentName);


    /**
     * 向数据库中添加一条事故
     * @param map
     * @return
     * @throws ParseException
     */
    int addAccident(Map<String, Object> map) throws ParseException;

    /**
     * 根据事故id查询事故调查报告
     * @return
     */
    List<accidentInvestigationReport> queryAccidentInvestigationReportByAccidentId(String accidentId);

    /**
     * 根据事故id查询事故发生原因
     * @return
     */
    List<analysisOfTheCauseOfBehavior> queryAnalysisOfTheCauseOfBehaviorByAccidentId(String accidentId);

    /**
     * 根据事故id查询事故宏观规律
     * @return
     */
    List<macroscopicLawOfAccident>  queryMacroscopicLawOfAccidentByAccidentId(String accidentId);

    /**
     * 根据事故id查询事故预防措施
     * @return
     */
    List<preventionAndControlMeasures>  queryPreventionAndControlMeasuresByAccidentId(String accidentId);

    /**
     * 根据事故id查询事故宏观规律统计
     * @return
     */
    List<statisticsOfReasons>  queryStatisticsOfReasonsByAccidentId(String accidentId);
}
