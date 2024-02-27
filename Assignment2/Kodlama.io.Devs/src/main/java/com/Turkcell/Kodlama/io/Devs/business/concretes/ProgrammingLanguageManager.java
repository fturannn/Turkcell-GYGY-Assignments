package com.Turkcell.Kodlama.io.Devs.business.concretes;

import com.Turkcell.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import com.Turkcell.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.Turkcell.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return programmingLanguageRepository.getById(id);
    }

    @Override
    public ProgrammingLanguage save(ProgrammingLanguage programmingLanguage) {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.getAll();
        for(ProgrammingLanguage language : programmingLanguages) {
            if(language.getName().equals(programmingLanguage.getName())) {
                throw new RuntimeException("Aynı isimde programlama dili ekleyemezsiniz!");
            }
        }
        return programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public void update(int id, String name) {
        programmingLanguageRepository.update(id, name);
    }

    @Override
    public void delete(int id) {
        programmingLanguageRepository.delete(id);
    }
}
