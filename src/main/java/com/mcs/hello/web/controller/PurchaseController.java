package com.mcs.hello.web.controller;

import com.mcs.hello.domain.Purchase;
import com.mcs.hello.domain.service.PurchaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseServices purchaseServices;
    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(purchaseServices.getAll(), HttpStatus.OK);
    }
    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idClient") String clientId) {
        return purchaseServices.getByClient(clientId).filter(Predicate.not(List::isEmpty))
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseServices.save(purchase), HttpStatus.CREATED);
    }
}