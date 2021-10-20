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
  public String createEntities() {
    final Record<Accounts> accountsRecord =
        accountsRepository.save(
            AccountsRecord.builder()
                .id("AccountsRecordId")
                .state(
                    RecordStatus.ON,
                    Accounts.builder()
                        .identifier("accounts-identifier")
                        .item("accountKey", Account.builder().accountName("accountName").build())
                        .build())
                .build());

    final ProfileRecord profileRecord =
        profileRepository.save(
            ProfileRecord.builder()
                .id("ProfileRecordId")
                .state(RecordStatus.OFF, Profile.builder().profileName("profileName").build())
                .build());

    return String.format(
        "accountsId: %s, profileId: %s", accountsRecord.getId(), profileRecord.getId());
  }
}
