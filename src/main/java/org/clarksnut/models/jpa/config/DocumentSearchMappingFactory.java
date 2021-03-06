package org.clarksnut.models.jpa.config;

import org.clarksnut.models.jpa.entity.DocumentEntity;
import org.clarksnut.models.jpa.entity.PartyEntity;
import org.hibernate.search.annotations.*;
import org.hibernate.search.bridge.builtin.impl.BuiltinIterableBridge;
import org.hibernate.search.cfg.SearchMapping;

import java.lang.annotation.ElementType;

public class DocumentSearchMappingFactory {

    @Factory
    public SearchMapping getSearchMapping() {
        SearchMapping mapping = new SearchMapping();

        mapping.entity(DocumentEntity.class).indexed()
                .property("id", ElementType.FIELD).documentId().name("id")

                /*
                 * Basic attributes */
                .property("type", ElementType.FIELD).field().name("type").analyze(Analyze.NO).facet()
                .property("currency", ElementType.FIELD).field().name("currency").analyze(Analyze.NO).facet()
                .property("provider", ElementType.FIELD).field().name("provider").analyze(Analyze.NO).facet()

                /*
                 * Supplier */
                .property("supplierName", ElementType.FIELD)
                .field().name("supplierName").index(Index.YES).store(Store.YES).analyze(Analyze.YES).analyzer("standardAnalyzer")
                .field().name("nGramSupplierName").index(Index.YES).store(Store.NO).analyze(Analyze.YES).analyzer("autocompleteNGramAnalyzer")
                .field().name("edgeNGramSupplierName").index(Index.YES).store(Store.NO).analyze(Analyze.YES).analyzer("autocompleteEdgeAnalyzer")

                .property("supplierAssignedId", ElementType.FIELD)
                .field().name("supplierAssignedId").index(Index.YES).store(Store.YES).analyze(Analyze.YES).analyzer("standardAnalyzer")
                /*
                 * Customer */
                .property("customerName", ElementType.FIELD)
                .field().name("customerName").index(Index.YES).store(Store.YES).analyze(Analyze.YES).analyzer("standardAnalyzer")
                .field().name("nGramCustomerName").index(Index.YES).store(Store.NO).analyze(Analyze.YES).analyzer("autocompleteNGramAnalyzer")
                .field().name("edgeNGramCustomerName").index(Index.YES).store(Store.NO).analyze(Analyze.YES).analyzer("autocompleteEdgeAnalyzer")

                .property("customerAssignedId", ElementType.FIELD)
                .field().name("customerAssignedId").index(Index.YES).store(Store.YES).analyze(Analyze.YES).analyzer("standardAnalyzer")

                /*
                 * Additional information */
                .property("assignedId", ElementType.FIELD)
                .field().name("assignedId").analyze(Analyze.NO).sortableField()
                .field().name("nGramAssignedId").index(Index.YES).store(Store.NO).analyze(Analyze.YES).analyzer("autocompleteNGramAnalyzer")
                .field().name("edgeNGramAssignedId").index(Index.YES).store(Store.NO).analyze(Analyze.YES).analyzer("autocompleteEdgeAnalyzer")

                .property("amount", ElementType.FIELD)
                .field().name("amount").analyze(Analyze.NO).sortableField()
                .field().name("amountFacet").analyze(Analyze.NO).facet().encoding(FacetEncodingType.LONG)

                .property("issueDate", ElementType.FIELD)
                .field().name("issueDate").analyze(Analyze.NO).sortableField().numericField().dateBridge(Resolution.MILLISECOND)
                .field().name("issueDateFacet").analyze(Analyze.NO).facet().encoding(FacetEncodingType.LONG)

                /*
                 * User interactions
                 * */
                .property("userViews", ElementType.FIELD)
                .field().name("userViews")
                .bridge(BuiltinIterableBridge.class)

                .property("userStarts", ElementType.FIELD)
                .field().name("userStarts")
                .bridge(BuiltinIterableBridge.class)

                .property("userChecks", ElementType.FIELD)
                .field().name("userChecks")
                .bridge(BuiltinIterableBridge.class);

        mapping.entity(PartyEntity.class).indexed()
                .property("id", ElementType.FIELD).documentId().name("id")

                .property("assignedId", ElementType.FIELD)
                .field().name("assignedId").index(Index.YES).store(Store.YES).analyze(Analyze.YES).analyzer("standardAnalyzer")
                .field().name("nGramPartyAssignedId").index(Index.YES).store(Store.NO).analyze(Analyze.YES).analyzer("autocompleteNGramAnalyzer")
                .field().name("edgeNGramAssignedId").index(Index.YES).store(Store.NO).analyze(Analyze.YES).analyzer("autocompleteEdgeAnalyzer")

                .property("name", ElementType.FIELD)
                .field().name("name").index(Index.YES).store(Store.YES).analyze(Analyze.YES).analyzer("standardAnalyzer")
                .field().name("nGramName").index(Index.YES).store(Store.NO).analyze(Analyze.YES).analyzer("autocompleteNGramAnalyzer")
                .field().name("edgeNGramName").index(Index.YES).store(Store.NO).analyze(Analyze.YES).analyzer("autocompleteEdgeAnalyzer")

                .property("names", ElementType.FIELD).indexEmbedded()
                .field().name("names").index(Index.YES).store(Store.YES).analyze(Analyze.YES).analyzer("standardAnalyzer")
                .field().name("nGramNames").index(Index.YES).store(Store.NO).analyze(Analyze.YES).analyzer("autocompleteNGramAnalyzer")
                .field().name("edgeNGramNames").index(Index.YES).store(Store.NO).analyze(Analyze.YES).analyzer("autocompleteEdgeAnalyzer")

                .property("spaceIds", ElementType.FIELD)
                .field().name("spaceIds")
                .bridge(BuiltinIterableBridge.class);

        return mapping;
    }

}
