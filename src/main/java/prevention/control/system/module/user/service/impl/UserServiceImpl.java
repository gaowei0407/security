package prevention.control.system.module.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import prevention.control.system.common.publicEntity.Pagination;
import prevention.control.system.module.user.dao.UserMapper;
import prevention.control.system.module.user.entity.User;
import prevention.control.system.module.user.service.UserService;
import java.util.List;

/**
 * Created by 董振 on 2018/1/11.
 */
@Service("userServiceImpl")
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {

    @Autowired
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
}
