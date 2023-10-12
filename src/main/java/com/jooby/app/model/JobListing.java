package com.jooby.app.model;
import lombok.Data;


@Data
public class JobListing {

    private int jobListingID;
    private String jobTitle;
    private String type;
    private String locationType;
    private String descriptionRoleAndResponsibilities;
    private String descriptionTechnicalRequirements;

    public JobListing(int jobListingID, String jobTitle, String type, String locationType, String descriptionRoleAndResponsibilities, String descriptionTechnicalRequirements) {
        this.jobListingID = jobListingID;
        this.jobTitle = jobTitle;
        this.type = type;
        this.locationType = locationType;
        this.descriptionRoleAndResponsibilities = descriptionRoleAndResponsibilities;
        this.descriptionTechnicalRequirements = descriptionTechnicalRequirements;
    }

    public JobListing(int jobListingID, String jobTitle) {
        this.jobListingID = jobListingID;
        this.jobTitle = jobTitle;
    }
}
