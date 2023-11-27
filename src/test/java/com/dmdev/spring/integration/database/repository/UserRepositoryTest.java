package com.dmdev.spring.integration.database.repository;

import com.dmdev.spring.database.repository.UserRepository;
import com.dmdev.spring.dto.PersonalInfo;
import com.dmdev.spring.dto.PersonalInfoIfc;
import com.dmdev.spring.dto.UserFilter;
import com.dmdev.spring.entity.Role;
import com.dmdev.spring.entity.User;
import com.dmdev.spring.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void checkFind(){
        List<User> users = userRepository.findAllBy("a", "ov");
        assertThat(users).hasSize(3);
        System.out.println(users);
    }

    @Test
    void checkUpdate(){

        User user = userRepository.getById(1L);
        assertSame(Role.ADMIN, user.getRole());

        int result = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, result);

        User sameUser = userRepository.getById(1L);
        assertSame(Role.USER, sameUser.getRole());
    }

    @Test
    void checkTopUser(){
        Optional<User> user = userRepository.findTopByOrderByIdDesc();
        assertTrue(user.isPresent());
        user.ifPresent(u -> assertEquals(5L, u.getId()));
    }

    @Test
    void checkSort(){
        Sort sort = Sort.by("id");
        Sort sortWithAnd = Sort.by("firstname").and(Sort.by("lastname"));

        Sort.TypedSort<User> sortByFields = Sort.sort(User.class);
        Sort sortByF = sortByFields.by(User::getFirstname).and(sortByFields.by(User::getLastname));

        List<User> users = userRepository.findTop3ByBirthDateBefore(LocalDate.now(), sortByF);
        assertThat(users);
    }

//    @Test
//    void checkPageable(){
//        PageRequest pageRequest = PageRequest.of(1, 2, Sort.by("id"));
//        List<User> users = userRepository.findAllBy(pageRequest);
//        Assertions.assertThat(users).hasSize(2);
//    }

    @Test
    void checkSlice(){
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by("id"));
        Slice<User> slice = userRepository.findAllBy(pageRequest);
        slice.forEach(user -> System.out.println(user.getCompany().getName()));

        while (slice.hasNext()){
            slice = userRepository.findAllBy(slice.nextPageable());
            slice.forEach(user -> System.out.println(user.getCompany().getName()));
        }
    }

    @Test
    void checkProjection(){
//        List<PersonalInfo> users = userRepository.findByCompanyId(1);
//        List<PersonalInfo> users = userRepository.findByCompanyId(1, PersonalInfo.class);
        List<PersonalInfoIfc> users = userRepository.findByCompanyId(1);
        assertThat(users).hasSize(2);
        System.out.println();
    }

    @Test
    void checkCustomImpl(){
        UserFilter filter = new UserFilter(null, "ov", LocalDate.now());
        List<User> users = userRepository.findAllByFilter(filter);
        System.out.println();
    }

    @Test
    @Commit
    void checkAuditing(){
        User user = userRepository.findById(1L).get();
        user.setBirthDate(user.getBirthDate().plusYears(1L));
        userRepository.flush();
        System.out.println();
    }

    @Test
    void checkJdbcTemplate() {
        List<PersonalInfo> users = userRepository.findAllByCompanyIdAndRole(1, Role.USER);
        assertThat(users).hasSize(1);
    }

    @Test
    void checkBatch() {
        List<User> users = userRepository.findAll();
        userRepository.updateCompanyAndRole(users);
        System.out.println();
    }

}