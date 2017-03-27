/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "DOCUMENT")
@NamedQueries({
        @NamedQuery(name = "getAllDocumentsByAccountingCustomerParty", query = "select d from DocumentEntity d where d.accountingCustomerPartyId =:accountingCustomerPartyId"),
        @NamedQuery(name = "deleteDocumentsByAccountingCustomerParty", query = "delete from DocumentEntity d where d.accountingCustomerPartyId=:accountingCustomerPartyId")
})
public class DocumentEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    @NotNull
    @Column(name = "DOCUMENT_ID")
    private String documentId;

    @NotNull
    @Column(name = "DOCUMENT_TYPE")
    private String documentType;

    @NotNull
    @Column(name = "ACCOUNTING_CUSTOMER_PARTY_ID")
    private String accountingCustomerPartyId;

    @NotNull
    @Column(name = "XML_FILE_ID")
    private String xmlFileId;

    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @Column(name = "CREATED_TIMESTAMP")
    private LocalDateTime issueDate;

    @Column(name = "DOCUMENT_CURRENCY_CODE")
    private String documentCurrencyCode;

    @Column(name = "SUPPLIER_ASSIGNED_ACCOUNT_ID")
    private String supplierAssignedAccountId;

    @Column(name = "SUPPLIER_ADDITIONAL_ACCOUNT_ID")
    private String supplierAdditonalAccountId;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "document")
    private Collection<DocumentAttributeEntity> attributes = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.REMOVE}, orphanRemoval = true, mappedBy = "document", fetch = FetchType.LAZY)
    private Collection<DocumentLineEntity> lines = new ArrayList<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getAccountingCustomerPartyId() {
        return accountingCustomerPartyId;
    }

    public void setAccountingCustomerPartyId(String accountingCustomerPartyId) {
        this.accountingCustomerPartyId = accountingCustomerPartyId;
    }

    public String getXmlFileId() {
        return xmlFileId;
    }

    public void setXmlFileId(String xmlFileId) {
        this.xmlFileId = xmlFileId;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public String getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    public void setDocumentCurrencyCode(String documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }

    public String getSupplierAssignedAccountId() {
        return supplierAssignedAccountId;
    }

    public void setSupplierAssignedAccountId(String supplierAssignedAccountId) {
        this.supplierAssignedAccountId = supplierAssignedAccountId;
    }

    public String getSupplierAdditonalAccountId() {
        return supplierAdditonalAccountId;
    }

    public void setSupplierAdditonalAccountId(String supplierAdditonalAccountId) {
        this.supplierAdditonalAccountId = supplierAdditonalAccountId;
    }

    public Collection<DocumentAttributeEntity> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<DocumentAttributeEntity> attributes) {
        this.attributes = attributes;
    }

    public Collection<DocumentLineEntity> getLines() {
        return lines;
    }

    public void setLines(Collection<DocumentLineEntity> lines) {
        this.lines = lines;
    }
}
