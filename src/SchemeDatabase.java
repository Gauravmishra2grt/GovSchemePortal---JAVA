
import java.util.ArrayList;
import java.util.List;

public class SchemeDatabase {
    
    // Yeh method saari schemes ki list return karega
    public static List<Scheme> getAllSchemes() {
        List<Scheme> schemesList = new ArrayList<>();
        
        schemesList.add(new Scheme("Kisan Samman Nidhi", "Agriculture", 
                "Financial support of ₹6,000 per year directly transferred to farmers.", 
                "Farmers with cultivable land up to 2 hectares.", "https://pmkisan.gov.in/"));
                
        schemesList.add(new Scheme("National Scholarship Portal", "Education", 
                "Digital platform for students to apply for various government scholarships.", 
                "Students from class 1 to Post-Graduation.", "https://scholarships.gov.in/"));
                
        schemesList.add(new Scheme("Ayushman Bharat Yojana", "Healthcare", 
                "Health insurance coverage up to ₹5 lakhs per family per year.", 
                "Economically weaker sections (BPL families).", "https://pmjay.gov.in/"));
                
        schemesList.add(new Scheme("PM Fasal Bima Yojana", "Agriculture", 
                "Crop insurance scheme to protect farmers against financial loss.", 
                "All farmers growing notified crops.", "https://pmfby.gov.in/"));
                
        schemesList.add(new Scheme("MyScheme Portal", "Education", 
                "Centralized platform to find all government schemes you are eligible for.", 
                "Varies based on scheme.", "https://www.myscheme.gov.in/"));
                
        return schemesList;
    }
}