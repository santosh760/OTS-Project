package com.yash.onlinetrainingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.onlinetrainingsystem.domain.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {

}
