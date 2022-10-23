package absensikaryawanmandiri.core.logreg.service.impl;

import absensikaryawanmandiri.core.logreg.dto.UserDto;
import absensikaryawanmandiri.core.logreg.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUser();
}
