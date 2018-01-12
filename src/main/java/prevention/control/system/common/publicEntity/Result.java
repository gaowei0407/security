package prevention.control.system.common.publicEntity;

import com.google.common.collect.Maps;

import java.io.Serializable;

/**
 * 统一的返回结果.
 *
 * @author [dongzhen]
 * @version [v1.0, 2017/08/03]
 * @since [v1.0]
 */
public class Result implements Serializable {
    private int code;
    private String message;
    private int subCode = 0;
    private String subMessage = "";
    private Object data = Maps.newHashMap();
    private String methodName;

    public Result(String methodName) {
        this.methodName = methodName;
        this.setCode(ResultCodeMessage.SUCCESS_CODE);
        this.setMessage(ResultCodeMessage.message(ResultCodeMessage.SUCCESS_MESSAGE, this.methodName));
    }

    /**
     * 初始化系统级返回Result.
     *
     * @return
     */
    public Result codeInit() {
        this.setCode(ResultCodeMessage.SUCCESS_CODE);
        this.setMessage(ResultCodeMessage.message(ResultCodeMessage.SUCCESS_MESSAGE, this.methodName));
        return this;
    }

    /**
     * 系统级正确返回ok.
     *
     * @return this
     */
    public Result SystemSuccess() {
        this.setCode(ResultCodeMessage.SUCCESS_CODE);
        this.setMessage(ResultCodeMessage.message(ResultCodeMessage
                .SUCCESS_MESSAGE, this.methodName));
        this.setSubCode(ResultCodeMessage.SUB_SUCCESS_CODE);
        this.setSubMessage(ResultCodeMessage.message(ResultCodeMessage.SUB_SUCCESS_MESSAGE, this.methodName));
        return this;
    }

    /**
     * 执行成功，填充subMessage
     *
     * @return this
     */
    public Result executeSuccess(String message) {
        this.setSubCode(ResultCodeMessage.SUB_SUCCESS_CODE);
        this.setSubMessage(ResultCodeMessage.message(message, this.methodName));
        return this;
    }

    /**
     * 执行成功，填充subCode和subMessage
     *
     * @return this
     */
    public Result executeResult(int code, String message, String methodName) {
        this.methodName = methodName;
        this.setCode(ResultCodeMessage.SUCCESS_CODE);
        this.setMessage(ResultCodeMessage.message(ResultCodeMessage
                .SUCCESS_MESSAGE, this.methodName));
        this.setSubCode(code);
        this.setSubMessage(ResultCodeMessage.message(message, this.methodName));
        return this;
    }

    /**
     * 系统异常返回
     *
     * @param
     * @return this
     */
    public Result SystemError() {
        this.setCode(ResultCodeMessage.SYSTEM_ERROR_FAIL_CODE);
        this.setMessage(ResultCodeMessage.message(ResultCodeMessage.SYSTEM_ERROR_FAIL_MESSAGE, "api"));
        return this;
    }

    /**
     * 参数错误返回
     *
     * @param message 错误信息
     * @return this
     */
    public Result paramsError(String message) {
        this.setSubCode(ResultCodeMessage.PARAMS_FAIL_CODE);
        this.setSubMessage(ResultCodeMessage.message(message, this.methodName));
        return this;
    }

    public int getSubCode() {
        return subCode;
    }

    public void setSubCode(int subCode) {
        this.subCode = subCode;
    }

    public String getSubMessage() {
        return subMessage;
    }

    public void setSubMessage(String subMessage) {
        this.subMessage = subMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "OldResult [code=" + code + ", message=" + message + ", subCode=" + subCode + ", subMessage=" + subMessage + ", data=" + data + "]";
    }
}
