package com.tbs.partnerprofile.service;

import com.tbs.partnerprofile.entity.PartnerProfile;
import com.tbs.partnerprofile.repository.PartnerProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerProfileServiceImpl implements PartnerProfileService {

    @Autowired
    private PartnerProfileRepository partnerProfileRepository;

    @Override
    public String save(PartnerProfile partnerProfile) {
        return isExist(partnerProfile.getEmail()) ? "Partner profile already exist for the given email id. Kindly try with new email" : partnerProfileRepository.save(partnerProfile).toString();
    }

    @Override
    public String findByEmail(String email) {
        return isExist(email) ? partnerProfileRepository.findByEmail(email).toString() : "Check the given email";
    }

    @Override
    public String update(PartnerProfile partnerProfile) {
        if(isExist(partnerProfile.getEmail())){
            partnerProfile.setPartnerId(partnerProfileRepository.findByEmail(partnerProfile.getEmail()).getPartnerId());
            partnerProfileRepository.save(partnerProfile);
            return "partner Details updated successfully for the given email id"+partnerProfile.getEmail();
        }
        return  "Partner detail not available for the given email.";
    }

    @Override
    @Transactional
    public String deleteByEmail(String email) {
        if (isExist(email)) {
            partnerProfileRepository.deleteByEmail(email);
            return "Successfully deleted the partner object for the given email:" + email;
        }
        return "Partner detail not available for the given email.";
    }

    @Override
    public List<PartnerProfile> findAll() {
        return partnerProfileRepository.findAll();
    }

    private boolean isExist(String email) {
        return partnerProfileRepository.existsByEmail(email) ? true : false;
    }
}
