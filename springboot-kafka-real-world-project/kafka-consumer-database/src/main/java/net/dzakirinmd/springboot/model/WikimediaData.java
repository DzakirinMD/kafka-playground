package net.dzakirinmd.springboot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "wikimediadata_recentchange")
@Getter
@Setter
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Using LOB due to wiki even data is too large
     * <a href="https://stackoverflow.com/questions/67261808/jpa-with-postgres-anomalously-writes-text-in-lob-column-as-a-number">postgress LOB issue</a>
     * LOB column require @Column(columnDefinition = "text"), which requires not to use @Lob at Strings at all
     */
    @Column(columnDefinition = "text")
    private String wikiEventData;
}
