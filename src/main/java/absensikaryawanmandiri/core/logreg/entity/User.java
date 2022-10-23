package absensikaryawanmandiri.core.logreg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nip",length = 10, nullable = false, unique = true)
    private String nip;

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

    @Column(nullable=false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles = new ArrayList<>();

}