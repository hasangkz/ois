package com.student_tracking_system.student.tracking.system.service.implementation;

import com.student_tracking_system.student.tracking.system.common.GeneralException;
import com.student_tracking_system.student.tracking.system.entity.Lecture;
import com.student_tracking_system.student.tracking.system.repository.ILectureRepository;
import com.student_tracking_system.student.tracking.system.service.ILectureService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class LectureServiceImplementation implements ILectureService {
    private final ILectureRepository lectureRepository;

    public LectureServiceImplementation(ILectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public Lecture save(Lecture lecture) {
        if (StringUtils.isEmpty(lecture.getName())) {
            throw new GeneralException("Name cannot be empty!");
        }
        if (lecture.getTeacher() == null) {
            throw new GeneralException("Teacher cannot be empty!");
        }
        return lectureRepository.save(lecture);
    }

    @Override
    public Lecture getById(Integer id) {
        return lectureRepository.findById(id).orElseThrow(()-> new GeneralException("Lecture Not Found!"));
    }

    @Override
    public List<Lecture> getAll() {
        return lectureRepository.findAll();
    }
    @Override
    public Page<Lecture> getAll(Pageable pageable) {
        return lectureRepository.findAllBy(pageable);
    }

    @Override
    public void delete(Integer id) {
        if (!lectureRepository.existsById(id)) {
            throw new GeneralException("Lecture Not Found!");
        }
        lectureRepository.deleteById(id);
    }

}
