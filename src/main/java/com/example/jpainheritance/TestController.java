package com.example.jpainheritance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  private final AccountRepository accountRepository;
  private final ProfileRepository profileRepository;

  public TestController(
          AccountRepository accountRepository, ProfileRepository profileRepository) {
    this.accountRepository = accountRepository;
    this.profileRepository = profileRepository;
  }

  @GetMapping("/")
  public String createEntities() {
    final AccountRecord accountsRecord =
        accountRepository.save(
            AccountRecord.builder()
                .id("AccountsRecordId")
                .state(
                    RecordStatus.ON,
                    Account.builder().accountName("accountName").build())
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

  @GetMapping("/find")
  public String find(){
    AccountRecord accountRecord = accountRepository.findById("AccountsRecordId").orElseThrow(RuntimeException::new);
    ProfileRecord profileRecord = profileRepository.findById("ProfileRecordId").orElseThrow(RuntimeException::new);
    return String.format("account: %s, profile: %s",
            accountRecord.getStates().get(RecordStatus.ON).getAccountName(),
            profileRecord.getStates().get(RecordStatus.OFF).getProfileName()
    );
  }
}
