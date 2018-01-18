package prevention.control.system.module.user.service;

import prevention.control.system.common.publicEntity.Pagination;
import prevention.control.system.module.user.entity.User;

/**
 * Created by 董振 on 2018/1/11.
 */
public interface UserService {
    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    User queryUserById(Integer userId);

    /**
     * 查询所有的用户
     * @return
     */
    Pagination<User> queryAllUser(int pageSize, int pageNo);

    /**
     * 查询所有的用户
     * @return
     */
    boolean updateUserInfo(Integer userId, String userName, String password);

    /**
     * 注册用户信息
     * @return
     */
    boolean registerUserInfo( String userName, String password);

    /**
     * 根据用户名和密码查询用户名字是否存在
     * @return
     */
    User queryUserInfoByIdAndPwd(String userName, String password);
}
