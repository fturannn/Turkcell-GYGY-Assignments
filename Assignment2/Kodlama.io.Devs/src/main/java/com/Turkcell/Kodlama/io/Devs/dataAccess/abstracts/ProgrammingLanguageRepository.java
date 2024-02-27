package com.Turkcell.Kodlama.io.Devs.dataAccess.abstracts;

import com.Turkcell.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageRepository {

    List<ProgrammingLanguage> getAll();
    ProgrammingLanguage getById(int id);
    ProgrammingLanguage save(ProgrammingLanguage programmingLanguage);
    void update(int id, String name);
    void delete(int id);
}
