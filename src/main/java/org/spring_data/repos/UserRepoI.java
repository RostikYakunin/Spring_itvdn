package org.spring_data.repos;


import org.spring_data.task_2.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoI extends CrudRepository<User, Long> {

    @Query (value = "select * from users where id = :id",
            nativeQuery = true)
    User getUserByID (
            @Param("id") Long id
    );

//    @Modifying
//    @Query(value = "UPDATE users " +
//            "SET name = :name surname = :surname age = :age telephone = :telephone" +
//            "WHERE id = :id ",
//            nativeQuery = true)
//    User updateUserById(
//            @Param("name") String name,
//            @Param("surname") String surname,
//            @Param("age") Integer age,
//            @Param("telephone") String telephone,
//            @Param("id") Long id
//    );


}
