package com.example.license.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.license.model.License;
import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License,String>  
{
    public List<License> findByOrganizationId(String organizationId);
    public License findByOrganizationIdAndLicenseId(String organizationId,String licenseId);
}
