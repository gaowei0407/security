package prevention.control.system.module.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import prevention.control.system.module.user.entity.User;

import java.util.List;

/**
 * Created by 董振 on 2018/1/11.
 */
@Repository
public interface UserMapper {
    /**
     * 根据用户Id查询用户信息
     * @param userId
     * @return
     */
    User selectUserById(@Param("userId") Integer userId);

    /**
     * 查询所有的用户信息
     * @return
     */
    List<User> selectAllUser();

    /**
     * 查询所有的用户信息
     * @return
     */
    int updateUserInfo(@Param("userId") Integer userId, @Param("userName") String userName, @Param("password") String password);

    /**
     * 注册用户信息
     * @return
     */
    int registerUserInfo( @Param("userName") String userName, @Param("password") String password);
}
