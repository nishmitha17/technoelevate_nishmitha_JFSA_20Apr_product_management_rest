package com.te.productmanagementrest.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table
@XmlRootElement(name="employee-info")
@JsonRootName("employee-information")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ManagerBean implements Serializable {
	
	@Id
	@XmlElement
	@JsonProperty
	private int id;
	
	@XmlElement
	@JsonProperty
	private String name;
	
	@XmlElement
	@JsonProperty
	private String password;

}
