package com.example.demoproject.contoller;


import com.example.demoproject.exception.FeesNotFoundException;
import com.example.demoproject.model.Fees;
import com.example.demoproject.repository.FeesRepository;
import com.example.demoproject.service.FeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class FeesController {

    @Autowired
    private FeesService feesService;

    @Autowired
    private FeesRepository feesRepository;

    @PostMapping("/fees/create")
    public ResponseEntity<Fees> createFees(@RequestBody Fees fees) {
        try {
            Fees createdFees = feesService.createFees(fees);
            return new ResponseEntity<>(createdFees, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle invalid input data or other exceptions
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/fees/view")
    public ResponseEntity<List<Fees>> getAllFees() {
        List<Fees> feesList = feesService.getAllFees();
        return new ResponseEntity<>(feesList, HttpStatus.OK);
    }

    @GetMapping("/fees/select/{id}")
    public ResponseEntity<Fees> getFeesById(@PathVariable Long id) {
        try {
            Fees fees = feesService.getFeesById(id);
            return new ResponseEntity<>(fees, HttpStatus.OK);
        } catch (FeesNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/fees/update/{id}")
    public ResponseEntity<?> updateFees(@RequestBody Fees newFees, @PathVariable Long id) {
        try {
            Fees updatedFees = feesService.updateFees(id, newFees);
            return new ResponseEntity<>(updatedFees, HttpStatus.OK);
        } catch (FeesNotFoundException e) {
            String errorMessage = "Fees with ID " + id + " not found.";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            String errorMessage = "An error occurred while updating the fees with ID " + id + ".";
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/fees/delete/{id}")
    public ResponseEntity<String> deleteFees(@PathVariable Long id) {
        try {
            feesService.deleteFees(id);
            String successMessage = "Fees with ID " + id + " has been successfully deleted.";
            return new ResponseEntity<>(successMessage, HttpStatus.OK);
        } catch (FeesNotFoundException e) {
            return new ResponseEntity<>("Fees with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting the fees with ID " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/fees/updateCheckbox/{id}")
//    public ResponseEntity<Fees> updateFeeCheckbox(@PathVariable Long id, @RequestParam boolean isChecked) {
//        try {
//            Fees updatedFee = feesService.updateFeeCheckbox(id, isChecked);
//            return new ResponseEntity<>(updatedFee, HttpStatus.OK);
//        } catch (FeesNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PutMapping("/fees/updateCheckbox/{id}")
    public ResponseEntity<Fees> updateFeeCheckbox(@PathVariable Long id, @RequestParam boolean isChecked) {
        Optional<Fees> optionalFees = feesRepository.findById(id);

        if (optionalFees.isPresent()) {
            Fees fees = optionalFees.get();
            fees.setChecked(isChecked);
            feesRepository.save(fees); // Save the updated fee

            return new ResponseEntity<>(fees, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/fees/calculateTotalAmount")
    public ResponseEntity<Double> calculateTotalAmount() {
        try {
            double totalAmount = feesService.calculateTotalAmount();
            return new ResponseEntity<>(totalAmount, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


//package com.example.demoproject.contoller;

//
//import com.example.demoproject.exception.FeesNotFoundException;
//import com.example.demoproject.model.Fees;
//import com.example.demoproject.service.FeesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//@CrossOrigin("http://localhost:3000")
//public class FeesController {
//
//    @Autowired
//    private FeesService feesService;
//
//    @PostMapping("/fees/create")
//    public ResponseEntity<Fees> createFees(@RequestBody Fees fees) {
//        try {
//            Fees createdFees = feesService.createFees(fees);
//            return new ResponseEntity<>(createdFees, HttpStatus.CREATED);
//        } catch (Exception e) {
//            // Handle invalid input data or other exceptions
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/fees/view")
//    public ResponseEntity<List<Fees>> getAllFees() {
//        List<Fees> users = feesService.getAllFees();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @GetMapping("/fees/select/{id}")
//    public ResponseEntity<Fees> getFeesById(@PathVariable Long id) {
//        try {
//            Fees fees = feesService.getFeesById(id);
//            return new ResponseEntity<>(fees, HttpStatus.OK);
//        } catch (FeesNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    @PutMapping("/fees/update/{id}")
//    public ResponseEntity<?> updateFees(@RequestBody Fees newFees, @PathVariable Long id) {
//        try {
//            Fees updatedFees = feesService.updateFees(id, newFees);
//            return new ResponseEntity<>(updatedFees, HttpStatus.OK);
//        } catch (FeesNotFoundException e) {
//            String errorMessage = "Fees with ID " + id + " not found.";
//            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            String errorMessage = "An error occurred while updating the fees with ID " + id + ".";
//            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//    @DeleteMapping("/fees/delete/{id}")
//    public ResponseEntity<String> deleteFees(@PathVariable Long id) {
//        try {
//            feesService.deleteFees(id);
//            String successMessage = "Fees with ID " + id + " has been successfully deleted.";
//            return new ResponseEntity<>(successMessage, HttpStatus.OK);
//        } catch (FeesNotFoundException e) {
//            return new ResponseEntity<>("Fees with ID " + id + " not found.", HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>("An error occurred while deleting the fees with ID " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//    @PutMapping("/fees/updateCheckbox/{id}")
//    public ResponseEntity<Fees> updateFeeCheckbox(@PathVariable Long id, @RequestParam boolean isChecked) {
//        try {
//            Fees updatedFee = feesService.updateFeeCheckbox(id, isChecked);
//            return new ResponseEntity<>(updatedFee, HttpStatus.OK);
//        } catch (FeesNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/fees/calculateTotalAmount")
//    public ResponseEntity<Double> calculateTotalAmount() {
//        try {
//            double totalAmount = feesService.calculateTotalAmount();
//            return new ResponseEntity<>(totalAmount, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//}
