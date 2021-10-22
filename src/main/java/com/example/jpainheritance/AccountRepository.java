package com.example.jpainheritance;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountRecord, String> {}
