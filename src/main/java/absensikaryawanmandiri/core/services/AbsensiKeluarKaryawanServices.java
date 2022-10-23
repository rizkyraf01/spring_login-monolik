package absensikaryawanmandiri.core.services;

import absensikaryawanmandiri.core.models.entity.absensi_karyawan;
import absensikaryawanmandiri.core.models.entity.absensikeluar_karyawan;
import absensikaryawanmandiri.core.models.repository.AbsensiKeluarKaryawanRepository;
import absensikaryawanmandiri.core.models.repository.DaftarKaryawanRepository;
import absensikaryawanmandiri.core.services.InterfaceServices.AbsensiKeluarKaryawanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AbsensiKeluarKaryawanServices implements AbsensiKeluarKaryawanInterface {

    @Autowired
    private AbsensiKeluarKaryawanRepository absensiKeluarKaryawanRepository;

    @Autowired
    private DaftarKaryawanRepository daftarKaryawanRepository;


    @Override
    public Iterable<absensikeluar_karyawan> findAll(){
        return absensiKeluarKaryawanRepository.findAll();
    }

    @Override
    public absensikeluar_karyawan addAbsensiKeluar(absensikeluar_karyawan addabsensikeluar) {
        absensiKeluarKaryawanRepository.save(addabsensikeluar);
        return addabsensikeluar;
    }

    @Override
    public boolean checkNip(Integer nip){
        return daftarKaryawanRepository.existsByNip(nip);
    }

    @Override
    public boolean checkNipAbsen(Integer nip) {
        return absensiKeluarKaryawanRepository.existsByNip(nip);
    }
}
