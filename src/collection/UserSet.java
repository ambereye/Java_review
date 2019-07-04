package collection;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/6/25
 */
public class UserSet {
    private Integer id;
    private String  username;

    public UserSet(Integer id, String username) {
        this.id = id;
        this.username = username;
    }
    /**
     * 如果对象类型是User,先比较hashcode，一致的场合再比较每个属性的值
     */
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        if(obj instanceof UserSet){
            UserSet userSet = (UserSet)obj;
            // if(user.id = this.id) return true; // 只比较id
            // 比较每个属性的值 一致时才返回true
            if (userSet.id .equals(this.id)  && userSet.username.equals(this.username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 重写hashcode 方法，返回的hashCode不一样才再去比较每个属性的值
     */
    @Override
    public int hashCode(){
        // return id.hashCode();
        return id.hashCode() * username.hashCode();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
