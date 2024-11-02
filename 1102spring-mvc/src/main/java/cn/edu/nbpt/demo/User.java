package cn.edu.nbpt.demo;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String name;
    private String clazz;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getClazz() {return clazz;}
    public void setClazz(String clazz) {this.clazz = clazz;}

    private Integer age;
    public Integer getAge() {return age;}
    public void setAge(Integer age) {this.age = age;}

    private String password;
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    private List<String>hobby;
    public List<String> getHobby() {return hobby;}
    public void setHobby(List<String> hobby) {this.hobby = hobby;}

    private String hobbyString;
    public String gethobbyString() {return String.join(",", hobby);}

    private Address address;
    public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}

    private String addressString;
    public String getaddressString() {return address.getProvince() + address.getCity();}

    private Date birthday;
    public Date getBirthday() {return birthday;}
    public void setBirthday(Date birthday) {this.birthday = birthday;}

    private List<Roles> roles;
    public List<Roles> getRoles() {return roles;}
    public void setRoles(List<Roles> roles) {
        this.roles = roles;
        setRoleIds(roles.stream().map(Roles::getId).collect(Collectors.toList()));
    }

    private List<Integer> RoleIds;
    public List<Integer> getRoleIds() {return RoleIds;}
    public void setRoleIds(List<Integer> roleIds) {RoleIds = roleIds;}
}
