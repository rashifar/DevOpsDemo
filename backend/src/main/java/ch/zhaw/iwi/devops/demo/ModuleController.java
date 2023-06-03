package ch.zhaw.iwi.devops.demo;




import java.util.ArrayList;

import java.util.Comparator;

import java.util.HashMap;

import java.util.List;

import java.util.Map;




import org.springframework.boot.context.event.ApplicationReadyEvent;

import org.springframework.context.event.EventListener;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;




@CrossOrigin

@RestController

public class ModuleController {




    private Map<Integer, Module> modules = new HashMap<Integer, Module>();




    @EventListener(ApplicationReadyEvent.class)

    public void init() {

        this.modules.put(1, new Module(1, "Digitaltransformation", "Beschreibung 1"));

        this.modules.put(2, new Module(2, "Devops", "Beschreibung 2"));

        this.modules.put(3, new Module(3, "Leadership", "Beschreibung 3"));

        System.out.println("Init Data");

    }





    @GetMapping("/services/module")

    public List<PathListEntry<Integer>> module() {

        var result = new ArrayList<PathListEntry<Integer>>();

        for (var module : this.modules.values()) {

            var entry = new PathListEntry<Integer>();

            entry.setKey(module.getId(), "moduleKey");

            entry.setName(module.getTitle());

            entry.getDetails().add(module.getDescription());

            entry.setTooltip(module.getDescription());

            result.add(entry);

        }

        return result;

    }




    @GetMapping("/services/module/{id}")

    public Module getModule(@PathVariable Integer id) {

        return this.modules.get(id);

    }




    @PostMapping("/services/module")

    public void createModule(@RequestBody Module module) {

        var newId = this.modules.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;

        module.setId(newId);

        this.modules.put(newId, module);

    }




    @PutMapping("/services/module/{id}")

    public void updateModule(@PathVariable Integer id, @RequestBody Module module) {

        module.setId(id);

        this.modules.put(id, module);

    }




    @DeleteMapping("/services/module/{id}")

    public Module deleteModule(@PathVariable Integer id) {

        return this.modules.remove(id);

    }




}