package springHibernate.dao;
import springHibernate.model.Warung;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author RizkyBagaskara
 */
@Repository
public class WarungDaoImpl implements WarungDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Warung warung) {
        sessionFactory.getCurrentSession().save(warung);
    }
    
    @Override
    public void update(Warung warung) {
        sessionFactory.getCurrentSession().update(warung);
    }
    
    @Override
    public void delete(Warung warung) {
        sessionFactory.getCurrentSession().delete(warung);
    }
    
    @Override
    public Warung getWarung(String idbarang){
        return (Warung) sessionFactory.getCurrentSession().get(Warung.class, idbarang);
    }
    
    @Override
    public List<Warung> getWarungs(){
        return sessionFactory.getCurrentSession().createCriteria(Warung.class).list();
    }
}