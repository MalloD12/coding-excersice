package model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@NonNull
public class Organisation
{
  private final static String parentOrganisation = "default";
  private String businessName;
  private String industry;
  private String country;
  private boolean hasEmployees;
  private boolean registeredForGST;

  public static String getParentOrganisation()
  {
    return parentOrganisation;
  }
}
