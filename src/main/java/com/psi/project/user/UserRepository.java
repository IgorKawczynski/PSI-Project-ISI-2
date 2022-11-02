package com.psi.project.user;

import com.psi.project.user.valueobjects.EmailValidator;
import com.psi.project.user.valueobjects.PeselValidator;

public interface UserRepository {

    UserEntity findUserByEmail(EmailValidator email);
    UserEntity findUserEntityById(Long id);
    Boolean existsUserEntityByEmail(EmailValidator email);
    Boolean existsUserEntityByPesel(PeselValidator pesel);
}
