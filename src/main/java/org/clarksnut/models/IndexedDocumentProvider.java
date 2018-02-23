package org.clarksnut.models;

public interface IndexedDocumentProvider {

    /**
     * @param documentId unique identity generated by the system
     * @return document
     */
    IndexedDocumentModel getIndexedDocument(String documentId);

    /**
     * @return list of documents
     */
    SearchResultModel<IndexedDocumentModel> getDocumentsUser(IndexedDocumentQueryModel query, SpaceModel... space);
}
