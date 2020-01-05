package com.codegym.repository;

import com.codegym.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
    Iterable<ClassRoom> findByName(String name);
}
