package absensikaryawanmandiri.core.services.InterfaceServices;

import absensikaryawanmandiri.core.models.entity.daftar_karyawan;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DaftarKaryawanServicesInterface {

    Iterable<daftar_karyawan> findAll();

    daftar_karyawan addKaryawan(daftar_karyawan addkaryawan);

    void deleteKaryawanById(Long id);

    Optional<daftar_karyawan> karyawanFindById(long nip);

    void updateKaryawan(daftar_karyawan updateKaryawan);

    public boolean checkNip(Integer nip);

    int countAllKaryawan();
}
