package absensikaryawanmandiri.core.services;


import absensikaryawanmandiri.core.models.entity.daftar_karyawan;
import absensikaryawanmandiri.core.models.repository.DaftarKaryawanRepository;
import absensikaryawanmandiri.core.services.InterfaceServices.DaftarKaryawanServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DaftarKaryawanServices implements DaftarKaryawanServicesInterface {

    @Autowired
    private DaftarKaryawanRepository repositoryDaftar;

    @Override
    public List<daftar_karyawan> findAll(){
        return repositoryDaftar.findAll();
    }

    @Override
    public daftar_karyawan addKaryawan(daftar_karyawan addkaryawan){
        repositoryDaftar.save(addkaryawan);
        return addkaryawan;
    }

    @Override
    public void deleteKaryawanById(Long id){
        repositoryDaftar.deleteById(id);
    }

    @Override
    public Optional<daftar_karyawan> karyawanFindById(long nip){
        return repositoryDaftar.findById(nip);
    }

    @Override
    public void updateKaryawan(daftar_karyawan updateKaryawan){
        repositoryDaftar.save(updateKaryawan);
    }

    @Override
    public boolean checkNip(Integer nip) {
        return repositoryDaftar.existsByNip(nip);
    }

    @Override
    public int countAllKaryawan(){
        return repositoryDaftar.countAllKrywn();
    }


//    public boolean checkNip(String nip){
//         return repositoryDaftar.existNip(nip);
//     }
}
