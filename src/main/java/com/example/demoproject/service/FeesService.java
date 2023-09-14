package com.example.demoproject.service;

import com.example.demoproject.model.Fees;

import java.util.List;

public interface FeesService {
    Fees createFees(Fees fees);
    List<Fees> getAllFees();
    Fees getFeesById(Long id);
    Fees updateFees(Long id, Fees newFees);
    void deleteFees(Long id);
    Fees updateFeeCheckbox(Long id, boolean isChecked);
    double calculateTotalAmount();
}
