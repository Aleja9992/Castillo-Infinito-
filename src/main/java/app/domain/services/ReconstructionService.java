package app.domain.services;

import org.springframework.stereotype.Service;

@Service
public class ReconstructionService {

    
    public String reconstructAutomatically(String fragmented) {
        if (fragmented == null) return null;
        return fragmented.replace("...", "");
    }

    public String reconstruct(String fragmentedContent) {
        if (fragmentedContent == null) return null;
        return fragmentedContent.replace("...", "");
    }
}
