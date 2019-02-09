package dudy.springdemo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by admin on 11.11.2018.
 */
@Entity
@Table(name = "translations")
public class Translation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "language")
    String language;
    @Column(name = "id_source")
    int idSource;
    @Column(name = "id_word")
    int idWord;
    @Column(name = "sentence")
    String sentence;
    @Column(name = "translation")
    String translation;
    @Column(name = "timestamp_insert")
    Timestamp timestampInsert;
    @Column(name = "timestamp_update")
    Timestamp timestampUpdate;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    //@JoinColumn(name="productId",referencedColumnName="id_product", insertable=false, updatable=false)
    @JoinColumn(name = "id_word", insertable=false, updatable=false)
    private Word word;

    public Translation() {
    }

    public Translation(String translation) {
        this.translation = translation;
    }

    public Translation(String language, int idSource, String sentence, String translation, Timestamp timestampInsert, Timestamp timestampUpdate) {
        this.language = language;
        this.idSource = idSource;
        this.sentence = sentence;
        this.translation = translation;
        this.timestampInsert = timestampInsert;
        this.timestampUpdate = timestampUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getIdSource() {
        return idSource;
    }

    public void setIdSource(int idSource) {
        this.idSource = idSource;
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

    public Date getTimestampInsert() {
        return timestampInsert;
    }

    public void setTimestampInsert(Timestamp timestampInsert) {
        this.timestampInsert = timestampInsert;
    }

    public Timestamp getTimestampUpdate() {
        return timestampUpdate;
    }

    public void setTimestampUpdate(Timestamp timestampUpdate) {
        this.timestampUpdate = timestampUpdate;
    }

    public int getIdWord() {
        return idWord;
    }

    public void setIdWord(int idWord) {
        this.idWord = idWord;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Translation{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", idSource=" + idSource +
                ", idWord=" + idWord +
                ", sentence='" + sentence + '\'' +
                ", translation='" + translation + '\'' +
                ", timestampInsert=" + timestampInsert +
                ", timestampUpdate=" + timestampUpdate +
                //", word=" + word +
                '}';
    }
}
