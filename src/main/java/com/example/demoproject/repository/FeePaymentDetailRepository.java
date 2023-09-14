package com.example.demoproject.repository;

import com.example.demoproject.model.FeePaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeePaymentDetailRepository extends JpaRepository<FeePaymentDetail, Long> {
    List<FeePaymentDetail> findByStudentName(String studentName);

}
