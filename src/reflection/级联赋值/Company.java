package reflection.级联赋值;

import java.util.Date;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/1
 */
public class Company {
      private String name;
      private Date createdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
