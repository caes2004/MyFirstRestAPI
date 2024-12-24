package com.escaes.API.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.escaes.API.model.Status;
import java.util.Optional;
public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findByStatusName(String statusName);
}
