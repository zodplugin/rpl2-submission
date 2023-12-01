package springHibernate.configuration;
import springHibernate.model.Warung;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author RizkyBagaskara
 */
public class WarungTableModel extends AbstractTableModel{
    private List<Warung> mahasiswas = new ArrayList<>();
    private final String HEADER[] = {"IdBarang", "Nama", "Kelas", "Alamat"};
    
    public WarungTableModel(List<Warung> mahasiswas){
        this.mahasiswas = mahasiswas;
    }
    
    @Override
    public int getRowCount(){
        return mahasiswas.size();
    }
    
    @Override
    public int getColumnCount(){
        return HEADER.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return HEADER[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Warung mahasiswa = mahasiswas.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return mahasiswa.getNpm();
            case 1:
                return mahasiswa.getNama();
            case 2:
                return mahasiswa.getKelas();
            case 3:
                return mahasiswa.getAlamat();
            default:
                return null;
        }
    }
}
