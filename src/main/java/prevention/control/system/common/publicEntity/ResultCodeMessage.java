package prevention.control.system.common.publicEntity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 返回码.
 *
 * @version [v1.0, 2017/07/31]
 * @since [v1.0]
 */
public class ResultCodeMessage {
	// ==================系统错误码 9000 -10000
	// 公共参数没有传入 9000 -9030
	public static final int COMMON_PARAM_FAIL_CODE = 9000;
	public static final String COMMON_PARAM_FAIL_MESSAGE = "请传入正确的公共参数";
	public static final int APPKEY_NO_PARAM_CODE = 9001;
	public static final String APPKEY_NO_PARAM_MESSAGE = "请传入appkey参数";
	public static final int TIMESTAMP_NO_PARAM_CODE = 9002;
	public static final String TIMESTAMP_NO_PARAM_MESSAGE = "请传入timestamp参数";
	public static final int V_NO_PARAM_CODE = 9003;
	public static final String V_NO_PARAM_MESSAGE = "请传入v参数";
	public static final int SIGN_NO_PARAM_CODE = 9004;
	public static final String SIGN_NO_PARAM_MESSAGE = "请传入sign参数";
	public static final int SIGNMETHOD_NO_PARAM_CODE = 9005;
	public static final String SIGNMETHOD_NO_PARAM_MESSAGE = "请传入signMethod参数";
	public static final int SIGNMETHOD_PARAM_FAIL_CODE = 9006;
	public static final String SIGNMETHOD_PARAM_FAIL_MESSAGE = "signMethod参数错误";
	public static final int METHOD_FAIL_CODE = 9007;
	public static final String METHOD_FAIL_MESSAGE = "方法名称或api协议版本错误";
	public static final int TIMESTAMP_TIMEOUT = 9008;
	public static final String TIMESTAMP_TIMEOUT_MESSAGE = "请求接口超时";
	public static final int INTERFACE_MINUTE_COUNT = 9010;
	public static final String INTERFACE_MINUTE_COUNT_MESSAGE = "频繁调用接口，请一分钟后再试";
	public static final int INTERFACE_COUNT = 9011;
	public static final String INTERFACE_COUNT_MESSAGE = "频繁调用接口，请明天再试";
	public static final int INTERFACE_COUNT_APPKEY = 9012;
	public static final String INTERFACE_COUNT_APPKEY_MESSAGE = "接口调用次数已达上限";
	public static final int APPKEY_ERROR = 9013;
	public static final String APPKEY_ERROR_MESSAGE = "APPKEY错误";
	public static final int IP_URL_ERROR = 9014;
	public static final String IP_URL__ERROR_MESSAGE = "请检查ip和url是否正确";
	// userId解密
	public static final int USERID_DECRYPT_FAIL_CODE = 9009;
	public static final String USERID_DECRYPT_FAIL_MESSAGE = "请先登录";
	// 系统异常
	public static final int SYSTEM_ERROR_FAIL_CODE = 9999;
	public static final String SYSTEM_ERROR_FAIL_MESSAGE = "系统异常,请稍后重试";

	// 9031-9040 签名的代码
	public static final int SIGN_FAIL_CODE = 9031;
	public static final String SIGN_FAIL_MESSAGE = "签名错误";
	// 9041-9060 accessToken的代码
	public static final int GET_TOKEN_SUCCESS_CODE = 9041;
	public static final String GET_TOKEN_SUCCESS_MESSAGE = "获取accessToken成功";
	public static final int GET_TOKEN_FAIL_CODE = 9042;
	public static final String GET_TOKEN_FAIL_MESSAGE = "获取accessToken失败";
	public static final int REFRESH_TOKEN_SUCCESS_CODE = 9043;
	public static final String REFRESH_TOKEN_SUCCESS_MESSAGE = "刷新accessToken成功";
	public static final int TOKEN_VISIT_COUNT_CODE = 9044;
	public static final String TOKEN_VISIT_COUNT_MESSAGE = "accessToken接口访问的次数已达上限";
	public static final int TOKEN_REFRESH_COUNT_CODE = 9045;
	public static final String TOKEN_REFRESH_COUNT_MESSAGE = "accessToken接口刷新的次数已达上限";
	public static final int TOKEN_EXPIRE_COUNT_CODE = 9046;
	public static final String TOKEN_EXPIRE_COUNT_MESSAGE = "accessToken已经过期";

