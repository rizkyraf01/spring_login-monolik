package absensikaryawanmandiri.core.models.repository;

import absensikaryawanmandiri.core.models.entity.absensi_karyawan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AbsensiKaryawanRepository extends CrudRepository<absensi_karyawan, Long> {
    @Query(value = "select count(*) from tbl_absen_karyawan", nativeQuery=true)
    int countAllAbsen();

    public boolean existsByNip(Integer nip);
}
