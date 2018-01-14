package prevention.control.system.module.accident.entity;

/**
 *
 * 原因规律统计
 */
public class statisticsOfReasons {

    //原因规律统计id
    private  long statisticsOfReasonsId;

    //事故id
    private  long accidentId;

    //原因规律统计内容
    private String content;

    public long getStatisticsOfReasonsId() {
        return statisticsOfReasonsId;
    }

    public void setStatisticsOfReasonsId(long statisticsOfReasonsId) {
        this.statisticsOfReasonsId = statisticsOfReasonsId;
    }

    public long getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(long accidentId) {
        this.accidentId = accidentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "statisticsOfReasons{" +
                "statisticsOfReasonsId=" + statisticsOfReasonsId +
                ", accidentId=" + accidentId +
                ", content='" + content + '\'' +
                '}';
    }
}
