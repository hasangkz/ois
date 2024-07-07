package com.student_tracking_system.student.tracking.system.repository;

import com.student_tracking_system.student.tracking.system.entity.Lecture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILectureRepository  extends JpaRepository<Lecture,Integer> {
    Page<Lecture> findAllBy(Pageable pageable);

}
