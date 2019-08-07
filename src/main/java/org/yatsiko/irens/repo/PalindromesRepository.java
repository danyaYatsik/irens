package org.yatsiko.irens.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yatsiko.irens.models.Palindrome;

@Repository
public interface PalindromesRepository extends JpaRepository<Palindrome, Integer> {
    Palindrome getFirstByOrigin(String origin);
}
