package springHibernate.dao;
import springHibernate.model.Warung;
import java.util.List;
/**
 *
 * @author RizkyBagaskara
 */
public interface WarungDao {
    public void save(Warung warung);
    public void update(Warung warung);
    public void delete(Warung warung);
    public Warung getWarung(String idbarang);
    public List<Warung> getWarungs();
}
