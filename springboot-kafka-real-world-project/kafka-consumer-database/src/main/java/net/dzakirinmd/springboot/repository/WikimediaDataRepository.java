package net.dzakirinmd.springboot.repository;

import net.dzakirinmd.springboot.model.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
}
