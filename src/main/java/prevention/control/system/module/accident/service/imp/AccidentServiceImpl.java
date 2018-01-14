package prevention.control.system.module.accident.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import prevention.control.system.module.accident.dao.AccidentMapper;
import prevention.control.system.module.accident.entity.Accident;
import prevention.control.system.module.accident.entity.AccidentCategory;
import prevention.control.system.module.accident.service.AccidentService;
import prevention.control.system.common.publicEntity.Pagination;
import prevention.control.system.module.user.entity.User;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 王亚豪 on 2018/1/14.
 */
@Service
public class AccidentServiceImpl implements AccidentService {

    @Resource
    private AccidentMapper accidentMapper;


    @Override
    public List<AccidentCategory> queryAllaccidentcategory() {
        List<AccidentCategory> selectcategoryname = accidentMapper.selectCategoryName();
        System.out.println("selectcategoryname"+selectcategoryname.toString());
        return selectcategoryname;
    }

    @Override
    public Pagination<Accident> queryAllAccident(int pageSize,int pageNo) {
        // 处理分页
        PageHelper.startPage(pageNo, pageSize);
        List<Accident> accidents = accidentMapper.selectAllAccident();
        PageInfo<Accident> pageInfo = new PageInfo<Accident>(accidents);
        return new Pagination<Accident>(pageInfo.getTotal(), pageInfo.getList());
        //return null;
    }

    @Override
    public Pagination<Accident> selectAccidentByName(int pageSize, int pageNo, String accidentName) {
        // 处理分页
        PageHelper.startPage(pageNo, pageSize);
        List<Accident> accidents = accidentMapper.selectAccidentByName(accidentName);
        PageInfo<Accident> pageInfo = new PageInfo<Accident>(accidents);
        return new Pagination<Accident>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public int addAccident(Map<String, Object> map) throws ParseException {
        String occurrencePlace=map.get("occurrencePlace").toString();//发生地点
        String accidentName= map.get("accidentName").toString();//事故名称

        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        Date occurrenceTime =format.parse(map.get("occurrenceTime").toString());//发生时间
        int isAnalysis= Integer.parseInt(map.get("isAnalysis").toString());//是否完成分析
        int userId=Integer.parseInt(map.get("userId").toString());//用户id
        int accidentCategoryId=Integer.parseInt(map.get("accidentCategoryId").toString());//事故类别id
        accidentMapper.insertAccident(accidentName,occurrencePlace,occurrenceTime,isAnalysis,userId,accidentCategoryId);
        return 0;
    }
}
