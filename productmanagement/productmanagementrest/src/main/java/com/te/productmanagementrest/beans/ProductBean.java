package com.te.productmanagementrest.beans;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="products")
@XmlRootElement(name = "product=info")
@JsonRootName("product-information")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductBean implements Serializable {

	@Id
	@XmlElement
	@JsonProperty
	private int pid;

	@XmlElement
	@JsonProperty
	private String pname;

	@XmlElement
	@JsonProperty
	private Date mfg;

	@XmlElement
	@JsonProperty
	private Date exp;

	@XmlElement
	@JsonProperty
	private int price;

	@XmlElement
	@JsonProperty
	private int qunatity;

}
