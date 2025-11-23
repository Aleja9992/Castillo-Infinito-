package app.adapter.in.rest.request;

public class UpdatePillarPositionRequest {
    private Long pillarId;
    private Integer posX;
    private Integer posY;
    private String status;


    public Long getPillarId() 
    {
        return pillarId; 
    }
    public void setPillarId(Long pillarId) 
    { 
        this.pillarId = pillarId; 
    }
    public Integer getPosX() 
    { 
        return posX; 
    }
    public void setPosX(Integer posX) 
    {
        this.posX = posX; 
    }
    public Integer getPosY() 
    { 
        return posY; 
    }
    public void setPosY(Integer posY) 
    { 
        this.posY = posY; 
    }
    public String getStatus() 
    { 
        return status; 
    }
    public void setStatus(String status) 
    { 
        this.status = status; 
    }
}
