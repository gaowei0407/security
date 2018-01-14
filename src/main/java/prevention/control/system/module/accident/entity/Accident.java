package prevention.control.system.module.accident.entity;

import java.util.Date;

/**
 *
 * 事故详细信息
 */
public class Accident {
    //事故id
    private  long accidentId;
    //事故名称
    private String accidentName;

    //事故发生地点
    private  String occurrencePlace;

    //事故发生时间
    private Date occurrenceTime;

    //是否完成分析
    private  long isAnalysis;

    //创建用户id
    private  long userId;

    //事故类别id
    private long accidentCategoryId;

    public long getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(long accidentId) {
        this.accidentId = accidentId;
    }

    public String getAccidentName() {
        return accidentName;
    }

    public void setAccidentName(String accidentName) {
        this.accidentName = accidentName;
    }

    public String getOccurrencePlace() {
        return occurrencePlace;
    }

    public void setOccurrencePlace(String occurrencePlace) {
        this.occurrencePlace = occurrencePlace;
    }

    public Date getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Date occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public long getIsAnalysis() {
        return isAnalysis;
    }

    public void setIsAnalysis(long isAnalysis) {
        this.isAnalysis = isAnalysis;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAccidentCategoryId() {
        return accidentCategoryId;
    }

    public void setAccidentCategoryId(long accidentCategoryId) {
        this.accidentCategoryId = accidentCategoryId;
    }

    @Override
    public String toString() {
        return "Accident{" +
                "accidentId=" + accidentId +
                ", accidentName='" + accidentName + '\'' +
                ", occurrencePlace='" + occurrencePlace + '\'' +
                ", occurrenceTime=" + occurrenceTime +
                ", isAnalysis=" + isAnalysis +
                ", userId=" + userId +
                ", accidentCategoryId=" + accidentCategoryId +
                '}';
    }
}
