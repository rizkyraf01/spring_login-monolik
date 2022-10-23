package absensikaryawanmandiri.core.services;

import absensikaryawanmandiri.core.models.entity.absensi_karyawan;
import absensikaryawanmandiri.core.models.entity.izin_karyawan;
import absensikaryawanmandiri.core.models.repository.IzinKaryawanRepository;
import absensikaryawanmandiri.core.services.InterfaceServices.IzinKaryawanServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IzinKaryawanServices implements IzinKaryawanServicesInterface {

    @Autowired
    private IzinKaryawanRepository izinKaryawanRepository;

    @Override
    public Iterable<izin_karyawan> findAll(){
        return izinKaryawanRepository.findAll();
    }

    @Override
    public izin_karyawan addIzin(izin_karyawan izinkaryawan){
        izinKaryawanRepository.save(izinkaryawan);
        return izinkaryawan;
    }

    @Override
    public boolean checkNip(Integer nip){
        return izinKaryawanRepository.existsByNip(nip);
    }
}
