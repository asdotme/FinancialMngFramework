package finalproject.controller.account;

import finalproject.model.customer.ICompany;
import finalproject.model.customer.IPerson;

public interface IAccountVisitor {
    void createAccount(IPerson iPerson);
    void createAccount(ICompany iCompany);

}
