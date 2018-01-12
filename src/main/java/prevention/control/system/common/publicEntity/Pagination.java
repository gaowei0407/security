package prevention.control.system.common.publicEntity;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 分页对象
 *
 * @author [董振]
 * @version [v1.0, 2016/7/8]
 * @since [v1.0]
 */
public class Pagination<T> {
    //总数
    private long total;
    // list列表
    private List<T> list = Lists.newArrayList();

    public Pagination() {
    }

    public Pagination(long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
