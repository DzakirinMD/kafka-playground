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
    @SequenceGenerator(
            name = "wikimediadata_recentchange_sequence",
            sequenceName = "wikimediadata_recentchange_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =GenerationType.SEQUENCE,
            generator = "wikimediadata_recentchange_sequence"
    )
    private Long id;

    // Using LOB due to wiki even data is too large
    @Lob
    private String wikiEventData;
}
