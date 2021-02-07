import com.study.service.Person;
import com.study.dao.User;
import com.study.service.UserBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class Test {
   @org.junit.Test
    public void test01(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring/spring-service.xml");
        Person person= ac.getBean(Person.class);
        System.out.println(person.toString());
    }

   // @org.junit.Test
//    public void test02() throws IOException {
//        String source = "mybatis/batis.xml";
//        // 获取资源
//        InputStream is = Resources.getResourceAsStream(source);
//        // 获取Session会话工厂
//
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//
//        // 获取Session会话
//        SqlSession session = factory.openSession();
//
//        User user =session.getMapper(User.class);
//        UserBean userBean=user.getUserBean(9);
//        System.out.println(userBean);
//        }
}
