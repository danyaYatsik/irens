package org.yatsiko.irens.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yatsiko.irens.models.Palindrome;
import org.yatsiko.irens.repo.PalindromesRepository;
import org.yatsiko.irens.utils.PalindromesHelper;

import java.util.Collections;
import java.util.List;

@Service
public class PalindromesService {

    private final PalindromesRepository repository;

    @Autowired
    public PalindromesService(PalindromesRepository repository) {
        this.repository = repository;
    }

    public Palindrome createPalindrome(String origin, int range) {
        List<String> list = PalindromesHelper.getPalindromes(origin, range);
        return new Palindrome(origin, list.get(list.size() - 1), list.get(0));
    }

    public void savePalindrome(Palindrome palindrome) {
        repository.save(palindrome);
    }

    public Palindrome getPalindrome(Integer id) {
        return repository.getOne(id);
    }

    public List<Palindrome> getAll() {
        List<Palindrome> list = repository.findAll();
        Collections.reverse(list);
        return list;
    }
}
