

import com.company.domain.Company;

/**
 * Created by himanshuk on 16/2/16.
 */
public interface CompanyService {
    public Company createCompany(Company company);

    public Company[] listCompany();

    public Company getCompany(int id);

    public Company updateCompany(int id,Company company);

    public Company deleteCompany(int id);

    public String[] addOwner(int id,String ownerName);
}
