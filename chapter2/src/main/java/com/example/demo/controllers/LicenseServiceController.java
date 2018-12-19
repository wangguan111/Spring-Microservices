package com.example.demo.controllers;

import com.example.demo.model.License;
import com.example.demo.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value="v1/organizations/{organizationId}/licenses")
public class LicenseServiceController 
{
    @Autowired
    private LicenseService licenseService;

    @RequestMapping(value="/{licenseId}",method = RequestMethod.GET)
    public License getLicenses( @PathVariable("organizationId") String organizationId,
                                @PathVariable("licenseId") String licenseId) 
    {
        return licenseService.getLicense(licenseId);
//        return new License()
//            .withId(licenseId)
//            .withOrganizationId(organizationId)
//            .withProductName("Teleco")
//            .withLicenseType("Seat")
//            .withOrganizationId("TestOrg");
    }

    @RequestMapping(value="{licenseId}",method = RequestMethod.PUT)
    public String updateLicenses( @PathVariable("licenseId") String licenseId) 
    {
        return String.format("This is the put");
    }

    @RequestMapping(value="{licenseId}",method = RequestMethod.POST)
    public String saveLicenses( @PathVariable("licenseId") String licenseId)
    {
        return String.format("This is the post");
    }

    @RequestMapping(value="{licenseId}",method = RequestMethod.DELETE)
    public String deleteLicenses( @PathVariable("licenseId") String licenseId) 
    {
        return String.format("This is the Delete");
    }
}
