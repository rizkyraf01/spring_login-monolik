package absensikaryawanmandiri.core.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbl_absen_karyawan")
public class absensi_karyawan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(name="nip_absen",length = 10, nullable = false, unique = true)
//    private String nip_absen;

    @Column(name="jam_masuk", nullable = false)
    private String jam_masuk;

    @Column(name="nip",length = 10, nullable = false, unique = true)
    private Integer nip;

    @Column(length = 100, nullable = false)
    private String nama;


    ////////coba validation nip/////////
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
////    @Column(name="nip_absen",length = 10, nullable = false, unique = true)
////    private String nip_absen;
//
//    @Column(name="jam_masuk",length = 50, nullable = false)
//    private Date jam_masuk;
//
////    @Column(name="nip_absen",length = 100,nullable = false)
////    private Integer nip_absen;
//
//    @Column(length = 100, nullable = false)
//    private String nama;
//
//    @Column(length = 50, nullable = false)
//    private String departement;
//
//    @Column(length = 50, nullable = false)
//    private String jabatan;
//
//    @OneToOne(mappedBy = "Absensi_Karyawan")
//    private daftar_karyawan Daftar_Karyawan;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name= "id_absensi", referencedColumnName = "id")
//    private izin_karyawan Izin_Karyawan;
/////

    ////////////////selesai/////////

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name= "nip")
//    private daftar_karyawan dafka;
}
