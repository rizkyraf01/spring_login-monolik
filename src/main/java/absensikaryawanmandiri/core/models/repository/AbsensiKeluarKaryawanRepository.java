package absensikaryawanmandiri.core.models.repository;

import absensikaryawanmandiri.core.models.entity.absensikeluar_karyawan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsensiKeluarKaryawanRepository extends JpaRepository<absensikeluar_karyawan, Long> {

    public boolean existsByNip(Integer nip);
}
