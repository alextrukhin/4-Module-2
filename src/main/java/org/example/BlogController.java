package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/articles")
public class BlogController {

    private ArticlesStore articlesStore;

    public BlogController() {
        this.articlesStore = new ArticlesStore();
    }

    public BlogController(ArticlesStore articlesStore) {
        this.articlesStore = articlesStore;
    }

    @GetMapping("/viewArticles")
    public String viewBooks(Model model) {
        model.addAttribute("articles", articlesStore.getArticles());
        return "view-articles";
    }

    @GetMapping("/addArticle")
    public String addBookView(Model model) {
        model.addAttribute("article", new Article());
        return "add-article";
    }

    @PostMapping("/addArticle")
    public RedirectView addBook(@ModelAttribute("article") Article article, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/articles/addArticle", true);
        Article savedArticle = articlesStore.addArticle(article);
        redirectAttributes.addFlashAttribute("savedArticle", savedArticle);
        redirectAttributes.addFlashAttribute("addArticleSuccess", true);
        return redirectView;
    }

    @GetMapping("/article/{id}")
    public String showArticle(Model model, @PathVariable("id") String id) {
        Article article = articlesStore.getArticleById(Integer.parseInt(id));
        model.addAttribute("article", article);
        return "view-article";
    }
}