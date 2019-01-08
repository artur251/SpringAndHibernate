package dudy.springdemo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "word")
    String word;
    @Column(name = "language")
    String language;
    @Column(name = "known_level")
    int knownLevel;
    @Column(name = "timestamp_insert")
    Date timestampInsert;
    @Column(name = "timestamp_update")
    Date timestampUpdate;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
//    @JoinColumn(name = "id")
//    private Translation translation;

    @OneToMany(mappedBy = "word", cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    private List<Translation> translations = new ArrayList<>();

    public Word() {
    }

    public Word(String word) {
        this.word = word;
    }

    public Word(String word, String language, int knownLevel, Date timestampInsert, Date timestampUpdate) {
        this.word = word;
        this.language = language;
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

    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", language='" + language + '\'' +
                ", knownLevel=" + knownLevel +
                ", timestampInsert=" + timestampInsert +
                ", timestampUpdate=" + timestampUpdate +
                ", translations=" + translations +
                '}';
    }
}
