package com.tbs.partnerprofile.service;

import com.tbs.partnerprofile.entity.PartnerProfile;

import java.util.List;
import java.util.Set;

public interface PartnerProfileService {
    String save(PartnerProfile partnerProfile);

    String findByEmail(String email);

    String update(PartnerProfile partnerProfile);

    String deleteByEmail(String email);

    List<PartnerProfile> findAll();

}
