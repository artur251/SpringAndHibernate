package dudy.springdemo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 11.11.2018.
 */
@Entity
@Table(name = "words")
public class Translation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "word")
    String word;
    @Column(name = "language")
    String language;
    @Column(name = "source")
    String source;
    @Column(name = "sentence")
    String sentence;
    @Column(name = "translation")
    String translation;
    @Column(name = "known_level")
    int knownLevel;
    @Column(name = "timestamp_insert")
    Date timestampInsert;
    @Column(name = "timestamp_update")
    Date timestampUpdate;

    public Translation() {
    }

    public Translation(int id, String word, String language, String source, String sentence, String translation, int knownLevel, Date timestampInsert, Date timestampUpdate) {
        this.id = id;
        this.word = word;
        this.language = language;
        this.source = source;
        this.sentence = sentence;
        this.translation = translation;
        this.knownLevel = knownLevel;
        this.timestampInsert = timestampInsert;
        this.timestampUpdate = timestampUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public int getKnownLevel() {
        return knownLevel;
    }

    public void setKnownLevel(int knownLevel) {
        this.knownLevel = knownLevel;
    }

    public Date getTimestampInsert() {
        return timestampInsert;
    }

    public void setTimestampInsert(Date timestampInsert) {
        this.timestampInsert = timestampInsert;
    }

    public Date getTimestampUpdate() {
        return timestampUpdate;
    }

    public void setTimestampUpdate(Date timestampUpdate) {
        this.timestampUpdate = timestampUpdate;
    }

    @Override
    public String toString() {
        return "Translation{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", language='" + language + '\'' +
                ", source='" + source + '\'' +
                ", sentence='" + sentence + '\'' +
                ", translation='" + translation + '\'' +
                ", knownLevel=" + knownLevel +
                ", timestampInsert=" + timestampInsert +
                ", timestampUpdate=" + timestampUpdate +
                '}';
    }
}
