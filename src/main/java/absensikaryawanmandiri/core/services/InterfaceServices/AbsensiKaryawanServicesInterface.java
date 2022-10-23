package absensikaryawanmandiri.core.services.InterfaceServices;

import absensikaryawanmandiri.core.models.entity.absensi_karyawan;

public interface AbsensiKaryawanServicesInterface {

    Iterable<absensi_karyawan> findAll();

    absensi_karyawan addAbsensi(absensi_karyawan addabsensi);

    public boolean checkNipAbsen(Integer nip);

    boolean checkNip(Integer nip);

    int countAllAbsen();

}
