package at.michaelkoenig.lab0701.controller;

import at.michaelkoenig.lab0701.model.Person;
import at.michaelkoenig.lab0701.model.Sex;
import at.michaelkoenig.lab0701.repo.HobbyRepo;
import at.michaelkoenig.lab0701.repo.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @author Michael König
 */
@Controller
@RequiredArgsConstructor
public class AppController {

    private final HobbyRepo hobbyRepo;
    private final PersonRepo personRepo;

    @GetMapping("/")
    public String index() {
        return "redirect:/neuePerson";
    }

    @GetMapping("/showHobbies")
    public String showHobbies(Model model) {
        model.addAttribute("persons", personRepo.findAll());

        return "showHobbies";
    }

    @GetMapping("/neuePerson")
    public String neuePerson(Model model) {
        model.addAttribute("hobbies", hobbyRepo.findAll());
        model.addAttribute("person", new Person());
        model.addAttribute("sex", Sex.values());

        return "neuePerson";
    }

    @PostMapping("/neuePerson")
    public String processInput(@ModelAttribute @Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(System.out::println);
        }

        System.out.println(person);
        personRepo.save(person);
        return "redirect:/showHobbies";
    }

}
