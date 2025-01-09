package fr.efrei.rag.repository.dto;

public class DocumentDTO {
    private String title;

    public DocumentDTO(String value) {
        this.title = value;
    }

    public String getTitle() {
        return title;
    }
}
