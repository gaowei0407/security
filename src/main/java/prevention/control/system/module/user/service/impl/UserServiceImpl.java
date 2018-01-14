package prevention.control.system.module.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import prevention.control.system.common.publicEntity.Pagination;
import prevention.control.system.module.user.dao.UserMapper;
import prevention.control.system.module.user.entity.User;
import prevention.control.system.module.user.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 董振 on 2018/1/11.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public User queryUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public Pagination<User> queryAllUser(int pageSize, int pageNo) {
        // 处理分页
        PageHelper.startPage(pageNo, pageSize);
        List<User> users = userMapper.selectAllUser();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return new Pagination<User>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public boolean updateUserInfo(Integer userId, String userName, String password) {
        int update = userMapper.updateUserInfo(userId, userName, password);
        if (update == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean registerUserInfo(String userName, String password) {
        int register = userMapper.registerUserInfo(userName, password);
        if (register == 1) {
            return true;
        }
        return false;
    }
}
