package absensikaryawanmandiri.core.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
//@Data
@Entity
@Table(name = "tbl_karyawan")
public class daftar_karyawan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nip",length = 10, nullable = false, unique = true)
    private Integer nip;

    @Column(name = "nama",length = 100, nullable = false)
    private String nama;

    @Column(name="alamat",length = 200, nullable = false)
    private String alamat;

    @Column(name="jenis_kelamin",length = 50, nullable = false)
    private String jenis_kelamin;

    @Column(name="no_telp",nullable = false,length = 13)
    private String no_telp;

    @Column(name="email",length = 100, nullable = false)
    private String email;

    @Column(name="departement",length = 100, nullable = false)
    private String departement;

    @Column(name="jabatan",length = 100, nullable = false)
    private String jabatan;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_absensi")
    private List<absensi_karyawan> absensi_karyawans;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_hadir")
    private List<izin_karyawan> hadir_karyawans;

 ///////////////COBA NIP validation///////////
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    protected Long id;
//
//    @Column(name="nip",length = 10, nullable = false)
//    private Integer nip;
//
//    @Column(name = "nama",length = 100, nullable = false)
//    private String nama;
//
//    @Column(name="alamat",length = 200, nullable = false)
//    private String alamat;
//
//    @Column(name="jenis_kelamin",length = 50, nullable = false)
//    private String jenis_kelamin;
//
//    @Column(name="no_telp",nullable = false,length = 13)
//    private Integer no_telp;
//
//    @Column(name="email",length = 100, nullable = false)
//    private String email;
//
//    @Column(name="departement",length = 100, nullable = false)
//    private String departement;
//
//    @Column(name="jabatan",length = 100, nullable = false)
//    private String jabatan;
//
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name= "id_karyawan", referencedColumnName = "id")
//    private absensi_karyawan Absensi_Karyawan;

 //////////////////SELESAI///////////




//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "nip_absensi")
//    private List<absensi_karyawan> absensi_karyawans;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "nip_hadir")
//    private List<izin_karyawan> hadir_karyawans;
}
