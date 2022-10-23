package absensikaryawanmandiri.core.services.InterfaceServices;

import absensikaryawanmandiri.core.models.entity.izin_karyawan;

public interface IzinKaryawanServicesInterface {

    Iterable<izin_karyawan> findAll();

    izin_karyawan addIzin(izin_karyawan izinkaryawan);

    public boolean checkNip(Integer nip);
}
