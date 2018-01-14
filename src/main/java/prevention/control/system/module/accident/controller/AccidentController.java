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
import prevention.control.system.module.accident.entity.Accident;
import prevention.control.system.module.accident.entity.AccidentCategory;
import prevention.control.system.module.accident.service.AccidentService;
import prevention.control.system.module.user.entity.User;

import java.text.ParseException;
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



    @RequestMapping("/queryAllAccidentcategory")
    public Result queryAllAccidentcategory(@RequestBody(required = false) RequestParams requestParams){
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        List<AccidentCategory> accidentPagination = accidentService.queryAllaccidentcategory();
        System.out.println("accidentPagination"+accidentPagination.toString());
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("allaccidentcategory", accidentPagination);
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
        paramsList.put("allaccidentcategory", accidentPagination);
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
            Map<String, Object> paramsList = new HashMap<>();
            paramsList.put("allaccidentcategory", sucess);
            result.setData(paramsList);
        }catch (ParseException p){

        }catch (Exception e){

        }

        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }
}
