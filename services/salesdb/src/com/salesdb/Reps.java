/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.salesdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;





/**
 * Reps generated by hbm2java
 */
@Entity
@Table(name="REPS"
    ,schema="PUBLIC"
    ,catalog="PUBLIC"
)
public class Reps  implements java.io.Serializable {


     private Integer id;
     private Channels channels;
     private String name;
     private String street;
     private String city;
     private String state;
     private String zip;
     private String picurl;
     private String password;
     private String role;
     private Set<Quotes> quoteses = new HashSet<Quotes>(0);
     private Set<Tasks> taskses = new HashSet<Tasks>(0);

    public Reps() {
    }

	
    public Reps(String name) {
        this.name = name;
    }
    public Reps(Channels channels, String name, String street, String city, String state, String zip, String picurl, String password, String role, Set<Quotes> quoteses, Set<Tasks> taskses) {
       this.channels = channels;
       this.name = name;
       this.street = street;
       this.city = city;
       this.state = state;
       this.zip = zip;
       this.picurl = picurl;
       this.password = password;
       this.role = role;
       this.quoteses = quoteses;
       this.taskses = taskses;
    }

     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CHANNEL_TYPE")
    public Channels getChannels() {
        return this.channels;
    }
    
    public void setChannels(Channels channels) {
        this.channels = channels;
    }

    
    @Column(name="NAME", nullable=false, length=32)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="STREET", length=64)
    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }

    
    @Column(name="CITY", length=32)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="STATE", length=2)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    
    @Column(name="ZIP", length=6)
    public String getZip() {
        return this.zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }

    
    @Column(name="PICURL", length=1024)
    public String getPicurl() {
        return this.picurl;
    }
    
    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    
    @Column(name="PASSWORD", length=32)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="ROLE", length=32)
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="reps")
    public Set<Quotes> getQuoteses() {
        return this.quoteses;
    }
    
    public void setQuoteses(Set<Quotes> quoteses) {
        this.quoteses = quoteses;
    }

@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="reps")
    public Set<Tasks> getTaskses() {
        return this.taskses;
    }
    
    public void setTaskses(Set<Tasks> taskses) {
        this.taskses = taskses;
    }



public boolean equals(Object o) {
         if (this == o)
         return true;
		 if ( (o == null ) )
		 return false;
		 if ( !(o instanceof Reps) )
		 return false;

		 Reps that = ( Reps ) o;

		 return ( (this.getId()==that.getId()) || ( this.getId()!=null && that.getId()!=null && this.getId().equals(that.getId()) ) );

   }

   public int hashCode() {
         int result = 17;

         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );

         return result;
     }


}
