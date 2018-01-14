package prevention.control.system.module.accident.entity;

/**
 *
 * 事故调查报告
 */
public class accidentInvestigationReport {

    //事故调查报告id
    private long accidentInvestigationReportId;


    //事故id
    private long accidentId;

    //事故调查报告内容
    private String content;

    public long getAccidentInvestigationReportId() {
        return accidentInvestigationReportId;
    }

    public void setAccidentInvestigationReportId(long accidentInvestigationReportId) {
        this.accidentInvestigationReportId = accidentInvestigationReportId;
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
        return "accidentInvestigationReport{" +
                "accidentInvestigationReportId=" + accidentInvestigationReportId +
                ", accidentId=" + accidentId +
                ", content='" + content + '\'' +
                '}';
    }
}
