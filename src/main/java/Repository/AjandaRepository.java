package com.example.ajandam.Repository;

import com.example.ajandam.Entity.AjandaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

public interface AjandaRepository extends JpaRepository<AjandaEntity, Long> {

    List<AjandaEntity> findByEtkinlikTuru(String etkinlikTuru);

    List<AjandaEntity> findByEtkinlikBasligi(String etkinlikBasligi);

    List<AjandaEntity> findByEtkinlikTarihi(LocalDateTime etkinlikTarihi);

    List<AjandaEntity> findByEtkinlikTuruAndEtkinlikBasligi(String etkinlikTuru, String etkinlikBasligi);

    List<AjandaEntity> findByEtkinlikTuruAndEtkinlikTarihi(String etkinlikTuru, java.util.Date etkinlikTarihi);

    List<AjandaEntity> findByEtkinlikBasligiAndEtkinlikTarihi(String etkinlikBasligi, java.util.Date etkinlikTarihi);

    List<AjandaEntity> findByEtkinlikSaati(Time etkinlikSaati);
}
