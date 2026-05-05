package com.likelion14.session.repository;

import com.likelion14.session.entity.TeamGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<TeamGroup,Long> {
}
