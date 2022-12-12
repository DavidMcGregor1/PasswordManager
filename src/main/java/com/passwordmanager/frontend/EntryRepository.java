package com.passwordmanager.frontend;

import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

}
