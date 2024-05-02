package com.tbs.partnerprofile.controller;

import com.tbs.partnerprofile.entity.PartnerProfile;
import com.tbs.partnerprofile.service.PartnerProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partner")
public class PartnerProfileController {

    @Autowired
    private PartnerProfileService partnerProfileService;

    @GetMapping("/all")
    public ResponseEntity<List<PartnerProfile>> getAll() {
        return new ResponseEntity<>(partnerProfileService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{email}")
    public ResponseEntity<String> getById(@PathVariable String email) {
        return new ResponseEntity<>(partnerProfileService.findByEmail(email), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody @Valid PartnerProfile partnerProfile) {
        return new ResponseEntity<>(partnerProfileService.save(partnerProfile), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid PartnerProfile partnerProfile) {
        return new ResponseEntity<>(partnerProfileService.update(partnerProfile), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> delete(@PathVariable String email) {
        return new ResponseEntity<>(partnerProfileService.deleteByEmail(email), HttpStatus.OK);
    }


}
