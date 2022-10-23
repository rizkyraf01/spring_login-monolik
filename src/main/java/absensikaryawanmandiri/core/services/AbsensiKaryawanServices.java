package absensikaryawanmandiri.core.services;

import absensikaryawanmandiri.core.models.entity.absensi_karyawan;
import absensikaryawanmandiri.core.models.repository.AbsensiKaryawanRepository;
import absensikaryawanmandiri.core.models.repository.DaftarKaryawanRepository;
import absensikaryawanmandiri.core.services.InterfaceServices.AbsensiKaryawanServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AbsensiKaryawanServices implements AbsensiKaryawanServicesInterface {

    @Autowired
    private AbsensiKaryawanRepository absensiKaryawanRepository;

    @Autowired
    private DaftarKaryawanRepository daftarKaryawanRepository;

    //    private DaftarKaryawanServices daftarKaryawanServices;
    ///coba ini bener////
    @Override
    public Iterable<absensi_karyawan> findAll(){
        return absensiKaryawanRepository.findAll();
    }

    @Override
    public absensi_karyawan addAbsensi(absensi_karyawan addabsensi){
        absensiKaryawanRepository.save(addabsensi);
        return addabsensi;
    }

    @Override
    public boolean checkNip(Integer nip){
        return daftarKaryawanRepository.existsByNip(nip);
    }

    @Override
    public boolean checkNipAbsen(Integer nip) {
        return absensiKaryawanRepository.existsByNip(nip);
    }

    @Override
    public int countAllAbsen(){
        return absensiKaryawanRepository.countAllAbsen();
    }
}
