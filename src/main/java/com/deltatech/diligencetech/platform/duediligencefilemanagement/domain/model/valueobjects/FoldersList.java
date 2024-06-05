package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Folder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class FoldersList {

    // attributes
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Folder> folders;

    // constructors
    public FoldersList() { this.folders = new ArrayList<>(); }

    // methods
}
