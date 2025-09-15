package com.example.Valorant_Team_picker;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //the player is the entity/object in the table
@Table(name="vlr_stats")
public class Player{
    @Id
    @Column(name="Player")
    private String name; //primary key
    private String team;
    private String agent;
    private Integer rnd;
    private Float r;
    private Float acs;
    private Float kd;
    private Float ksat;
    private Float adr;
    private Float kpr;
    private Float fkpr;
    private Float fdpr;
    private Float hs;
    private Float cl;
    private Float kmax;
    private Integer k;
    private Integer a;
    private Integer d;
    private Integer fk;
    private Integer fd;

    //constructor
    public Player(String name, String team, String agent, Integer rnd, Float r, Float acs, Float kd, Float ksat, Float adr, Float kpr, Float fkpr, Float fdpr, Float hs, Float cl, Float kmax, Integer k, Integer a, Integer d, Integer fk, Integer fd) {
        this.name = name;
        this.team = team;
        this.agent = agent;
        this.rnd = rnd;
        this.r = r;
        this.acs = acs;
        this.kd = kd;
        this.ksat = ksat;
        this.adr = adr;
        this.kpr = kpr;
        this.fkpr = fkpr;
        this.fdpr = fdpr;
        this.hs = hs;
        this.cl = cl;
        this.kmax = kmax;
        this.k = k;
        this.a = a;
        this.d = d;
        this.fk = fk;
        this.fd = fd;
    }

    public Player() {

    }

    /*
    List of getters/setters for players data
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Integer getRnd() {
        return rnd;
    }

    public void setRnd(Integer rnd) {
        this.rnd = rnd;
    }

    public Float getR() {
        return r;
    }

    public void setR(Float r) {
        this.r = r;
    }

    public Float getAcs() {
        return acs;
    }

    public void setAcs(Float acs) {
        this.acs = acs;
    }

    public Float getKd() {
        return kd;
    }

    public void setKd(Float kd) {
        this.kd = kd;
    }

    public Float getKsat() {
        return ksat;
    }

    public void setKsat(Float ksat) {
        this.ksat = ksat;
    }

    public Float getAdr() {
        return adr;
    }

    public void setAdr(Float adr) {
        this.adr = adr;
    }

    public Float getKpr() {
        return kpr;
    }

    public void setKpr(Float kpr) {
        this.kpr = kpr;
    }

    public Float getFkpr() {
        return fkpr;
    }

    public void setFkpr(Float fkpr) {
        this.fkpr = fkpr;
    }

    public Float getFdpr() {
        return fdpr;
    }

    public void setFdpr(Float fdpr) {
        this.fdpr = fdpr;
    }

    public Float getHs() {
        return hs;
    }

    public void setHs(Float hs) {
        this.hs = hs;
    }

    public Float getCl() {
        return cl;
    }

    public void setCl(Float cl) {
        this.cl = cl;
    }

    public Float getKmax() {
        return kmax;
    }

    public void setKmax(Float kmax) {
        this.kmax = kmax;
    }

    public Integer getK() {
        return k;
    }

    public void setK(Integer k) {
        this.k = k;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    public Integer getFk() {
        return fk;
    }

    public void setFk(Integer fk) {
        this.fk = fk;
    }

    public Integer getFd() {
        return fd;
    }

    public void setFd(Integer fd) {
        this.fd = fd;
    }
}




