package org.davidtrimmer.pantry.dao;

import org.davidtrimmer.pantry.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
