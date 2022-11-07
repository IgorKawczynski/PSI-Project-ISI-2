package com.psi.project.users;

import com.psi.project.users.valueobjects.EmailValidator;
import com.psi.project.users.valueobjects.PeselValidator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * Repozytorium JPA użytkownika
 * @author Igor Kawczyński
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<?> findUserByEmail(EmailValidator email);
    UserEntity findUserEntityById(Long id);
    Boolean existsUserEntityByEmail(EmailValidator email);
    Boolean existsUserEntityByPesel(PeselValidator pesel);
}
