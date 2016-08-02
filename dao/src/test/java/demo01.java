import com.ytud.dao.mybatis.po.Project;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * yangch 2016/7/27
 */
public class demo01 {
    public static void main(String[] args) {
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = demo01.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        String statement = "com.ytud.dao.mybatis.mapper.ProjectMapper.getProject";
        int del = session.delete(statement);
        System.out.println(del);
        Project project = session.selectOne(statement, 2);
        System.out.println(project.getProjectName());
    }
}
