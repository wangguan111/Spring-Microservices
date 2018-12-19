package com.example.license.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.license.config.ServiceConfig;
import com.example.license.model.License;
import com.example.license.services.LicenseService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequestMapping(value="v1/organizations/{organizationId}/licenses")
public class LicenseServiceController 
{
    @Autowired
    private LicenseService licenseService;

    @Autowired
    private ServiceConfig serviceConfig;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<License> getLicenses( @PathVariable("organizationId") String organizationId) 
    {
        return licenseService.getLicensesByOrg(organizationId);
    }

    @RequestMapping(value="/{licenseId}",method = RequestMethod.GET)
    public License getLicenses( @PathVariable("organizationId") String organizationId,
                                @PathVariable("licenseId") String licenseId) 
    {
        return licenseService.getLicense(organizationId,licenseId);
    }

    @RequestMapping(value="{licenseId}",method = RequestMethod.PUT)
    public String updateLicenses( @PathVariable("licenseId") String licenseId) 
    {
        return String.format("This is the put");
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public void saveLicenses(@RequestBody License license) 
    {
       licenseService.saveLicense(license);
    }

    @RequestMapping(value="{licenseId}",method = RequestMethod.DELETE)
    public String deleteLicenses( @PathVariable("licenseId") String licenseId) 
    {
        return String.format("This is the Delete");
    }
}
