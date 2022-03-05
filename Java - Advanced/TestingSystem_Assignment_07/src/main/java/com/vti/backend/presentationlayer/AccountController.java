package com.vti.backend.presentationlayer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.backend.businesslayer.IAccountService;
import com.vti.backend.datalayer.IDepartmentRepository;
import com.vti.backend.datalayer.IPositionRepository;
import com.vti.backend.datalayer.ISalaryRepository;
import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.entity.Position;
import com.vti.entity.enums.PositionName;
import com.vti.entity.enums.SalaryName;

@RestController
@RequestMapping(value = "api/v1/accounts7")
public class AccountController {

	@Autowired
	private IAccountService service;
	
	@Autowired
	private IDepartmentRepository departmentRepository;
	
	@Autowired
	private IPositionRepository positionRepository;
	
	@Autowired
	private ISalaryRepository salaryRepository;
	
	
	@GetMapping()
	public Page<Account> getAllAccounts(Pageable pageable){
		return service.getAllAccounts(pageable);
	}
	
	@GetMapping(value = "/{accountId}")
	public Account getAccountById(@PathVariable(name = "accountId") short id) {
		return service.getAccountById(id);
	}
	
	@GetMapping(value = "/fullName/{fullName}")
	public Account getAccountByFullName(@PathVariable(name = "fullName") String fullName) {
		return service.getAccountByFullName(fullName);
	}
	
	
	
	@PostMapping()
	public void createAccount(@RequestBody Account account) {
		account.setDepartmentId(departmentRepository.findByDepartmentName("Sale"));
		account.setPositionId(positionRepository.findByPositionName(PositionName.DEV));
		account.setSalaryId(salaryRepository.findBySalaryName(SalaryName.DEV));
		account.setCreateDate(new Date());
		service.createAccount(account);
	}
	
	// error
	@PutMapping(value = "/{accountId}")
	public void updateAccount(@PathVariable(name = "accountId") short id, @RequestBody Account account) {
		account.setAccountId(id);
		account.setCreateDate(new Date());
		service.updateAccount(account);
	}
	
	
	@DeleteMapping(value = "/{accountId}")
	public void deleteAccount(@PathVariable(name = "accountId") short accountId) {
		service.deleteAccount(accountId);
	}
	
	@GetMapping(value = "/is/{accountId}")
	public boolean isAccountExistsById(@PathVariable(name = "accountId") short accountId) {
		return service.isAccountExistsById(accountId);
	}
	
	@GetMapping(value = "/isName/{fullName}")
	public boolean isAccountExistsByFullName(@PathVariable(name = "fullName") String fullName) {
		return service.isAccountExistsByFullName(fullName);
	}
	
	
	
	
	
	
}
