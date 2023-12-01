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
    private List<Warung> warungs = new ArrayList<>();
    private final String HEADER[] = {"IdBarang", "NamaBarang", "HargaBarang", "StokBarang"};
    
    public WarungTableModel(List<Warung> warungs){
        this.warungs = warungs;
    }
    
    @Override
    public int getRowCount(){
        return warungs.size();
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
        Warung warung = warungs.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return warung.getIdBarang();
            case 1:
                return warung.getNamaBarang();
            case 2:
                return warung.getHargaBarang();
            case 3:
                return warung.getStokBarang();
            default:
                return null;
        }
    }
}
