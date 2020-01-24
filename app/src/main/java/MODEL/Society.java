package MODEL;

public class Society {
    private String society_name;
    private String society_reg_no;
    private String society_mobileno;
    private String society_emailid;
    private String society_address;
    private String society_uid;

    public String getSociety_admin_uid() {
        return society_admin_uid;
    }

    public void setSociety_admin_uid(String society_admin_uid) {
        this.society_admin_uid = society_admin_uid;
    }

    private String society_buildings;
    private String society_bunglows;
    private String society_rowhouses;
    private String society_admin_uid;

    public Society() {
    }

    public Society(String society_name, String society_reg_no, String society_mobileno, String society_emailid, String society_address, String society_uid, String society_buildings, String society_bunglows, String society_rowhouses, String society_admin_uid) {
        this.society_name = society_name;
        this.society_reg_no = society_reg_no;
        this.society_mobileno = society_mobileno;
        this.society_emailid = society_emailid;
        this.society_address = society_address;
        this.society_uid = society_uid;
        this.society_buildings = society_buildings;
        this.society_bunglows = society_bunglows;
        this.society_rowhouses = society_rowhouses;
        this.society_admin_uid = society_admin_uid;
    }

    public String getSociety_name() {
        return society_name;
    }

    public void setSociety_name(String society_name) {
        this.society_name = society_name;
    }

    public String getSociety_reg_no() {
        return society_reg_no;
    }

    public void setSociety_reg_no(String society_reg_no) {
        this.society_reg_no = society_reg_no;
    }

    public String getSociety_mobileno() {
        return society_mobileno;
    }

    public void setSociety_mobileno(String society_mobileno) {
        this.society_mobileno = society_mobileno;
    }

    public String getSociety_emailid() {
        return society_emailid;
    }

    public void setSociety_emailid(String society_emailid) {
        this.society_emailid = society_emailid;
    }

    public String getSociety_address() {
        return society_address;
    }

    public void setSociety_address(String society_address) {
        this.society_address = society_address;
    }

    public String getSociety_uid() {
        return society_uid;
    }

    public void setSociety_uid(String society_uid) {
        this.society_uid = society_uid;
    }

    public String getSociety_buildings() {
        return society_buildings;
    }

    public void setSociety_buildings(String society_buildings) {
        this.society_buildings = society_buildings;
    }

    public String getSociety_bunglows() {
        return society_bunglows;
    }

    public void setSociety_bunglows(String society_bunglows) {
        this.society_bunglows = society_bunglows;
    }

    public String getSociety_rowhouses() {
        return society_rowhouses;
    }

    public void setSociety_rowhouses(String society_rowhouses) {
        this.society_rowhouses = society_rowhouses;
    }
}