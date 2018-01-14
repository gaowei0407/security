package prevention.control.system.module.accident.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import prevention.control.system.module.accident.entity.Accident;
import prevention.control.system.module.accident.entity.AccidentCategory;

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
     * 根据事故名称查询事故基本信息
     * @return
     */
    List<Accident>  selectAccidentByName(@Param("accidentName") String accidentName);

    /**
     * 向事故基本信息表中插入信息
     * @return
     */
    int insertAccident(@Param("accidentName")String accidentName,@Param("occurrencePlace") String occurrencePlace,@Param("occurrenceTime")Date occurrenceTime,@Param("isAnalysis") int isAnalysis,@Param("userId") int userId,@Param("accidentCategoryId") int accidentCategoryId);

}
