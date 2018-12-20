package com.example.license.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.license.config.ServiceConfig;
import com.example.license.model.License;
import com.example.license.repository.LicenseRepository;
import java.util.List;
import java.util.UUID;

@Service
public class LicenseService 
{
    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    ServiceConfig config;

    public License getLicense(String organizationId,String licenseId) 
    {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        return license.withComment(config.getExampleProperty());
    }

    public List<License> getLicensesByOrg(String organizationId)
    {
        return licenseRepository.findByOrganizationId( organizationId );
    }

    public void saveLicense(License license)
    {
        license.withId( UUID.randomUUID().toString());
        licenseRepository.save(license);
    }

    public void updateLicense(License license)
    {
      licenseRepository.save(license);
    }

    public void deleteLicense(License license)
    {
        licenseRepository.delete( license.getLicenseId());
    }
}
