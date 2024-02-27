package com.Turkcell.Kodlama.io.Devs.business.abstracts;

import com.Turkcell.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {

    List<ProgrammingLanguage> getAll();
    ProgrammingLanguage getById(int id);
    ProgrammingLanguage save(ProgrammingLanguage programmingLanguage);
    void update(int id, String name);
    void delete(int id);
}
