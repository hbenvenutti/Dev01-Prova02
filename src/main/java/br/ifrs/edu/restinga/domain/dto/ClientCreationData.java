package br.ifrs.edu.restinga.domain.dto;

public class ClientCreationData {
    private String name;
    private String cpf;
    private String email;
    private String[] phones;
    
    public ClientCreationData(String name, String cpf, String email, String[] phones) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    
}
