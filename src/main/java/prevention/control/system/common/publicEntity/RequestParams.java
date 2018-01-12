package prevention.control.system.common.publicEntity;

import java.util.Map;

/**
 * 客户端往后台的请求参数对象.
 *
 * @author [董振]
 * @version [v1.0, 2017/07/31]
 * @since [v1.0]
 */
public class RequestParams {
    //map参数上传
    private Map<String, Object> map;

    public RequestParams() {
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
