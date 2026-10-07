package model;

import java.sql.Date;

public class Dependente {
    private int id;
    private String nome;
    private Date dataNascimento;
    private String sexo;
    private String alergias;
    private int responsavelId;
    private String nomeResponsavel;

    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
    public Date getDataNascimento(){return dataNascimento;} public void setDataNascimento(Date v){dataNascimento=v;}
    public String getSexo(){return sexo;} public void setSexo(String sexo){this.sexo=sexo;}
    public String getAlergias(){return alergias;} public void setAlergias(String alergias){this.alergias=alergias;}
    public int getResponsavelId(){return responsavelId;} public void setResponsavelId(int id){responsavelId=id;}
    public String getNomeResponsavel(){return nomeResponsavel;} public void setNomeResponsavel(String n){nomeResponsavel=n;}
    @Override public String toString(){return nomeResponsavel==null?nome:nome+" - "+nomeResponsavel;}
}