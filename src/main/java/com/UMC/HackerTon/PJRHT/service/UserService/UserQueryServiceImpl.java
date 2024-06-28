package com.UMC.HackerTon.PJRHT.service.UserService;

import com.UMC.HackerTon.PJRHT.domain.User;
import com.UMC.HackerTon.PJRHT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService{
    private final UserRepository userRepository;
    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).get();
    }
}
