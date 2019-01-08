package dudy.springdemo.entity;

import javax.persistence.*;
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
    Date timestampInsert;
    @Column(name = "timestamp_update")
    Date timestampUpdate;

    public Translation() {
    }

    public Translation(String translation) {
        this.translation = translation;
    }

    public Translation(String language, int idSource, String sentence, String translation, Date timestampInsert, Date timestampUpdate) {
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
                ", language='" + language + '\'' +
                ", idSource=" + idSource +
                ", sentence='" + sentence + '\'' +
                ", translation='" + translation + '\'' +
                ", timestampInsert=" + timestampInsert +
                ", timestampUpdate=" + timestampUpdate +
                '}';
    }
}
