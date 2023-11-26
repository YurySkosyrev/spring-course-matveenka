package com.dmdev.spring.database.repository;

import com.dmdev.spring.dto.PersonalInfoIfc;
import com.dmdev.spring.entity.Role;
import com.dmdev.spring.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where " +
            "u.firstname like %:firstName% and u.lastname like %:lastName%")
    List<User> findAllBy(String firstName, String lastName);

    @Query(value = "SELECT u.* FROM users u WHERE u.username = :username",
    nativeQuery = true)
    List<User> findAllByUserName(String username);

    @Modifying(clearAutomatically = true)
    @Query("update User u " +
            "set u.role= :role " +
            "where u.id in (:ids)")
    int updateRole(Role role, Long ... ids);

    Optional<User> findTopByOrderByIdDesc();

    @QueryHints(@QueryHint(name = "org.hibernate.fetchSize", value = "50"))
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<User> findTop3ByBirthDateBefore(LocalDate birthDate, Sort sort);

//    List<User> findAllBy(Pageable pageable);
//    Slice<User> findAllBy(Pageable pageable);
//    @EntityGraph("User.company")
    @EntityGraph(attributePaths = {"company", "company.locales"})
    @Query(value = "select u from User u",
    countQuery = "select count(distinct u.firstname) from User u")
    Page<User> findAllBy(Pageable pageable);

//    List<PersonalInfo> findByCompanyId(Integer companyId);
//    <T> List<T> findByCompanyId(Integer companyId, Class<T> clazz);

    @Query(value = "SELECT firstname, lastname, birth_date birthDate FROM users WHERE company_id=:companyId",
            nativeQuery = true)
    List<PersonalInfoIfc> findByCompanyId(Integer companyId);
}
