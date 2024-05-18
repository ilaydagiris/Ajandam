package com.example.ajandam.Entity;
import javax.persistence.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
//import java.time.LocalDateTime;

@Entity
@Table (name = "Ajanda_Entity")
public class AjandaEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long etkinlikID;
    @Column(name = "EtkinlikTuru") // iş m, d.günü mü
    private String etkinlikTuru;
    @Column(name = "EtkinlikBasligi")
    private String etkinlikBasligi;
    @Column(name = "EtkinlikIcerigi")
    private String etkinlikIcerigi;
    @Column(name = "EtkinlikTarihi")
    private SimpleDateFormat etkinlikTarihi;
    @Column(name = "EtkinlikSaati")
    private Time etkinlikSaati;
    @Column(name = "EtkinlikAni")
    private LocalDateTime etkinlikAni;

    public AjandaEntity(){}

    public AjandaEntity(long etkinilkID, String etkinlikTuru, String etkinlikBasligi, String etkinlikIcerigi,
                        SimpleDateFormat etkinlikTarihi, Time etkinlikSaati, LocalDateTime etkinlikAni){
        this.etkinlikID = etkinilkID;
        this.etkinlikTuru = etkinlikTuru;
        this.etkinlikBasligi = etkinlikBasligi;
        this.etkinlikIcerigi = etkinlikIcerigi;
        this.etkinlikTarihi = etkinlikTarihi;
        this.etkinlikSaati = etkinlikSaati;
        this.etkinlikAni = etkinlikAni;
    }

    public long getEtkinlikID() { return etkinlikID; }
    public void setEtkinlikID(long etkinlikID) { this.etkinlikID = etkinlikID; }
    public String getEtkinlikTuru() { return etkinlikTuru; }
    public void setEtkinlikTuru(String etkinlikTuru) { this.etkinlikTuru = etkinlikTuru; }
    public String getEtkinlikBasligi() { return etkinlikBasligi; }
    public void setEtkinlikBasligi(String etkinlikBasligi) { this.etkinlikBasligi = etkinlikBasligi; }
    public String getEtkinlikIcerigi() { return etkinlikIcerigi; }
    public void setEtkinlikIcerigi(String etkinlikIcerigi) { this.etkinlikIcerigi = etkinlikIcerigi; }
    public SimpleDateFormat getEtkinlikTarihi() { return etkinlikTarihi; }
    public void setEtkinlikTarihi(SimpleDateFormat etkinlikTarihi) { this.etkinlikTarihi = etkinlikTarihi; }
    public Time getEtkinlikSaati() { return etkinlikSaati; }
    public void setEtkinlikSaati(Time etkinlikSaati) { this.etkinlikSaati = etkinlikSaati; }
    public LocalDateTime getEtkinlikAni() { return etkinlikAni; }
    public void setEtkinlikAni(LocalDateTime etkinlikAni) { this.etkinlikAni = etkinlikAni; }

}
