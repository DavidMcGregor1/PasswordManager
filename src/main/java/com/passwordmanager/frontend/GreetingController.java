package com.passwordmanager.frontend;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.*;



@Controller
public class GreetingController {

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setViewNames(new String[] {"ui*"});

        System.out.println("Configured");
        return viewResolver;

    }


    public GreetingController(EntryRepository r){
        repo = r;
    }
           //  @Autowired
        private EntryRepository repo;




        @GetMapping("/uiGreeting")
        public String greeting(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
            model.addAttribute("name", name);
            System.out.println("fred!");
            return "greeting";
        }



        @ResponseStatus(value = HttpStatus.OK)
        @ResponseBody
        @PostMapping(path= "/apiAddEntry", consumes = "application/json", produces = "application/json")
        public  EntriesVm addEntry(@RequestBody EntriesVm newEntry) {
            System.out.println("starting");


            EntriesVm newEntriesVm = newEntry;
                    //new EntriesVm("newTitle", "newUser", "newPassword", "newNote");
            Entry newerEntry = new Entry();
            newerEntry.title = newEntry.title;
            newerEntry.username = newEntry.username;
            newerEntry.password = newEntry.password;
            newerEntry.notes = newEntry.notes;
            repo.save(newerEntry);
            newEntry.id = newerEntry.id;
            System.out.println(newEntry.title);
            return newEntriesVm;
        }


    @DeleteMapping(path= "/deleteEntry", consumes = "application/json", produces = "application/json")
    public  EntriesVm deleteEntry(@RequestBody EntriesVm newEntry) {
        EntriesVm newEntryToDelete = new EntriesVm(1);
        System.out.println(newEntry.title);
        return  newEntryToDelete;
    }



        @GetMapping("/uiPasswords")
        public String passwords(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
            model.addAttribute("name", name);
            List<Entry> allDbEntries = repo.findAll();

            System.out.println("returned " + allDbEntries.isEmpty() + " > "+allDbEntries.stream().count());

            List<EntriesVm> allUserEntries = new ArrayList<EntriesVm>();

            for (int i = 0; i < allDbEntries.stream().count(); i++) {
                Entry a = allDbEntries.get(i);
                if (a!=null) {
                    EntriesVm x = new EntriesVm(a.title, a.username, a.password, a.notes);
                    allUserEntries.add(x);
                }
            }


//            .\mvnw spring-boot:run




            model.addAttribute("userEntries", allUserEntries);

//            c_Apple;


            return "passwords";
        }

}


