package user;

import com.newer.domain.User;
import com.newer.mapper.UserMapper;
import com.newer.service.UserService;
import com.newer.util.MD5Utils;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class Usertest {
    @Test
    public void test(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("jack");
        user.setPassword(MD5Utils.MD5Encode("111111","utf8"));
        System.out.println(MD5Utils.MD5Encode("111111","utf8"));
        User usertest = userMapper.selectByUserPass(user);
        System.out.println(usertest.getEmail());
        SqlSessionUtil.close(sqlSession);
    }
}
