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
@Table(name = "tb_warung_yadi")
public class Warung implements Serializable{
    @Id
    @Column(name = "id_barang", length = 5)
    private String idbarang;
    
    @Column(name = "nama_barang", length = 30)
    private String namabarang;
    
    @Column(name = "harga_barang", length = 10)
    private Integer hargabarang;
    
    @Column(name = "stok_barang", length = 3)
    private Integer stokbarang;
    
    public String getIdBarang() {return idbarang;}
    public void setIdBarang(String idbarang) {this.idbarang = idbarang;}
    
    public String getNamaBarang() {return namabarang;}
    public void setNamaBarang(String namabarang) {this.namabarang = namabarang;}
    
    public Integer getHargaBarang() {return hargabarang;}
    public void setHargaBarang(Integer hargabarang) {this.hargabarang = hargabarang;}
    
    public Integer getStokBarang() {return stokbarang;}
    public void setStokBarang(Integer stokbarang) {this.stokbarang = stokbarang;}
}
