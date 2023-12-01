package springHibernate.dao;
import springHibernate.model.Warung;
import java.util.List;
/**
 *
 * @author RizkyBagaskara
 */
public interface WarungDao {
    public void save(Warung mahasiswa);
    public void update(Warung mahasiswa);
    public void delete(Warung mahasiswa);
    public Warung getMahasiswa(String npm);
    public List<Warung> getMahasiswas();
}
