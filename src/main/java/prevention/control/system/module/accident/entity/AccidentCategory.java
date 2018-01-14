package prevention.control.system.module.accident.entity;

/**
 * 事故类别
 * Created by 王亚豪 on 2018/1/14.
 */
public class AccidentCategory {
    //事故类别id
    private long accidentCategoryId;



    // 事故类别名称
    private String categoryName;

    public long getAccidentCategoryId() {
        return accidentCategoryId;
    }

    public void setAccidentCategoryId(long accidentCategoryId) {
        this.accidentCategoryId = accidentCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Accident{" +
                "accidentCategoryId=" + accidentCategoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
