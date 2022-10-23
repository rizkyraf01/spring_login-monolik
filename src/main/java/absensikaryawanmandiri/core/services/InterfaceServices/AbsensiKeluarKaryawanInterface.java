package absensikaryawanmandiri.core.services.InterfaceServices;

import absensikaryawanmandiri.core.models.entity.absensi_karyawan;
import absensikaryawanmandiri.core.models.entity.absensikeluar_karyawan;

public interface AbsensiKeluarKaryawanInterface {
    Iterable<absensikeluar_karyawan> findAll();

    absensikeluar_karyawan addAbsensiKeluar(absensikeluar_karyawan addabsensikeluar);

    public boolean checkNipAbsen(Integer nip);

    boolean checkNip(Integer nip);

}
