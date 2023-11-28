package springHibernate;

import springHibernate.service.MahasiswaService;
import springHibernate.view.MahasiswaView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author RizkyBagaskara
 */
public class App {
 private static ApplicationContext applicationContext;
    
    public static void main(String[] args) {
      applicationContext = new ClassPathXmlApplicationContext("classpath:spring-configuration.xml");
      new MahasiswaView().setVisible(true);
    }
    
    public static MahasiswaService getMahasiswaService(){
        return (MahasiswaService) applicationContext.getBean("MahasiswaService");
    }
}
