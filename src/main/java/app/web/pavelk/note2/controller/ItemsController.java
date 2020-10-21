package app.web.pavelk.note2.controller;

import app.web.pavelk.note2.model.Item;
import app.web.pavelk.note2.model.User;
import app.web.pavelk.note2.model.repo.ItemRepository;
import app.web.pavelk.note2.model.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ItemsController {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @GetMapping
    public String indexPage(Model model, Principal principal) {
        log.info("User name: {}", principal.getName());
        model.addAttribute("items", itemRepository.findByUserUsername(principal.getName()));
        model.addAttribute("item", new Item());
        return "index";
    }

    @PostMapping
    public String newShoppingItem(Item item, Principal principal) {
        log.info("User name: {}", principal.getName());

        User user = userRepository.findByUsername(principal.getName()).get();
        item.setUser(user);
        itemRepository.save(item);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteShoppingItem(@PathVariable("id") long id) {
        itemRepository.deleteById(id);
        return "redirect:/";
    }
}
