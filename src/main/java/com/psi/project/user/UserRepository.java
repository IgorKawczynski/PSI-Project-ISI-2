package com.psi.project.user;

import com.psi.project.user.valueobjects.EmailValidator;
import com.psi.project.user.valueobjects.TypeValidator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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

    @Query("SELECT u FROM UserEntity u WHERE u.id = :id")
    UserEntity findUser(@Param("id") Long id);

    List<UserEntity> findByTypeEquals(TypeValidator type);

}
