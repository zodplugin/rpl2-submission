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
    private final WarungView mahasiswaView;
    private WarungTableModel mahasiswaTableModel;
    private List<Warung> mahasiswas;
    
    public WarungController(WarungView mahasiswaView){
        this.mahasiswaView = mahasiswaView;
    }
    
    public void tampilData() {
        mahasiswas = App.getMahasiswaService().getMahasiswas();
        mahasiswaTableModel = new WarungTableModel(mahasiswas);
        this.mahasiswaView.getTabel().setModel(mahasiswaTableModel);
    }
    
    public void show() {
        int index = this.mahasiswaView.getTabel().getSelectedRow();

        this.mahasiswaView.getNpm().setText(String.valueOf(this.mahasiswaView.getTabel().getValueAt(index, 0)));
        this.mahasiswaView.getNama().setText(String.valueOf(this.mahasiswaView.getTabel().getValueAt(index, 1)));
        this.mahasiswaView.getKelas().setText(String.valueOf(this.mahasiswaView.getTabel().getValueAt(index, 2)));
        this.mahasiswaView.getAlamat().setText(String.valueOf(this.mahasiswaView.getTabel().getValueAt(index, 3)));
    }
    
     public void clear() {
        this.mahasiswaView.getNpm().setText("");
        this.mahasiswaView.getNama().setText("");
        this.mahasiswaView.getKelas().setText("");
        this.mahasiswaView.getAlamat().setText("");
    }
     
     public void saveMahasiswa () {
        Warung mahasiswa = new Warung();
        mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
        mahasiswa.setNama(this.mahasiswaView.getNama().getText());
        mahasiswa.setKelas(this.mahasiswaView.getKelas().getText());
        mahasiswa.setAlamat(this.mahasiswaView.getAlamat().getText());
        App.getMahasiswaService().save(mahasiswa);
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "info", JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
     
    public void updateMahasiswa(){
        Warung mahasiswa = new Warung();
        mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
        mahasiswa.setNama(this.mahasiswaView.getNama().getText());
        mahasiswa.setKelas(this.mahasiswaView.getKelas().getText());
        mahasiswa.setAlamat(this.mahasiswaView.getAlamat().getText());
        App.getMahasiswaService().update(mahasiswa);
        JOptionPane.showMessageDialog(null, "Data berhasil diedit", "info", JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
    
    public void deleteMahasiswa(){
        if(this.mahasiswaView.getNpm().getText() == null){
            JOptionPane.showMessageDialog(null, "Mahasiswa belum dipilih", "error", JOptionPane.ERROR_MESSAGE);
        }else{
            Warung mahasiswa = new Warung();
            mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
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
