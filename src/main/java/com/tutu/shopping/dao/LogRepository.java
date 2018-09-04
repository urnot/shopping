package com.tutu.shopping.dao;

import com.tutu.shopping.entity.AccessLog;
import com.tutu.shopping.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<AccessLog,Integer> {
}
