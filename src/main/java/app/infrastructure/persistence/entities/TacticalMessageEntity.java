package app.infrastructure.persistence.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tactical_messages")
public class TacticalMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pillarId;
    @Column(columnDefinition = "TEXT")
    private String fragmentedContent;
    @Column(columnDefinition = "TEXT")
    private String reconstructedContent;
    private LocalDateTime timestamp;

    public TacticalMessageEntity() {

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
