package spring;

import com.melo.pojo.Student;
import com.melo.spring.bean.factory.support.DefaultListableBeanFactory;
import com.melo.spring.bean.resource.ClasspathResource;
import com.melo.spring.bean.resource.Resource;
import com.melo.spring.bean.xml.XmlBeanDefinitionReader;
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
}
