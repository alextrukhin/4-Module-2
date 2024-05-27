package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArticlesStore {
    public final static String fileName = "articles.json";

    public List<Article> articles = new ArrayList<>();

    public ArticlesStore() {
        articles = readFromFile();
    }

    public List<Article> getArticles() {
        return articles;
    }

    public Article getArticleById(Integer id) {
        for (Article article : articles) {
            if (Objects.equals(article.id, id)) {
                return article;
            }
        }
        return null;
    }

    public Article addArticle(Article article) {
        int highestId = 0;
        for (Article a : articles) {
            if (a.id > highestId) {
                highestId = a.id;
            }
        }
        Instant instant
                = Instant.now();
        article.created_at = instant.getEpochSecond();
        article.id = highestId + 1;
        articles.add(article);
        saveListToFile(articles);
        return article;
    }

    private List<Article> readFromFile() {
        Type REVIEW_TYPE = new TypeToken<List<Article>>() {
        }.getType();
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            saveListToFile(articles);
            return articles;
        }
        return gson.fromJson(reader, REVIEW_TYPE);
    }

    private void saveListToFile(List<Article> list) {
        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(list, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
