package Model;

public class Proceeding {
    private String Proceeding_ID;
    private String Proceeding_Name;
    private String Proceeding_Description;
    private String Proceeding_Status;
    private Module module;

    public Proceeding(String proceeding_ID, String proceeding_Name, String proceeding_Description, String proceeding_Status, Module module) {
        Proceeding_ID = proceeding_ID;
        Proceeding_Name = proceeding_Name;
        Proceeding_Description = proceeding_Description;
        Proceeding_Status = proceeding_Status;
        this.module = module;
    }

    public String getProceeding_ID() {
        return Proceeding_ID;
    }

    public void setProceeding_ID(String proceeding_ID) {
        Proceeding_ID = proceeding_ID;
    }

    public String getProceeding_Name() {
        return Proceeding_Name;
    }

    public void setProceeding_Name(String proceeding_Name) {
        Proceeding_Name = proceeding_Name;
    }

    public String getProceeding_Description() {
        return Proceeding_Description;
    }

    public void setProceeding_Description(String proceeding_Description) {
        Proceeding_Description = proceeding_Description;
    }

    public String getProceeding_Status() {
        return Proceeding_Status;
    }

    public void setProceeding_Status(String proceeding_Status) {
        Proceeding_Status = proceeding_Status;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
