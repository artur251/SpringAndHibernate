package dudy.springdemo.entity;

import java.util.List;
public class WordTranslation {
    Word word;
    List<Translation> translation;

    public WordTranslation() {
    }

    public WordTranslation(Word word, List<Translation> translation) {
        this.word = word;
        this.translation = translation;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public List<Translation> getTranslation() {
        return translation;
    }

    public void setTranslation(List<Translation> translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return "WordTranslation{" +
                "word=" + word +
                ", translation=" + translation +
                '}';
    }
}
