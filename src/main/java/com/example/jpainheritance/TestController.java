package com.example.jpainheritance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  private final AccountsRepository accountsRepository;
  private final ProfileRepository profileRepository;

  public TestController(
      AccountsRepository accountsRepository, ProfileRepository profileRepository) {
    this.accountsRepository = accountsRepository;
    this.profileRepository = profileRepository;
  }

  @GetMapping("/")
  public String index() {
    Accounts accounts = Accounts.builder().onlineId("account-onlineId").build();
    Account account = Account.builder().accountName("accountName").accountId("accountsId").build();

    return "success";
  }
}
