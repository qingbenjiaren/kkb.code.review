package spring;

import com.melo.pojo.Course;
import com.melo.pojo.Student;
import com.melo.spring.reviewbean.factory.support.DefaultListableBeanFactory;
import com.melo.spring.reviewbean.resource.ClasspathResource;
import com.melo.spring.reviewbean.resource.Resource;
import com.melo.spring.reviewbean.utils.ReflectUtils;
import com.melo.spring.reviewbean.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.io.InputStream;

public class JunitTest {
    @Test
    public void test(){
        String location = "beans.xml";

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();


        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        // 将资源抽象为一个接口，通过该接口，可以获取不同地方（网络、文件系统、classpath）的资源
        Resource resource = new ClasspathResource(location);
        InputStream inputStream = resource.getResource();
        beanDefinitionReader.loadBeanDefinitions(inputStream);
        Student student = (Student) beanFactory.getBean("student");
        System.out.println(student);
    }

    @Test
    public void testReflectUtils() throws ClassNotFoundException {
        Student user = (Student) ReflectUtils.createObject(Class.forName("com.melo.pojo.Student"),"112",new Course("asda",123),"000");
        System.out.println(user);

    }
    @Test
    public void test11(){
        Object[] var;
        if(1 == 1){
            var = new Object[4];
        }else{
            var = new Object[2];
        }
        for(int i = 0;i<var.length;i++){
            var[i] = "123123";
        }
        test1(var);
    }

    public void test1(Object ... args){
        for(Object obj : args){
            System.out.println(obj);
        }
    }
}
