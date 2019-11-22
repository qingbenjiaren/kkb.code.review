package mybatis;

import com.github.pagehelper.PageHelper;
import com.melo.mybatis.mapper.UserMapper;
import com.melo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class JunitTest {
    @Test
    public void mapperTest() throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis_config.xml"));
        SqlSession session = factory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        //User user = mapper.selectOneById(12);
        PageHelper.startPage(3,5);
        List<User> userList = mapper.selectAll();
        userList.forEach(System.out :: println);
    }
}
