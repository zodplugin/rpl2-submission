package springHibernate;

import springHibernate.view.WarungView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springHibernate.service.WarungService;
/**
 *
 * @author RizkyBagaskara
 */
public class App {
 private static ApplicationContext applicationContext;
    
    public static void main(String[] args) {
      applicationContext = new ClassPathXmlApplicationContext("classpath:spring-configuration.xml");
      new WarungView().setVisible(true);
    }
    
    public static WarungService getWarungService(){
        return (WarungService) applicationContext.getBean("WarungService");
    }
}
