package model;

import java.sql.Date;
import java.sql.Time;

public class Consulta {
    private int id, dependenteId;
    private Date dataConsulta;
    private Time horario;
    private String motivo;
    private String nomeDependente, sexoDependente, alergiasDependente, nomeResponsavel, cpfResponsavel, telefoneResponsavel, emailResponsavel;
    private Date nascimentoDependente;
    public int getId(){return id;} public void setId(int v){id=v;}
    public int getDependenteId(){return dependenteId;} public void setDependenteId(int v){dependenteId=v;}
    public Date getDataConsulta(){return dataConsulta;} public void setDataConsulta(Date v){dataConsulta=v;}
    public Time getHorario(){return horario;} public void setHorario(Time v){horario=v;}
    public String getMotivo(){return motivo;} public void setMotivo(String v){motivo=v;}
    public String getNomeDependente(){return nomeDependente;} public void setNomeDependente(String v){nomeDependente=v;}
    public Date getNascimentoDependente(){return nascimentoDependente;} public void setNascimentoDependente(Date v){nascimentoDependente=v;}
    public String getSexoDependente(){return sexoDependente;} public void setSexoDependente(String v){sexoDependente=v;}
    public String getAlergiasDependente(){return alergiasDependente;} public void setAlergiasDependente(String v){alergiasDependente=v;}
    public String getNomeResponsavel(){return nomeResponsavel;} public void setNomeResponsavel(String v){nomeResponsavel=v;}
    public String getCpfResponsavel(){return cpfResponsavel;} public void setCpfResponsavel(String v){cpfResponsavel=v;}
    public String getTelefoneResponsavel(){return telefoneResponsavel;} public void setTelefoneResponsavel(String v){telefoneResponsavel=v;}
    public String getEmailResponsavel(){return emailResponsavel;} public void setEmailResponsavel(String v){emailResponsavel=v;}
}