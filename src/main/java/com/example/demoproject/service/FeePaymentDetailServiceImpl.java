package com.example.demoproject.service;

import com.example.demoproject.model.FeePaymentDetail;
import com.example.demoproject.repository.FeePaymentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeePaymentDetailServiceImpl implements FeePaymentDetailService {

    private final FeePaymentDetailRepository feePaymentDetailRepository;

    @Autowired
    public FeePaymentDetailServiceImpl(FeePaymentDetailRepository feePaymentDetailRepository) {
        this.feePaymentDetailRepository = feePaymentDetailRepository;
    }

    @Override
    public FeePaymentDetail createFeePayment(FeePaymentDetail feePaymentDetail) {
        // Add any business logic here (e.g., validation)
        return feePaymentDetailRepository.save(feePaymentDetail);
    }

    @Override
    public FeePaymentDetail getFeePaymentById(Long id) {
        return feePaymentDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<FeePaymentDetail> getAllFeePayments() {
        return feePaymentDetailRepository.findAll();
    }

    @Override
    public void updateFeePayment(Long id, FeePaymentDetail updatedPaymentDetail) {
        // Add business logic for updating a payment detail
        FeePaymentDetail existingPaymentDetail = feePaymentDetailRepository.findById(id).orElse(null);
        if (existingPaymentDetail != null) {
            // Update the existing payment detail with the new data
            existingPaymentDetail.setStudentName(updatedPaymentDetail.getStudentName());
            existingPaymentDetail.setAmount(updatedPaymentDetail.getAmount());
            existingPaymentDetail.setPaymentChannel(updatedPaymentDetail.getPaymentChannel());
            existingPaymentDetail.setAgreedToTerms(updatedPaymentDetail.isAgreedToTerms());
            feePaymentDetailRepository.save(existingPaymentDetail);
        }
    }

    @Override
    public void deleteFeePayment(Long id) {
        feePaymentDetailRepository.deleteById(id);
    }
}
