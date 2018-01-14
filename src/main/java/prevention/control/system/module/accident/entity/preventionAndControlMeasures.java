package prevention.control.system.module.accident.entity;

/**
 *
 * 事故预防措施
 */
public class preventionAndControlMeasures {

    //事故预防措施id
    private long preventionAndControlMeasuresId;

    //事故id
    private  long accidentId;

    //预防措施内容
    private String content;

    public long getPreventionAndControlMeasuresId() {
        return preventionAndControlMeasuresId;
    }

    public void setPreventionAndControlMeasuresId(long preventionAndControlMeasuresId) {
        this.preventionAndControlMeasuresId = preventionAndControlMeasuresId;
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
        return "preventionAndControlMeasures{" +
                "preventionAndControlMeasuresId=" + preventionAndControlMeasuresId +
                ", accidentId=" + accidentId +
                ", content='" + content + '\'' +
                '}';
    }
}
