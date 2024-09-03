package com.sokchoys.domain.info.repository;

import com.sokchoys.domain.info.entity.Info;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Short> {

    Optional<Info> findById(Short id);
}
