package com.raf.user_service.repository;

import com.raf.user_service.domain.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatusRepository extends JpaRepository<UserStatus, Long> {
}
