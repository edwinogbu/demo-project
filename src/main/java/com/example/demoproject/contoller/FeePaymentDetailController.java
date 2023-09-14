package com.example.demoproject.contoller;

import com.example.demoproject.model.FeePaymentDetail;
import com.example.demoproject.service.FeePaymentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fee-payments")
@CrossOrigin("http://localhost:3000")
public class FeePaymentDetailController {

    private final FeePaymentDetailService feePaymentDetailService;

    @Autowired
    public FeePaymentDetailController(FeePaymentDetailService feePaymentDetailService) {
        this.feePaymentDetailService = feePaymentDetailService;
    }

    @PostMapping("/create")
    public ResponseEntity<FeePaymentDetail> createFeePayment(@RequestBody FeePaymentDetail feePaymentDetail) {
        FeePaymentDetail createdPayment = feePaymentDetailService.createFeePayment(feePaymentDetail);
        return ResponseEntity.ok(createdPayment);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<FeePaymentDetail> getFeePaymentById(@PathVariable Long id) {
        FeePaymentDetail paymentDetail = feePaymentDetailService.getFeePaymentById(id);
        if (paymentDetail != null) {
            return ResponseEntity.ok(paymentDetail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/view")
    public ResponseEntity<List<FeePaymentDetail>> getAllFeePayments() {
        List<FeePaymentDetail> feePayments = feePaymentDetailService.getAllFeePayments();
        return ResponseEntity.ok(feePayments);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateFeePayment(@PathVariable Long id, @RequestBody FeePaymentDetail updatedPaymentDetail) {
        feePaymentDetailService.updateFeePayment(id, updatedPaymentDetail);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Void> deleteFeePayment(@PathVariable Long id) {
        feePaymentDetailService.deleteFeePayment(id);
        return ResponseEntity.noContent().build();
    }
}
