package com.example.demoproject.service;

import com.example.demoproject.model.FeePaymentDetail;

import java.util.List;

public interface FeePaymentDetailService {
    FeePaymentDetail createFeePayment(FeePaymentDetail feePaymentDetail);
    FeePaymentDetail getFeePaymentById(Long id);
    List<FeePaymentDetail> getAllFeePayments();
    void updateFeePayment(Long id, FeePaymentDetail updatedPaymentDetail);
    void deleteFeePayment(Long id);
}
