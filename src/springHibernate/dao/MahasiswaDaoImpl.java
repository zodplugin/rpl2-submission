package springHibernate.dao;
import springHibernate.model.Mahasiswa;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author RizkyBagaskara
 */
@Repository
public class MahasiswaDaoImpl implements MahasiswaDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Mahasiswa mahasiswa) {
        sessionFactory.getCurrentSession().save(mahasiswa);
    }
    
    @Override
    public void update(Mahasiswa mahasiswa) {
        sessionFactory.getCurrentSession().update(mahasiswa);
    }
    
    @Override
    public void delete(Mahasiswa mahasiswa) {
        sessionFactory.getCurrentSession().delete(mahasiswa);
    }
    
    @Override
    public Mahasiswa getMahasiswa(String npm){
        return (Mahasiswa) sessionFactory.getCurrentSession().get(Mahasiswa.class, npm);
    }
    
    @Override
    public List<Mahasiswa> getMahasiswas(){
        return sessionFactory.getCurrentSession().createCriteria(Mahasiswa.class).list();
    }
}