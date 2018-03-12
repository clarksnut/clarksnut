package org.clarksnut.migration;

import org.clarksnut.models.jpa.JpaImportedDocumentProvider;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Singleton
public class LuceneReindex {

    private static final Logger logger = Logger.getLogger(JpaImportedDocumentProvider.class);

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        FullTextEntityManager fullTextEm = Search.getFullTextEntityManager(em);
        try {
            logger.info("Trying to reindex lucene...");

            fullTextEm
                    .createIndexer()
                    .startAndWait();

            logger.info("Index process finished");
        } catch (InterruptedException e) {
            logger.error("Fatal error. Lucene could not re indexed");
        }
    }
}
