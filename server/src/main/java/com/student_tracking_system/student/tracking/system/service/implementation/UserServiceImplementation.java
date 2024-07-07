package com.student_tracking_system.student.tracking.system.service.implementation;

import com.student_tracking_system.student.tracking.system.common.GeneralException;
import com.student_tracking_system.student.tracking.system.entity.User;
import com.student_tracking_system.student.tracking.system.entity.enums.Role;
import com.student_tracking_system.student.tracking.system.repository.IUserRepository;
import com.student_tracking_system.student.tracking.system.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements IUserService {
    private final IUserRepository userRepository;

    public UserServiceImplementation(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            if (user.getIdentityNo() == null || user.getIdentityNo().length() != 11) {
                throw new GeneralException("Invalid Identity No");
            }
            if (userRepository.existsByIdentityNo(user.getIdentityNo())) {
                throw new GeneralException("Identity No Already Exists");
            }
        }
        return userRepository.save(user);
    }



    @Override
    public User getById(Integer id) throws GeneralException{
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new GeneralException("User not found!");
        }
        return userOptional.get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new GeneralException("User Not Found");
        }
        userRepository.deleteById(id);
    }


    @Override
    public List<User> getUserByRole(Role role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    public List<User> getPotentialUsers(List<Integer> ids) {
        if (ids.isEmpty()) {
            return getUserByRole(Role.STUDENT);
        }
        return userRepository.findAllByRoleAndIdIsNotIn(Role.STUDENT,ids);
    }

}
