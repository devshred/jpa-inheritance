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
        Account account = Account.builder().accountName("accountName").accountId("accountsId").build();
        Accounts accounts = Accounts.builder().onlineId("account-onlineId").item("accountKey", account).build();
        final Accounts save = accountsRepository.save(accounts);

        Profile profile = Profile.builder().profileName("myProfile").build();
        final Profile profile1 = profileRepository.save(profile);

        return "accounts: " + save.getId() + " profile: " + profile1.getId();
    }
}
