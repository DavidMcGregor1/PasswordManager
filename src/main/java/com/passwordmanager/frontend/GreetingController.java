package com.passwordmanager.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

@Controller
public class GreetingController {

        @GetMapping("/greeting")
        public String greeting(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
            model.addAttribute("name", name);
            System.out.println("fred!");
            return "greeting";
        }

        @GetMapping("/passwords")
        public String passwords(@RequestParam(name="name", required=false, defaultValue = "World") String name, Model model) {
            model.addAttribute("name", name);

            List<EntriesVm> allUserEntries = new ArrayList<EntriesVm>();
            allUserEntries.add(new EntriesVm("title1", "username1", "password1", "note1"));
            allUserEntries.add(new EntriesVm("title2", "username2", "password2", "note2"));
            allUserEntries.add(new EntriesVm("title3", "username3", "password3", "note3"));
            allUserEntries.add(new EntriesVm("title4", "username4", "password4", "note4"));
            allUserEntries.add(new EntriesVm("title5", "username5", "password5", "note5"));

            model.addAttribute("userEntries", allUserEntries);


            return "passwords";
        }

}


