package absensikaryawanmandiri.core.models.repository;

import absensikaryawanmandiri.core.models.entity.daftar_karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DaftarKaryawanRepository extends JpaRepository<daftar_karyawan, Long> {
//    public boolean existNip(String nip);
    @Query(value = "select count(*) from tbl_karyawan", nativeQuery=true)
    int countAllKrywn();

    public boolean existsByNip(Integer nip);

}