	// 系统错误 9091-10000
	public static final int SUCCESS_CODE = 9091;
	public static final String SUCCESS_MESSAGE = "{0}接口请求成功";
	public static final int FAIL_CODE = 9092;
	public static final String FAIL_MESSAGE = "{0}接口请求失败";

	// ===============业务错误码 10000-?===========================
	// ==业务公共错误码 10001-10100==
	public static final int PARAMS_FAIL_CODE = 10001;
	public static final String PARAMS_FAIL_MESSAGE = "{0}接口参数错误";
	public static final int SUB_SUCCESS_CODE = 10002;
	public static final String SUB_SUCCESS_MESSAGE = "{0}接口请求成功";
	public static final int SUB_FAIL_CODE = 10003;
	public static final String SUB_FAIL_MESSAGE = "{0}接口请求失败";
	// 用户不存在
	public static final int USER_NO_EXIST_CODE = 10004;
	public static final String USER_NO_EXIST_MESSAGE = "用户不存在";
	// 添加成功
	public static final int ADD_SUCCESS_CODE = 10006;
	public static final String ADD_SUCCESS_MESSAGE = "添加成功";
	// 更新成功
	public static final int UPDATED_SUCCESS_CODE = 10007;
	public static final String UPDATED_SUCCESS_MESSAGE = "更新成功";
	// 删除成功
	public static final int DELETE_SUCCESS_CODE = 10008;
	public static final String DELETE_SUCCESS_MESSAGE = "删除成功";
	// 处理失败
	public static final int EXECUTE_FAIL_CODE = 10009;
	public static final String EXECUTE_FAIL_MESSAGE = "处理失败";
	// 系统异常
	public static final int SYSTEM_ERROR_CODE = 10010;
	public static final String SYSTEM_ERROR_MESSAGE = "系统异常";
	// 权限不足
	public static final int PERMISSION_DENIED_CODE = 10011;
	public static final String PERMISSION_DENIED_MESSAGE = "权限不足";

	// ==用户中心 10501-10601
	public static final int VIA_ERROR_CODE = 10501;
	public static final String VIA_ERROR_MESSAGE = "验证码错误";
	public static final int VIA_TIMEOUT_CODE = 10502;
	public static final String VIA_TIMEOUT_MESSAGE = "验证码过期";
	public static final int VIA_NULL_CODE = 10503;
	public static final String VIA_NULL_MESSAGE = "手机号和验证码不能为空";
	public static final int USER_NOT_FOLLOW_CODE = 10504;
	public static final String USER_NOT_FOLLOW_MESSAGE = "用户未被关注";
	public static final int USER_PWD_CODE = 10505;
	public static final String USER_PWD_MESSAGE = "登录失败,请检查账号或密码是否有误";
	public static final int USER_RRS_CODE = 10506;
	public static final String USER_RES_MESSAGE = "该手机未注册,请注册";
	public static final int USER_PHONE_CODE = 10507;
	public static final String USER_PHONE_MESSAGE = "手机号输入有误";
	public static final int USER_EXIST_CODE = 10508;
	public static final String USER_ID_MESSAGE = "用户id不能为空";
	public static final int PASSWORD_ERRO_CODE = 10509;
	public static final String PASSWORD_ERRO_MESSAGE = "密码输入有误";

	public static String message(String message, String... params) {
		return fillStringByArgs(message, params);
	}

	private static String fillStringByArgs(String str, String[] arr) {
		Matcher m = Pattern.compile("\\{(\\d)\\}").matcher(str);
		while (m.find()) {
			str = str.replace(m.group(), arr[Integer.parseInt(m.group(1))]);
		}
		return str;
	}

}
