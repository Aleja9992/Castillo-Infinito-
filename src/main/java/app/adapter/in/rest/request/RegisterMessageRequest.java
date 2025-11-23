package app.adapter.in.rest.request;

public class RegisterMessageRequest {
    private Long pillarId;
    private String fragmentedContent;

   
    public Long getPillarId() 
    { 
        return pillarId; 
    }
    public void setPillarId(Long pillarId) 
    { 
        this.pillarId = pillarId; 
    }
    public String getFragmentedContent() 
    { 
        return fragmentedContent; 
    }
    public void setFragmentedContent(String fragmentedContent) 
    { 
        this.fragmentedContent = fragmentedContent; 
    }
}
