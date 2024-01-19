package com.sokchoys.repository;

import com.sokchoys.entity.Sermon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SermonRepository extends JpaRepository<Sermon, Long> {
}
