package springHibernate.controller;
import springHibernate.App;
import springHibernate.configuration.WarungTableModel;
import springHibernate.model.Warung;
import java.util.List;
import javax.swing.JOptionPane;
import springHibernate.view.WarungView;
/**
 *
 * @author RizkyBagaskara
 */
public class WarungController {
    private final WarungView warungView;
    private WarungTableModel warungTableModel;
    private List<Warung> warungs;
    
    public WarungController(WarungView mahasiswaView){
        this.warungView = mahasiswaView;
    }
    
    public void tampilData() {
        warungs = App.getWarungService().getWarungs();
        warungTableModel = new WarungTableModel(warungs);
        this.warungView.getTabel().setModel(warungTableModel);
    }
    
    public void show() {
        int index = this.warungView.getTabel().getSelectedRow();

        this.warungView.getIdBarang().setText(String.valueOf(this.warungView.getTabel().getValueAt(index, 0)));
        this.warungView.getNamaBarang().setText(String.valueOf(this.warungView.getTabel().getValueAt(index, 1)));
        this.warungView.getHargaBarang().setText(String.valueOf(this.warungView.getTabel().getValueAt(index, 2)));
        this.warungView.getStokBarang().setText(String.valueOf(this.warungView.getTabel().getValueAt(index, 3)));
    }
    
     public void clear() {
        this.warungView.getIdBarang().setText("");
        this.warungView.getNamaBarang().setText("");
        this.warungView.getHargaBarang().setText("");
        this.warungView.getStokBarang().setText("");
    }
     
     public void saveBarang () {
        Warung warung = new Warung();
        warung.setIdBarang(this.warungView.getIdBarang().getText());
        warung.setNamaBarang(this.warungView.getNamaBarang().getText());
        warung.setHargaBarang(Integer.parseInt(this.warungView.getHargaBarang().getText()));
        warung.setStokBarang(Integer.parseInt(this.warungView.getStokBarang().getText()));
        App.getWarungService().save(warung);
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "info", JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
     
    public void updateBarang(){
        Warung warung = new Warung();
        warung.setIdBarang(this.warungView.getIdBarang().getText());
        warung.setNamaBarang(this.warungView.getNamaBarang().getText());
        warung.setHargaBarang(Integer.parseInt(this.warungView.getHargaBarang().getText()));
        warung.setStokBarang(Integer.parseInt(this.warungView.getStokBarang().getText()));
        App.getWarungService().update(warung);
        JOptionPane.showMessageDialog(null, "Data berhasil diedit", "info", JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
    
    public void deleteBarang(){
        if(this.warungView.getIdBarang().getText() == null){
            JOptionPane.showMessageDialog(null, "Barang belum dipilih", "error", JOptionPane.ERROR_MESSAGE);
        }else{
            Warung warung = new Warung();
            warung.setIdBarang(this.warungView.getIdBarang().getText());
            int pilih = JOptionPane.showConfirmDialog(null, "Apakah data ingin dihapus?", "Warning", JOptionPane.YES_NO_OPTION);
            if(pilih == JOptionPane.YES_OPTION){
                App.getWarungService().delete(warung);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "info", JOptionPane.INFORMATION_MESSAGE);
                clear();
                tampilData();
            }
        }
    }
}
