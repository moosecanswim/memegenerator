package me.moosecanswim.memegenerator.model;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Uzer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    @Column(unique=true)
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;
    private Boolean active;
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Role> roles;
    @OneToMany(mappedBy="author",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<InputImage> inputImages;




    public Uzer(){
        setActive(true);
        this.setRoles(new HashSet<Role>());
        this.setInputImages(new HashSet<InputImage>());
    }
///////////////////////////overrides

    @Override
    public String toString(){
        return String.format("%s %s", this.getFirstName(), this.getLastName());
    }

    //////////////////////custom method

    public void addRole(Role r){
        System.out.println("Adding role: " + r.getRole());
        this.getRoles().add(r);
    }
    public void removeRole(Role r){
        System.out.println("Removing role: " + r.getRole());
        this.getRoles().remove(r);
    }

    /////////////////////////////getter and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<InputImage> getInputImages() {
        return inputImages;
    }

    public void setInputImages(Set<InputImage> inputImages) {
        this.inputImages = inputImages;
    }
}
