/*
 * Copyright 2019 Project OpenUBL, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Eclipse Public License - v 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.project.openubl.xsender.models.jpa.entities;

import io.github.project.openubl.xsender.models.ErrorType;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ubl_document")
public class UBLDocumentEntity extends PanacheEntityBase {

    @Id
    @Column(name = "id")
    @Access(AccessType.PROPERTY)
    private String id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "namespace_id")
    private NamespaceEntity namespace;

    @Type(type = "org.hibernate.type.YesNoType")
    @Column(name = "in_progress")
    private boolean inProgress;

    @NotNull
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "scheduled_delivery")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledDelivery;

    @Type(type = "org.hibernate.type.YesNoType")
    @Column(name = "file_valid")
    private Boolean fileValid;

    @Enumerated(EnumType.STRING)
    @Column(name = "error")
    private ErrorType error;

    @NotNull
    @Column(name = "retries")
    private int retries;

    // XML Content

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "document_id")
    private String documentID;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "voided_line_document_type_code")
    private String voidedLineDocumentTypeCode;

    // Storage

    @NotNull
    @Column(name = "storage_file")
    private String storageFile;

    @Column(name = "storage_cdr")
    private String storageCdr;

    //

    @Column(name = "sunat_ticket")
    private String sunatTicket;

    @Column(name = "sunat_status")
    private String sunatStatus;

    @Column(name = "sunat_code")
    private Integer sunatCode;

    @Column(name = "sunat_description")
    private String sunatDescription;

    @ElementCollection
    @Column(name="value")
    @CollectionTable(name = "ubl_document_sunat_notes", joinColumns={ @JoinColumn(name="ubl_document_id") })
    private Set<String> sunatNotes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NamespaceEntity getNamespace() {
        return namespace;
    }

    public void setNamespace(NamespaceEntity namespace) {
        this.namespace = namespace;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getScheduledDelivery() {
        return scheduledDelivery;
    }

    public void setScheduledDelivery(Date scheduledDelivery) {
        this.scheduledDelivery = scheduledDelivery;
    }

    public Boolean getFileValid() {
        return fileValid;
    }

    public void setFileValid(Boolean fileValid) {
        this.fileValid = fileValid;
    }

    public ErrorType getError() {
        return error;
    }

    public void setError(ErrorType error) {
        this.error = error;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getVoidedLineDocumentTypeCode() {
        return voidedLineDocumentTypeCode;
    }

    public void setVoidedLineDocumentTypeCode(String voidedLineDocumentTypeCode) {
        this.voidedLineDocumentTypeCode = voidedLineDocumentTypeCode;
    }

    public String getStorageFile() {
        return storageFile;
    }

    public void setStorageFile(String storageFile) {
        this.storageFile = storageFile;
    }

    public String getStorageCdr() {
        return storageCdr;
    }

    public void setStorageCdr(String storageCdr) {
        this.storageCdr = storageCdr;
    }

    public String getSunatTicket() {
        return sunatTicket;
    }

    public void setSunatTicket(String sunatTicket) {
        this.sunatTicket = sunatTicket;
    }

    public String getSunatStatus() {
        return sunatStatus;
    }

    public void setSunatStatus(String sunatStatus) {
        this.sunatStatus = sunatStatus;
    }

    public Integer getSunatCode() {
        return sunatCode;
    }

    public void setSunatCode(Integer sunatCode) {
        this.sunatCode = sunatCode;
    }

    public String getSunatDescription() {
        return sunatDescription;
    }

    public void setSunatDescription(String sunatDescription) {
        this.sunatDescription = sunatDescription;
    }

    public Set<String> getSunatNotes() {
        return sunatNotes;
    }

    public void setSunatNotes(Set<String> sunatNotes) {
        this.sunatNotes = sunatNotes;
    }

    public static final class UBLDocumentEntityBuilder {
        private String id;
        private NamespaceEntity namespace;
        private boolean inProgress;
        private Date createdOn;
        private Date scheduledDelivery;
        private Boolean fileValid;
        private ErrorType error;
        private int retries;
        private String ruc;
        private String documentID;
        private String documentType;
        private String voidedLineDocumentTypeCode;
        private String storageFile;
        private String storageCdr;
        private String sunatTicket;
        private String sunatStatus;
        private Integer sunatCode;
        private String sunatDescription;
        private Set<String> sunatNotes;

        private UBLDocumentEntityBuilder() {
        }

        public static UBLDocumentEntityBuilder anUBLDocumentEntity() {
            return new UBLDocumentEntityBuilder();
        }

        public UBLDocumentEntityBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public UBLDocumentEntityBuilder withNamespace(NamespaceEntity namespace) {
            this.namespace = namespace;
            return this;
        }

        public UBLDocumentEntityBuilder withInProgress(boolean inProgress) {
            this.inProgress = inProgress;
            return this;
        }

        public UBLDocumentEntityBuilder withCreatedOn(Date createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public UBLDocumentEntityBuilder withScheduledDelivery(Date scheduledDelivery) {
            this.scheduledDelivery = scheduledDelivery;
            return this;
        }

        public UBLDocumentEntityBuilder withFileValid(Boolean fileValid) {
            this.fileValid = fileValid;
            return this;
        }

        public UBLDocumentEntityBuilder withError(ErrorType error) {
            this.error = error;
            return this;
        }

        public UBLDocumentEntityBuilder withRetries(int retries) {
            this.retries = retries;
            return this;
        }

        public UBLDocumentEntityBuilder withRuc(String ruc) {
            this.ruc = ruc;
            return this;
        }

        public UBLDocumentEntityBuilder withDocumentID(String documentID) {
            this.documentID = documentID;
            return this;
        }

        public UBLDocumentEntityBuilder withDocumentType(String documentType) {
            this.documentType = documentType;
            return this;
        }

        public UBLDocumentEntityBuilder withVoidedLineDocumentTypeCode(String voidedLineDocumentTypeCode) {
            this.voidedLineDocumentTypeCode = voidedLineDocumentTypeCode;
            return this;
        }

        public UBLDocumentEntityBuilder withStorageFile(String storageFile) {
            this.storageFile = storageFile;
            return this;
        }

        public UBLDocumentEntityBuilder withStorageCdr(String storageCdr) {
            this.storageCdr = storageCdr;
            return this;
        }

        public UBLDocumentEntityBuilder withSunatTicket(String sunatTicket) {
            this.sunatTicket = sunatTicket;
            return this;
        }

        public UBLDocumentEntityBuilder withSunatStatus(String sunatStatus) {
            this.sunatStatus = sunatStatus;
            return this;
        }

        public UBLDocumentEntityBuilder withSunatCode(Integer sunatCode) {
            this.sunatCode = sunatCode;
            return this;
        }

        public UBLDocumentEntityBuilder withSunatDescription(String sunatDescription) {
            this.sunatDescription = sunatDescription;
            return this;
        }

        public UBLDocumentEntityBuilder withSunatNotes(Set<String> sunatNotes) {
            this.sunatNotes = sunatNotes;
            return this;
        }

        public UBLDocumentEntity build() {
            UBLDocumentEntity uBLDocumentEntity = new UBLDocumentEntity();
            uBLDocumentEntity.setId(id);
            uBLDocumentEntity.setNamespace(namespace);
            uBLDocumentEntity.setInProgress(inProgress);
            uBLDocumentEntity.setCreatedOn(createdOn);
            uBLDocumentEntity.setScheduledDelivery(scheduledDelivery);
            uBLDocumentEntity.setFileValid(fileValid);
            uBLDocumentEntity.setError(error);
            uBLDocumentEntity.setRetries(retries);
            uBLDocumentEntity.setRuc(ruc);
            uBLDocumentEntity.setDocumentID(documentID);
            uBLDocumentEntity.setDocumentType(documentType);
            uBLDocumentEntity.setVoidedLineDocumentTypeCode(voidedLineDocumentTypeCode);
            uBLDocumentEntity.setStorageFile(storageFile);
            uBLDocumentEntity.setStorageCdr(storageCdr);
            uBLDocumentEntity.setSunatTicket(sunatTicket);
            uBLDocumentEntity.setSunatStatus(sunatStatus);
            uBLDocumentEntity.setSunatCode(sunatCode);
            uBLDocumentEntity.setSunatDescription(sunatDescription);
            uBLDocumentEntity.setSunatNotes(sunatNotes);
            return uBLDocumentEntity;
        }
    }
}
