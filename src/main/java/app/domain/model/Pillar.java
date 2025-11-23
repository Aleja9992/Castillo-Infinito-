package app.domain.model;

public class Pillar {
    private Long id;
    private String name;
    private Integer posX;
    private Integer posY;
    private String status;

    public Pillar() {}
    public Pillar(Long id, String name, Integer posX, Integer posY, String status) {
        this.id = id; this.name = name; this.posX = posX; this.posY = posY; this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
