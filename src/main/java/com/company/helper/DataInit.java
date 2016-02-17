package com.company.helper;

import com.company.CompanyServiceImpl;
import com.company.domain.Address;
import com.company.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by himanshuk on 17/2/16.
 */
@Component
public class DataInit implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired private CompanyServiceImpl companyServiceImpl;

    private void initCompanyData() {
        Map<Integer, Company> inMemoryCompanyDB=new HashMap<>();
        Company company0=new Company();
        company0.setCompanyId(0);
        company0.setCompanyName("Technology pvt ltd");
        company0.setCompanyAddr(new Address("flat no -402, Street no 1", "Delhi", "India", 12345));
        company0.setEmailAddress("himuk4u@gmail.com");
        company0.setPhoneNo("9000035205");
        company0.setOwnerNames(new ArrayList<String>() {{
            add("Himanshu");
            add("Raman");
            add("Kajal");
        }});

        inMemoryCompanyDB.put(0,company0);

        Company company1=new Company();
        company1.setCompanyId(1);
        company1.setCompanyName("Software technology");
        company1.setCompanyAddr(new Address("Street no 1, house no =1973", "hyderabad", "India", 78910));
        company1.setEmailAddress("abcdef@gmail.com");
        company1.setPhoneNo("9000035206");
        company1.setOwnerNames(new ArrayList<String>() {{
            add("khantwal");
            add("Bhatti");
        }});

        inMemoryCompanyDB.put(1,company1);

        companyServiceImpl.setInMemoryCompanyDB(inMemoryCompanyDB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initCompanyData();
    }
}
