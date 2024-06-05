package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Folder;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class InnerFolders {

    // attributes
    @OneToMany
    private List<Folder> folders;

    // constructors
    public InnerFolders() { this.folders = new ArrayList<>(); }

    // methods
}
