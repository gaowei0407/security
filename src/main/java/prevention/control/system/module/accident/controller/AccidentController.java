package prevention.control.system.module.accident.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import prevention.control.system.common.publicEntity.Pagination;
import prevention.control.system.common.publicEntity.RequestParams;
import prevention.control.system.common.publicEntity.Result;
import prevention.control.system.common.publicEntity.ResultCodeMessage;
import prevention.control.system.module.accident.entity.*;
import prevention.control.system.module.accident.service.AccidentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by 王亚豪 on 2018/1/14.
 */
@Controller
@RequestMapping("/Accident")
public class AccidentController {
    private static Logger logger = LoggerFactory.getLogger(AccidentController.class);

    @Autowired
    @Qualifier("accidentServiceImpl")
    private AccidentService accidentService;



    @RequestMapping("/queryAllAccidentCategory")
    public Result queryAllAccidentCategory(@RequestBody(required = false) RequestParams requestParams){
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        List<AccidentCategory> accidentPagination = accidentService.queryAllAccidentCategory();
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("AllAccidentCategory", accidentPagination);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }


    @RequestMapping("/queryAllAccident")
    public Result queryAllAccident(@RequestBody(required = false) RequestParams requestParams){
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("pageSize")) || Objects.isNull(map.get("pageNo"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        Pagination<Accident> accidentPagination = accidentService.queryAllAccident(pageSize,pageNo);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("accidentList", accidentPagination);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    @RequestMapping("/queryAllAccidentByCategoryId")
    public Result queryAllAccidentByCategoryId(@RequestBody(required = false) RequestParams requestParams){
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if(Objects.isNull(map.get("pageSize")) || Objects.isNull(map.get("pageNo"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        String accidentCategoryId=map.get("accidentCategoryId").toString();
        Pagination<Accident> accidentPagination = accidentService.queryAllAccidentByCategoryId(pageSize,pageNo,accidentCategoryId);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("accidentList", accidentPagination);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    @RequestMapping("/queryAccidentByName")
    public Result queryAccidentByName(@RequestBody(required = false) RequestParams requestParams){
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("pageSize")) || Objects.isNull(map.get("pageNo"))||Objects.isNull(map.get("accidentName"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        String accidentName=map.get("accidentName").toString();
        Pagination<Accident> accidentPagination = accidentService.selectAccidentByName(pageSize,pageNo,accidentName);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("allaccidentcategory", accidentPagination);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    @RequestMapping("/addAccident")
    public Result addAccident(@RequestBody(required = false) RequestParams requestParams){
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("accidentName")) || Objects.isNull(map.get("occurrencePlace"))||
                Objects.isNull(map.get("occurrenceTime"))||Objects.isNull(map.get("isAnalysis"))||
                Objects.isNull(map.get("userId"))||Objects.isNull(map.get("accidentCategoryId"))||
                Objects.isNull(map.get("reportContent"))||Objects.isNull(map.get("behaviorContent"))||
                Objects.isNull(map.get("macroscopicContent"))|| Objects.isNull(map.get("measuresContent"))||
                Objects.isNull(map.get("reasonsContent"))){
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }

        try {
            int  sucess = accidentService.addAccident(map);
            if (sucess==0){
                result.setSubCode(ResultCodeMessage.EXECUTE_FAIL_CODE);
                result.setSubMessage(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
                return result;
            }
            Map<String, Object> paramsList = new HashMap<>();
            paramsList.put("isSuccess", sucess);
            result.setData(paramsList);
            result.executeSuccess(ResultCodeMessage.ADD_SUCCESS_MESSAGE);
        }catch (Exception e){
            System.err.println("添加事故失败,原因:"+e.toString());
            result.setSubCode(ResultCodeMessage.EXECUTE_FAIL_CODE);
            result.setSubMessage(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
            return result;
        }
        return result;
    }

    @RequestMapping("/queryInvestigationReportByAccidentId")
    public Result queryInvestigationReportByAccidentId(@RequestBody(required = false) RequestParams requestParams){
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("accidentId"))){
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        String accidentId=map.get("accidentId").toString();
        List<accidentInvestigationReport> accidentReport= accidentService.queryAccidentInvestigationReportByAccidentId(accidentId);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("accidentReport", accidentReport);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    @RequestMapping("/queryAnalysisOfTheCauseOfBehaviorByAccidentId")
    public Result queryAnalysisOfTheCauseOfBehaviorByAccidentId(@RequestBody(required = false) RequestParams requestParams){
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("accidentId"))){
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        String accidentId=map.get("accidentId").toString();
        List<analysisOfTheCauseOfBehavior> accidentReason= accidentService.queryAnalysisOfTheCauseOfBehaviorByAccidentId(accidentId);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("accidentReason", accidentReason);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    @RequestMapping("/queryMacroscopicLawOfAccidentByAccidentId")
    public Result queryMacroscopicLawOfAccidentByAccidentId(@RequestBody(required = false) RequestParams requestParams){
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("accidentId"))){
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        String accidentId=map.get("accidentId").toString();
        List<macroscopicLawOfAccident> accidentMacroscopicLaw= accidentService.queryMacroscopicLawOfAccidentByAccidentId(accidentId);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("accidentMacroscopicLaw", accidentMacroscopicLaw);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }


    @RequestMapping("/queryPreventionAndControlMeasuresByAccidentId")
    public Result queryPreventionAndControlMeasuresByAccidentId(@RequestBody(required = false) RequestParams requestParams){
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("accidentId"))){
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        String accidentId=map.get("accidentId").toString();
        List<preventionAndControlMeasures> accidentPreventionAndControl= accidentService.queryPreventionAndControlMeasuresByAccidentId(accidentId);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("accidentPreventionAndControl", accidentPreventionAndControl);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    @RequestMapping("/queryStatisticsOfReasonsByAccidentId")
    public Result queryStatisticsOfReasonsByAccidentId(@RequestBody(required = false) RequestParams requestParams){
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("accidentId"))){
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        String accidentId=map.get("accidentId").toString();
        List<statisticsOfReasons> accidentStatisticsOfReasons= accidentService.queryStatisticsOfReasonsByAccidentId(accidentId);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("accidentStatisticsOfReasons", accidentStatisticsOfReasons);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }
}
