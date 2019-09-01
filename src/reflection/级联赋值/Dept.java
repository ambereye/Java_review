package reflection.级联赋值;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/1
 */
public class Dept {
      private String dname;
      private String loc;
      private Company company;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
