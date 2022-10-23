package absensikaryawanmandiri.core.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_izin")
public class izin_karyawan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nama;

    //    @Column(name= "nip_izin",length = 10, nullable = false, unique = true)
//    private String nip_izin;
    @Column(name="nip_hadir",length = 100,nullable = false,unique = true)
    private Integer nip;

    @Column(name="keterangan",length = 200, nullable = false)
    private String keterangan;

    ////////////coba validation//////

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(length = 100, nullable = false)
//    private String nama;
//
//
////    @Column(name="nip_hadir",length = 100,nullable = false)
////    private Integer nip_hadir;
//
//    @Column(name="keterangan",length = 200, nullable = false)
//    private String keterangan;
//
//    @OneToOne(mappedBy = "Izin_Karyawan")
//    private absensi_karyawan Absensi_Karyawan;




    /////////////selesai///////////

//    @ManyToOne
//    @JoinColumn(name= "nip")
//    private daftar_karyawan dafka;
}
