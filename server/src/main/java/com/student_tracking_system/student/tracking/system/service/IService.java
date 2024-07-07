package com.student_tracking_system.student.tracking.system.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IService <T>{
    T save(T t);
    T getById(Integer id);
    List<T> getAll();
    Page<T> getAll(Pageable pageable);
    void delete(Integer id);
}
