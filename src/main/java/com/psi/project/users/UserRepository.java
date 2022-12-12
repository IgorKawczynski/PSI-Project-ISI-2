package com.psi.project.users;

import com.psi.project.users.valueobjects.EmailValidator;
import com.psi.project.users.valueobjects.PeselValidator;
import com.psi.project.users.valueobjects.TypeValidator;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import java.util.List;
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
    Optional<?> findUserEntityById(Long id);
    List<UserEntity> findByTypeEquals(TypeValidator type);

}
