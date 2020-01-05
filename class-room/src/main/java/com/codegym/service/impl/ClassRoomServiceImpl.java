package com.codegym.service.impl;

import com.codegym.model.ClassRoom;
import com.codegym.repository.ClassRoomRepository;
import com.codegym.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public Optional<ClassRoom> findById(Long id) {
        return classRoomRepository.findById(id);
    }

    @Override
    public Iterable<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public ClassRoom save(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    @Override
    public void delete(Long id) {
        classRoomRepository.deleteById(id);
    }

    @Override
    public Iterable<ClassRoom> findByName(String name) {
        return classRoomRepository.findByName(name);
    }
}
