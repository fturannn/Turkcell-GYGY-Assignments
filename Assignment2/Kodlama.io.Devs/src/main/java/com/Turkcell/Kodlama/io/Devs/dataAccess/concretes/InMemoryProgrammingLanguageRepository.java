package com.Turkcell.Kodlama.io.Devs.dataAccess.concretes;

import com.Turkcell.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.Turkcell.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

    List<ProgrammingLanguage> programmingLanguages;

    public InMemoryProgrammingLanguageRepository() {
        programmingLanguages = new ArrayList<>();
        programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
        programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
        programmingLanguages.add(new ProgrammingLanguage(3, "Python"));
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguages;
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return programmingLanguages.
                stream().filter(language -> language.getId() == id).findFirst().orElse(null);
    }

    @Override
    public ProgrammingLanguage save(ProgrammingLanguage programmingLanguage) {
        programmingLanguages.add(programmingLanguage);
        return programmingLanguage;
    }

    @Override
    public void update(int id, String name) {
        this.getById(id).setName(name);
    }

    @Override
    public void delete(int id) {
        programmingLanguages.remove(this.getById(id));
    }
}
