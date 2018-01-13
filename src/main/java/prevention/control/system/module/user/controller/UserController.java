package prevention.control.system.module.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import prevention.control.system.common.publicEntity.Pagination;
import prevention.control.system.common.publicEntity.RequestParams;
import prevention.control.system.common.publicEntity.Result;
import prevention.control.system.common.publicEntity.ResultCodeMessage;
import prevention.control.system.module.user.entity.User;
import prevention.control.system.module.user.service.UserService;
import prevention.control.system.module.user.service.impl.UserServiceImpl;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by 董振 on 2018/1/11.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/queryUser", method = {RequestMethod.POST})
    public Result queryUser(@RequestBody(required = false) RequestParams requestParams){
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("userId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        logger.info("接收参数实体");
        Integer userId = Integer.parseInt(map.get("userId").toString());
        User user = userService.queryUserById(userId);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("user", user);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    @RequestMapping("/queryAllUser")
    public Result queryAllUser(@RequestBody(required = false) RequestParams requestParams){
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
        Pagination<User> userPagination = userService.queryAllUser(pageSize, pageNo);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("allUser", userPagination);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    @RequestMapping("/updateUserInfo")
    public Result updateUserName(@RequestBody(required = false) RequestParams requestParams){
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("userId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        Integer userId = Integer.parseInt(map.get("userId").toString());
        String userName = null;
        if (!Objects.isNull(map.get("userName"))) {
            userName = map.get("userName").toString();
        }
        String password = null;
        if (!Objects.isNull(map.get("password"))) {
            password = map.get("password").toString();
        }
        boolean bool = userService.updateUserInfo(userId, userName, password);
        if (bool == false) {
            result.setSubCode(ResultCodeMessage.EXECUTE_FAIL_CODE);
            result.setSubMessage(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        result.executeSuccess(ResultCodeMessage.UPDATED_SUCCESS_MESSAGE);
        return result;
    }
}
