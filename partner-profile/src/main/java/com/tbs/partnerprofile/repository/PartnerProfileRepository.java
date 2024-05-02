package com.tbs.partnerprofile.repository;

import com.tbs.partnerprofile.entity.PartnerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerProfileRepository extends JpaRepository<PartnerProfile, Integer> {

    boolean existsByEmail(String email);

    PartnerProfile findByEmail(String email);

    void deleteByEmail(String email);

}
