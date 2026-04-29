package in.aditya.pixelerase.repository;

import in.aditya.pixelerase.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Boolean existsByClerkId(String clerkId);

    Optional<UserEntity> findByClerkId(String clerkId);

}
