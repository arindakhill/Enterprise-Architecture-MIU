package bank.repository;

import bank.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
	Collection<Account> accountList = new ArrayList<Account>();

	public void saveAccount(Account account) {
		// System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
		accountList.add(account); // add the new
	}

	public void updateAccount(Account account) {
		// System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
		Account accountexist = loadAccount(account.getAccountNumber());
		if (accountexist != null) {
			accountList.remove(accountexist); // remove the old
			accountList.add(account); // add the new
		}

	}

	public Account loadAccount(long accountNumber) {
		// System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
		for (Account account : accountList) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}

	public Collection<Account> getAccounts() {
		return accountList;
	}

}
