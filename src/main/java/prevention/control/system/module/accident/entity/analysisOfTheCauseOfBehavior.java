package prevention.control.system.module.accident.entity;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * 行为原因分析
 */
public class analysisOfTheCauseOfBehavior {

    //行为原因id
    private  long  analysisOfTheCauseOfBehaviorId;

    //事故id
    private  long accidentId;

    //行为原因内容
    private String content;

    public long getAnalysisOfTheCauseOfBehaviorId() {
        return analysisOfTheCauseOfBehaviorId;
    }

    public void setAnalysisOfTheCauseOfBehaviorId(long analysisOfTheCauseOfBehaviorId) {
        this.analysisOfTheCauseOfBehaviorId = analysisOfTheCauseOfBehaviorId;
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
        return "analysisOfTheCauseOfBehavior{" +
                "analysisOfTheCauseOfBehaviorId=" + analysisOfTheCauseOfBehaviorId +
                ", accidentId=" + accidentId +
                ", content='" + content + '\'' +
                '}';
    }
}
