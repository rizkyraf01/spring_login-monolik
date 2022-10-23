package absensikaryawanmandiri.core.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_absenkeluar_karyawan")
public class absensikeluar_karyawan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="nip",length = 10, nullable = false, unique = true)
    private Integer nip;

    @Column(length = 100, nullable = false)
    private String nama;

    @Column(name = "jam_keluar", nullable = false)
    private String jam_keluar;
}
