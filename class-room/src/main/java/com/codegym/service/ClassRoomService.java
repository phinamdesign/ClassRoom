package com.codegym.service;

import com.codegym.model.ClassRoom;

import java.util.Optional;

public interface ClassRoomService {
    Optional<ClassRoom> findById(Long id);

    Iterable<ClassRoom> findAll();

    ClassRoom save(ClassRoom classRoom);

    void delete(Long id);

    Iterable<ClassRoom> findByName(String name);
}
