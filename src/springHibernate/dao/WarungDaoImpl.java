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
    public void save(Warung mahasiswa) {
        sessionFactory.getCurrentSession().save(mahasiswa);
    }
    
    @Override
    public void update(Warung mahasiswa) {
        sessionFactory.getCurrentSession().update(mahasiswa);
    }
    
    @Override
    public void delete(Warung mahasiswa) {
        sessionFactory.getCurrentSession().delete(mahasiswa);
    }
    
    @Override
    public Warung getMahasiswa(String npm){
        return (Warung) sessionFactory.getCurrentSession().get(Warung.class, npm);
    }
    
    @Override
    public List<Warung> getMahasiswas(){
        return sessionFactory.getCurrentSession().createCriteria(Warung.class).list();
    }
}