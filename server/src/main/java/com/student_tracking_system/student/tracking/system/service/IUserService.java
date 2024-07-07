package com.student_tracking_system.student.tracking.system.service;

import com.student_tracking_system.student.tracking.system.entity.User;
import com.student_tracking_system.student.tracking.system.entity.enums.Role;

import java.util.List;

public interface IUserService extends IService<User> {
    List<User> getUserByRole(Role role);

    List<User> getPotentialUsers(List<Integer> ids);
}
