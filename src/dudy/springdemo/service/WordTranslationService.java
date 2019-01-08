package dudy.springdemo.service;

import dudy.springdemo.entity.Word;
import dudy.springdemo.entity.WordTranslation;

import java.util.ArrayList;
import java.util.List;

public interface WordTranslationService {
    public ArrayList<WordTranslation> getWordTranslations(Word word);
    public ArrayList<WordTranslation> getWordTranslations(String word);
}
