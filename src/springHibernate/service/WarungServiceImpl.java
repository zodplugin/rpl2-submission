package springHibernate.service;
import springHibernate.model.Warung;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springHibernate.dao.WarungDao;
/**
 *
 * @author RizkyBagaskara
 */
@Service("MahasiswaService")
@Transactional(readOnly = true)
public class WarungServiceImpl implements WarungService{
    @Autowired
    private WarungDao mahasiswaDao;
    
    @Transactional
    @Override
    public void save(Warung mahasiswa){
        mahasiswaDao.save(mahasiswa);
    }
    
    @Transactional
    @Override
    public void update(Warung mahasiswa){
        mahasiswaDao.update(mahasiswa);
    }
    
    @Transactional
    @Override
    public void delete(Warung mahasiswa){
        mahasiswaDao.delete(mahasiswa);
    }
    
    @Transactional
    @Override
    public Warung getMahasiswa(String npm){
        return mahasiswaDao.getMahasiswa(npm);
    }
    
    @Transactional
    @Override
    public List<Warung> getMahasiswas(){
        return mahasiswaDao.getMahasiswas();
    }
}
