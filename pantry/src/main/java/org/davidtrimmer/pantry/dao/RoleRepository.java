package org.davidtrimmer.pantry.dao;

import org.davidtrimmer.pantry.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
   Role findRoleByName(String theRoleName);
}
