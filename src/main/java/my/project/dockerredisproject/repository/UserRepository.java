package my.project.dockerredisproject.repository;


import my.project.dockerredisproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}