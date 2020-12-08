package com.example.demo.persistence.repo;

import com.example.demo.persistence.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long> {

}
