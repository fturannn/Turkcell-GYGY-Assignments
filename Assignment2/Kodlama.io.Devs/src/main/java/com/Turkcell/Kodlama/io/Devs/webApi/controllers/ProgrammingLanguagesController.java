package com.Turkcell.Kodlama.io.Devs.webApi.controllers;

import com.Turkcell.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import com.Turkcell.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController {

    private ProgrammingLanguageService programmingLanguageService;

    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public ProgrammingLanguage getById(@PathVariable int id) {
        return programmingLanguageService.getById(id);
    }

    @PostMapping
    public ProgrammingLanguage save(@RequestBody ProgrammingLanguage request) {
        return programmingLanguageService.save(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody String name) {
        programmingLanguageService.update(id, name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        programmingLanguageService.delete(id);
    }
}
