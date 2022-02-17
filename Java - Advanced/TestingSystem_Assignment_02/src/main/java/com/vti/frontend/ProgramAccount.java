package com.vti.frontend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.vti.backend.datelayer.AccountRepository;
import com.vti.enity.Account;

public class ProgramAccount {

	public static void main(String[] args) throws ParseException {
		
		AccountRepository accountRepository = new AccountRepository();
		
		
//		System.out.println("Danh Sách Account");
//		List<Account> lists = accountRepository.getAllAccount();
//		
//		for (Account account : lists) {
//			System.out.println(account);
//		}
		
		
//		System.out.println("Create Account");
//		Account account = new Account();
//		account.setEmail("hieubuitat@gmail.com");
//		account.setUserName("hieu.buitat");
//		account.setFirstName("Hiếu");
//		account.setLastName("Bùi Tất");
//		account.setCreateDate(new Date());
//		
//		accountRepository.createAccount(account);
		
//		Account account2 = new Account();
//		account2.setEmail("binhnguyenquy@gmail.com");
//		account2.setUserName("binh.nguyenquy");
//		account2.setFirstName("Bình");
//		account2.setLastName("Nguyễn Quý");
//		
//		String date_string = "20-11-1992";
//		// Instantiating the SimpleDateFormat class
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//		// Parsing the given String to Date object
//		Date date = formatter.parse(date_string);
//		
//		account2.setCreateDate(date);
//		
//		accountRepository.createAccount(account2);
		
		
		System.out.println("Delete Account");
		accountRepository.deleteAccount((short) 12);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
