package org.davidtrimmer.pantry.dao;

import org.davidtrimmer.pantry.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
