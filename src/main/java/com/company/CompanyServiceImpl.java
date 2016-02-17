package com.company;

import com.company.domain.Company;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by himanshuk on 16/2/16.
 */
@RestController
@RequestMapping("/company")
public class CompanyServiceImpl implements CompanyService {
    Map<Integer,Company> inMemoryCompanyDB;
    private static int generatedCompanyId=2;

    @RequestMapping(method = RequestMethod.POST)
    public Company createCompany(@RequestBody @Valid Company company) {
        company.setCompanyId(++generatedCompanyId);
        inMemoryCompanyDB.put(company.getCompanyId(),company);
        return company;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Company[] listCompany() {
        List<Company> companyList=new ArrayList<Company>(inMemoryCompanyDB.size());
        for(int companyId:inMemoryCompanyDB.keySet()){
            companyList.add(inMemoryCompanyDB.get(companyId));
        }
        return companyList.toArray(new Company[companyList.size()]);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Company getCompany(@PathVariable int id) {
        return inMemoryCompanyDB.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Company updateCompany(@PathVariable int id, @RequestBody Company company) {
        company.setCompanyId(id);
        inMemoryCompanyDB.put(id,company);
        return company;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Company deleteCompany(@PathVariable int id) {
        Company company=inMemoryCompanyDB.remove(id);
        return company;
    }

    @RequestMapping(value = "/{id}/addowner/{ownername}", method = RequestMethod.PUT)
    public String[] addOwner(@PathVariable int id, @PathVariable String ownername) {
        Company company=inMemoryCompanyDB.get(id);
        company.addOwnerName(ownername);
        return company.getOwnerNames().toArray(new String[company.getOwnerNames().size()]);
    }

    public void setInMemoryCompanyDB(Map<Integer, Company> inMemoryCompanyDB) {
        this.inMemoryCompanyDB = inMemoryCompanyDB;
    }
}
