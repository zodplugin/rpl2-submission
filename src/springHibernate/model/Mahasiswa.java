package springHibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author RizkyBagaskara
 */
@Entity
@Table(name = "tb_mahasiswa")
public class Mahasiswa implements Serializable{
    @Id
    @Column(name = "npm", length = 8)
    private String npm;
    
    @Column(name = "nama", length = 50)
    private String nama;
    
    @Column(name = "kelas", length = 10)
    private String kelas;
    
    @Column(name = "alamat", length = 100)
    private String alamat;
    
    public String getNpm() {return npm;}
    public void setNpm(String npm) {this.npm = npm;}
    
    public String getNama() {return nama;}
    public void setNama(String nama) {this.nama = nama;}
    
    public String getKelas() {return kelas;}
    public void setKelas(String kelas) {this.kelas = kelas;}
    
    public String getAlamat() {return alamat;}
    public void setAlamat(String alamat) {this.alamat = alamat;}
}
