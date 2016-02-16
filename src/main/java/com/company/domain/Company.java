package com.company.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by himanshuk on 16/2/16.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

    int companyId;
    @NotNull
    String companyName;
    @NotNull
    Address companyAddr;

    String emailAddress;

    String phoneNo;

    public void setOwnerNames(List<String> ownerNames) {
        this.ownerNames = ownerNames;
    }

    List<String> ownerNames =new ArrayList<String>();

    public int getCompanyId() {
        return companyId;
    }


    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Address getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(Address companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<String> getOwnerNames() {
        return ownerNames;
    }

    public void addOwnerName(String ownerName) {
        this.ownerNames.add(ownerName);
    }
}
