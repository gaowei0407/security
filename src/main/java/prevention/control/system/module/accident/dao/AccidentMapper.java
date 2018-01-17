package prevention.control.system.module.accident.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import prevention.control.system.module.accident.entity.*;

import java.util.Date;
import java.util.List;

/**
 * Created by 董振 on 2018/1/11.
 */
@Repository
public interface AccidentMapper {
    /**
     * 查询所有事故类别名称
     * @return
     */
    List<AccidentCategory>  selectCategoryName();


    /**
     * 查询所有事故基本信息
     * @return
     */
    List<Accident>  selectAllAccident();

    /**
     * 根据事故类别id查询所有事故基本信息
     * @return
     */
    List<Accident>  selectAllAccidentByCategoryId(@Param("accidentCategoryId") String accidentCategoryId);

    /**
     * 根据事故名称查询事故基本信息
     * @return
     */
    List<Accident>  selectAccidentByName(@Param("accidentName") String accidentName);

    /**
     * 向事故基本信息表中插入信息
     * @return
     */
    int insertAccident(@Param("accident") Accident accident);


    /**
     * 向事故调查报告表内插入信息
     * @return
     */
    int insertAccidentInvestigationReport(@Param("accidentId") long accidentId, @Param("reportContent") String reportContent);

    /**
     * 向事故行为原因分析表中插入数据
     * @return
     */
    int insertAnalysisOfTheCauseOfBehavior(@Param("accidentId") long accidentId, @Param("behaviorContent") String behaviorContent);

    /**
     * 向事故宏观规律表中插入数据
     * @return
     */
    int insertMacroscopicLawOfAccident(@Param("accidentId") long accidentId, @Param("macroscopicContent") String behaviorContent);

    /**
     * 向事故预防控制措施表中插入数据
     * @return
     */
    int insertPreventionAndControlMeasures(@Param("accidentId") long accidentId, @Param("measuresContent") String behaviorContent);

    /**
     * 向事故原因规律统计表中插入数据
     * @return
     */
    int insertStatisticsOfReasons(@Param("accidentId") long accidentId, @Param("reasonsContent") String behaviorContent);

    /**
     * 根据事故id查询事故报告
     * @return
     */
    List<accidentInvestigationReport>  selectAccidentInvestigationReportByAccidentId(@Param("accidentId") String accidentId);

    /**
     * 根据事故id查询事故原因
     * @return
     */
    List<analysisOfTheCauseOfBehavior>  selectAnalysisOfTheCauseOfBehaviorByAccidentId(@Param("accidentId") String accidentId);

    /**
     * 根据事故id查询事故宏观规律
     * @return
     */
    List<macroscopicLawOfAccident>  selectMacroscopicLawOfAccidentByAccidentId(@Param("accidentId") String accidentId);

    /**
     * 根据事故id查询事故预防措施
     * @return
     */
    List<preventionAndControlMeasures>  selectPreventionAndControlMeasuresByAccidentId(@Param("accidentId") String accidentId);

    /**
     * 根据事故id查询事故宏观规律统计
     * @return
     */
    List<statisticsOfReasons>  selectStatisticsOfReasonsByAccidentId(@Param("accidentId") String accidentId);

}
