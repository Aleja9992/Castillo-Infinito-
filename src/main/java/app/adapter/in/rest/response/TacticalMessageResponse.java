package app.adapter.in.rest.response;

import java.time.LocalDateTime;

public class TacticalMessageResponse {
    private Long id;
    private Long pillarId;
    private String fragmentedContent;
    private String reconstructedContent;
    private LocalDateTime timestamp;

    public TacticalMessageResponse(Long id, Long pillarId, String fragmentedContent, String reconstructedContent, LocalDateTime timestamp) {
        this.id = id;
        this.pillarId = pillarId;
        this.fragmentedContent = fragmentedContent;
        this.reconstructedContent = reconstructedContent;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPillarId() {
        return pillarId;
    }

    public void setPillarId(Long pillarId) {
        this.pillarId = pillarId;
    }

    public String getFragmentedContent() {
        return fragmentedContent;
    }

    public void setFragmentedContent(String fragmentedContent) {
        this.fragmentedContent = fragmentedContent;
    }

    public String getReconstructedContent() {
        return reconstructedContent;
    }

    public void setReconstructedContent(String reconstructedContent) {
        this.reconstructedContent = reconstructedContent;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
