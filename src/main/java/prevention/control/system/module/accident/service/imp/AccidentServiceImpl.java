package prevention.control.system.module.accident.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import prevention.control.system.module.accident.dao.AccidentMapper;
import prevention.control.system.module.accident.entity.*;
import prevention.control.system.module.accident.service.AccidentService;
import prevention.control.system.common.publicEntity.Pagination;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 王亚豪 on 2018/1/14.
 */
@Service
public class AccidentServiceImpl implements AccidentService {

    @Resource
    private AccidentMapper accidentMapper;





    @Override
    public List<AccidentCategory> queryAllAccidentCategory() {
        List<AccidentCategory> selectCategoryName = accidentMapper.selectCategoryName();
        return selectCategoryName;
    }


    @Override
    public Pagination<Accident> queryAllAccident(int pageSize,int pageNo) {
        // 处理分页
        PageHelper.startPage(pageNo, pageSize);
        List<Accident> accidents = accidentMapper.selectAllAccident();
        PageInfo<Accident> pageInfo = new PageInfo<Accident>(accidents);
        return new Pagination<Accident>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public Pagination<Accident> queryAllAccidentByCategoryId(int pageSize,int pageNo,String accidentCategoryId) {
        // 处理分页
        PageHelper.startPage(pageNo, pageSize);
        List<Accident> accidents = accidentMapper.selectAllAccidentByCategoryId(accidentCategoryId);
        PageInfo<Accident> pageInfo = new PageInfo<Accident>(accidents);
        return new Pagination<Accident>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public Pagination<Accident> selectAccidentByName(int pageSize, int pageNo, String accidentName) {
        // 处理分页
        PageHelper.startPage(pageNo, pageSize);
        List<Accident> accidents = accidentMapper.selectAccidentByName(accidentName);
        PageInfo<Accident> pageInfo = new PageInfo<Accident>(accidents);
        return new Pagination<Accident>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public int addAccident(Map<String, Object> map) throws ParseException {
        String occurrencePlace=map.get("occurrencePlace").toString();//发生地点
        String accidentName= map.get("accidentName").toString();//事故名称

        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        Date occurrenceTime =format.parse(map.get("occurrenceTime").toString());//发生时间

        int isAnalysis= Integer.parseInt(map.get("isAnalysis").toString());//是否完成分析

        int userId=Integer.parseInt(map.get("userId").toString());//用户id

        int accidentCategoryId=Integer.parseInt(map.get("accidentCategoryId").toString());//事故类别id

        String reportContent=map.get("reportContent").toString();//事故调查报告内容

        String behaviorContent=map.get("behaviorContent").toString();//行为原因内容

        String macroscopicContent=map.get("macroscopicContent").toString();//事故宏观规律内容

        String measuresContent=map.get("measuresContent").toString();//事故预防措施内容

        String reasonsContent=map.get("reasonsContent").toString();//事故原因规律内容
        //向事故基本信息表中插入信息
        Accident accident=new Accident();
        accident.setAccidentCategoryId(accidentCategoryId);
        accident.setAccidentName(accidentName);
        accident.setIsAnalysis(isAnalysis);
        accident.setOccurrencePlace(occurrencePlace);
        accident.setOccurrenceTime(occurrenceTime);
        accident.setUserId(userId);
        int accidentCount= accidentMapper.insertAccident(accident);
        System.out.println("accident=="+accident.getAccidentId());
        //向事故调查报告表中插入信息
        int report=accidentMapper.insertAccidentInvestigationReport(accident.getAccidentId(),reportContent);
        System.out.println("report=="+report);
        //向事故行为原因中插入数据
        int reason=accidentMapper.insertAnalysisOfTheCauseOfBehavior(accident.getAccidentId(),behaviorContent);
        //向事故宏观规律表中插入数据
        int macroscopIc=accidentMapper.insertMacroscopicLawOfAccident(accident.getAccidentId(),macroscopicContent);
        //向事故预防措施
        int measures=accidentMapper.insertPreventionAndControlMeasures(accident.getAccidentId(),measuresContent);
        //向事故原因规律表中插入数据
        int causeLaw=accidentMapper.insertStatisticsOfReasons(accident.getAccidentId(),reasonsContent);
        if (accidentCount==0||report==0||reason==0||macroscopIc==0||measures==0||causeLaw==0){
            return 0;
        }
        return 1;
    }

    @Override
    public List<accidentInvestigationReport> queryAccidentInvestigationReportByAccidentId(String accidentId) {

        List<accidentInvestigationReport> accidentReport = accidentMapper.selectAccidentInvestigationReportByAccidentId(accidentId);

        return accidentReport;
    }

    @Override
    public List<analysisOfTheCauseOfBehavior> queryAnalysisOfTheCauseOfBehaviorByAccidentId(String accidentId) {

        List<analysisOfTheCauseOfBehavior> accidentReason = accidentMapper.selectAnalysisOfTheCauseOfBehaviorByAccidentId(accidentId);

        return accidentReason;
    }

    @Override
    public List<macroscopicLawOfAccident> queryMacroscopicLawOfAccidentByAccidentId(String accidentId) {

        List<macroscopicLawOfAccident> accidentMacroscopic = accidentMapper.selectMacroscopicLawOfAccidentByAccidentId(accidentId);

        return accidentMacroscopic;
    }

    @Override
    public List<preventionAndControlMeasures> queryPreventionAndControlMeasuresByAccidentId(String accidentId) {

        List<preventionAndControlMeasures> accidentPreventionAndControl= accidentMapper.selectPreventionAndControlMeasuresByAccidentId(accidentId);

        return accidentPreventionAndControl;
    }

    @Override
    public List<statisticsOfReasons> queryStatisticsOfReasonsByAccidentId(String accidentId) {

        List<statisticsOfReasons> accidentStatisticsOfReasons= accidentMapper.selectStatisticsOfReasonsByAccidentId(accidentId);

        return accidentStatisticsOfReasons;
    }
}
