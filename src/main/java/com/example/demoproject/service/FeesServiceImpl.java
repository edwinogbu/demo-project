package com.example.demoproject.service;

import com.example.demoproject.exception.FeesNotFoundException;
import com.example.demoproject.model.Fees;
import com.example.demoproject.repository.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeesServiceImpl implements FeesService {

    @Autowired
    private FeesRepository feesRepository;

    @Override
    public Fees createFees(Fees fees) {
        return feesRepository.save(fees);
    }

    @Override
    public List<Fees> getAllFees() {
        return feesRepository.findAll();
    }

    @Override
    public Fees getFeesById(Long id) {
        return feesRepository.findById(id)
                .orElseThrow(() -> new FeesNotFoundException(id));
    }

    @Override
    public Fees updateFees(Long id, Fees newFees) {
        Optional<Fees> optionalFees = feesRepository.findById(id);
        if (optionalFees.isPresent()) {
            Fees fees = optionalFees.get();
            fees.setName(newFees.getName());
            fees.setAmount(newFees.getAmount());
            fees.setChecked(newFees.isChecked());

            return feesRepository.save(fees);
        } else {
            throw new FeesNotFoundException(id);
        }
    }

    @Override
    public void deleteFees(Long id) {
        Optional<Fees> optionalFees = feesRepository.findById(id);
        if (optionalFees.isPresent()) {
            Fees fees = optionalFees.get();
            feesRepository.delete(fees);
        } else {
            throw new FeesNotFoundException(id);
        }
    }


    @Override
    public Fees updateFeeCheckbox(Long id, boolean isChecked) {
        Optional<Fees> optionalFees = feesRepository.findById(id);
        if (optionalFees.isPresent()) {
            Fees fees = optionalFees.get();
            fees.setChecked(isChecked);

            return feesRepository.save(fees);
        } else {
            throw new FeesNotFoundException(id);
        }
    }

    @Override
    public double calculateTotalAmount() {
        List<Fees> selectedFees = feesRepository.findByCheckedTrue();
        double totalAmount = 0.0;
        for (Fees fee : selectedFees) {
            totalAmount += fee.getAmount();
        }
        return totalAmount;
    }
}



//package com.example.demoproject.service;
//
//import com.example.demoproject.exception.FeesNotFoundException;
//import com.example.demoproject.model.Fees;
//import com.example.demoproject.repository.FeesRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class FeesServiceImpl implements FeesService {
//
//    @Autowired
//    private FeesRepository feesRepository;
//
//    @Override
//    public Fees createFees(Fees fees) {
//        return feesRepository.save(fees);
//    }
//
//    @Override
//    public List<Fees> getAllFees() {
//        return feesRepository.findAll();
//    }
//
//    @Override
//    public Fees getFeesById(Long id) {
//        return feesRepository.findById(id)
//                .orElseThrow(() -> new FeesNotFoundException(id));
//    }
//
//    @Override
//    public Fees updateFees(Long id, Fees newFees) {
//        Optional<Fees> optionalFees = feesRepository.findById(id);
//        if (optionalFees.isPresent()) {
//            Fees fees = optionalFees.get();
//            fees.setName(newFees.getName());
//            fees.setAmount(newFees.getAmount());
//            fees.setChecked(newFees.isChecked());
//
//            return feesRepository.save(fees);
//        } else {
//            throw new FeesNotFoundException(id);
//        }
//    }
//
//    @Override
//    public void deleteFees(Long id) {
//        Optional<Fees> optionalFees = feesRepository.findById(id);
//        if (optionalFees.isPresent()) {
//            Fees fees = optionalFees.get();
//            feesRepository.delete(fees);
//        } else {
//            throw new FeesNotFoundException(id);
//        }
//    }
//
//    @Override
//    public Fees updateFeeCheckbox(Long id, boolean checked) {
//        Optional<Fees> optionalFees = feesRepository.findById(id);
//        if (optionalFees.isPresent()) {
//            Fees fees = optionalFees.get();
//            fees.setChecked(checked);
//
//
//            return feesRepository.save(fees);
//        } else {
//            throw new FeesNotFoundException(id);
//        }
//    }
//
//    @Override
//    public double calculateTotalAmount() {
//        List<Fees> selectedFees = feesRepository.findByCheckedTrue();
//        double totalAmount = 0.0;
//        for (Fees fee : selectedFees) {
//            totalAmount += fee.getAmount();
//        }
//        return totalAmount;
//    }
//}
//
//
////package com.example.demoproject.service;
////
////
////import com.example.demoproject.exception.FeesNotFoundException;
////import com.example.demoproject.model.Fees;
////import com.example.demoproject.repository.FeesRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////import java.util.Optional;
////
////@Service
////public class FeesServiceImpl implements FeesService{
////
////    @Autowired
////    private FeesRepository feesRepository;
////
////    @Override
////    public Fees createFees(Fees fees) {
////        return feesRepository.save(fees);
////    }
////
////    @Override
////    public List<Fees> getAllFees() {
////        return feesRepository.findAll();
////    }
////
////    @Override
////    public Fees getFeesById(Long id) {
////        return feesRepository.findById(id)
////                .orElseThrow(()->new FeesNotFoundException(id));
////    }
////
////    @Override
////    public Fees updateFees(Long id, Fees newFees) {
////        Optional<Fees> optionalFees = feesRepository.findById(id);
////        if (optionalFees.isPresent()){
////            Fees fees = optionalFees.get();
////            fees.setName(newFees.getName());
////            fees.setAmount(newFees.getAmount());
////            fees.setChecked(newFees.getChecked());
////
////            return feesRepository.save(fees);
////        }else {
////            throw new  FeesNotFoundException(id);
////        }
////    }
////
////    @Override
////    public void deleteFees(Long id) {
////
////    }
////}
