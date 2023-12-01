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
    private WarungTableModel mahasiswaTableModel;
    private List<Warung> mahasiswas;
    
    public WarungController(WarungView mahasiswaView){
        this.warungView = mahasiswaView;
    }
    
    public void tampilData() {
        mahasiswas = App.getMahasiswaService().getMahasiswas();
        mahasiswaTableModel = new WarungTableModel(mahasiswas);
        this.warungView.getTabel().setModel(mahasiswaTableModel);
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
     
     public void saveMahasiswa () {
        Warung warung = new Warung();
        warung.setNpm(this.warungView.getIdBarang().getText());
        warung.setNama(this.warungView.getNamaBarang().getText());
        warung.setKelas(this.warungView.getHargaBarang().getText());
        warung.setAlamat(this.warungView.getStokBarang().getText());
        App.getMahasiswaService().save(warung);
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "info", JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
     
    public void updateMahasiswa(){
        Warung warung = new Warung();
        warung.setNpm(this.warungView.getIdBarang().getText());
        warung.setNama(this.warungView.getNamaBarang().getText());
        warung.setKelas(this.warungView.getHargaBarang().getText());
        warung.setAlamat(this.warungView.getStokBarang().getText());
        App.getMahasiswaService().update(warung);
        JOptionPane.showMessageDialog(null, "Data berhasil diedit", "info", JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
    
    public void deleteMahasiswa(){
        if(this.warungView.getNpm().getText() == null){
            JOptionPane.showMessageDialog(null, "Mahasiswa belum dipilih", "error", JOptionPane.ERROR_MESSAGE);
        }else{
            Warung mahasiswa = new Warung();
            mahasiswa.setNpm(this.warungView.getNpm().getText());
            int pilih = JOptionPane.showConfirmDialog(null, "Apakah data ingin dihapus?", "Warning", JOptionPane.YES_NO_OPTION);
            if(pilih == JOptionPane.YES_OPTION){
                App.getMahasiswaService().delete(mahasiswa);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "info", JOptionPane.INFORMATION_MESSAGE);
                clear();
                tampilData();
            }
        }
    }
}
