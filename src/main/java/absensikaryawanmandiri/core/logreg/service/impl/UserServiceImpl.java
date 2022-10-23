package absensikaryawanmandiri.core.logreg.service.impl;

import absensikaryawanmandiri.core.logreg.dto.UserDto;
import absensikaryawanmandiri.core.logreg.entity.Role;
import absensikaryawanmandiri.core.logreg.entity.User;
import absensikaryawanmandiri.core.logreg.repository.RoleRepository;
import absensikaryawanmandiri.core.logreg.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setNama(userDto.getNama());
        user.setAlamat(userDto.getAlamat());
        user.setNip(userDto.getNip());
        user.setNo_telp(userDto.getNo_telp());
        user.setJenis_kelamin(userDto.getJenis_kelamin());
        user.setDepartement(userDto.getDepartement());
        user.setJabatan(userDto.getJabatan());
        user.setEmail(userDto.getEmail());

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }
    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setNama(user.getNama());
        userDto.setNip(user.getNip());
        userDto.setAlamat(user.getAlamat());
        userDto.setJabatan(user.getJabatan());
        userDto.setDepartement(user.getDepartement());
        userDto.setJenis_kelamin(user.getJenis_kelamin());
        userDto.setNo_telp(user.getNo_telp());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
