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
@Service("WarungService")
@Transactional(readOnly = true)
public class WarungServiceImpl implements WarungService{
    @Autowired
    private WarungDao warungDao;
    
    @Transactional
    @Override
    public void save(Warung warung){
        warungDao.save(warung);
    }
    
    @Transactional
    @Override
    public void update(Warung warung){
        warungDao.update(warung);
    }
    
    @Transactional
    @Override
    public void delete(Warung warung){
        warungDao.delete(warung);
    }
    
    @Transactional
    @Override
    public Warung getWarung(String idbarang){
        return warungDao.getWarung(idbarang);
    }
    
    @Transactional
    @Override
    public List<Warung> getWarungs(){
        return warungDao.getWarungs();
    }
}
