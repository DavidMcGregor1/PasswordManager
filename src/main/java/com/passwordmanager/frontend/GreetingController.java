package com.passwordmanager.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;



@Controller
public class GreetingController {

    public GreetingController(EntryRepository r){
        repo = r;
    }
           //  @Autowired
        private EntryRepository repo;




        @GetMapping("/greeting")
        public String greeting(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
            model.addAttribute("name", name);
            System.out.println("fred!");
            return "greeting";
        }

        @GetMapping("/passwords")
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


