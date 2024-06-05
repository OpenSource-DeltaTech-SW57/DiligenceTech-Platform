package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Folder;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.entities.Document;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class FilesList {

    // attributes
    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL)
    private List<Document> documents;

    // constructors
    public FilesList() { this.documents = new ArrayList<>(); }

    // methods
}
