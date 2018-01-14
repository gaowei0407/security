package prevention.control.system.module.accident.entity;


/**
 * 事故宏观规律
 */
public class macroscopicLawOfAccident {

    //事故宏观规律id
    private  long macroscopicLawOfAccidentId;

    //事故id
    private  long accidentId;

    //事故宏观规律内容
    private  String content;

    public long getMacroscopicLawOfAccidentId() {
        return macroscopicLawOfAccidentId;
    }

    public void setMacroscopicLawOfAccidentId(long macroscopicLawOfAccidentId) {
        this.macroscopicLawOfAccidentId = macroscopicLawOfAccidentId;
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
        return "macroscopicLawOfAccident{" +
                "macroscopicLawOfAccidentId=" + macroscopicLawOfAccidentId +
                ", accidentId=" + accidentId +
                ", content='" + content + '\'' +
                '}';
    }
}
