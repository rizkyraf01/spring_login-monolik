package absensikaryawanmandiri.core.models.repository;

import absensikaryawanmandiri.core.models.entity.izin_karyawan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IzinKaryawanRepository extends CrudRepository<izin_karyawan, Long> {

    @Query(value = "select count(*) from tbl_izin", nativeQuery=true)
    int countAllIzin();

    public boolean existsByNip(Integer nip);
}
