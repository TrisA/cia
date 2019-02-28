/*
 * Copyright 2010 James Pether Sörling
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *	$Id$
 *  $HeadURL$
*/
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.24 at 11:39:47 PM CET 
//


package com.hack23.cia.model.external.val.partier.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;

import com.hack23.cia.model.common.api.ModelObject;


/**
 * The Class SwedenElectionRegion.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SwedenElectionRegion", propOrder = {
    "countyId",
    "municipalId",
    "regionName",
    "parties"
})
@Entity(name = "SwedenElectionRegion")
@Table(name = "SWEDEN_ELECTION_REGION")
@Inheritance(strategy = InheritanceType.JOINED)
public class SwedenElectionRegion
    implements ModelObject, Equals
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The county id. */
    @XmlElement(name = "lan_id", required = true)
    protected String countyId;
    
    /** The municipal id. */
    @XmlElement(name = "kommun_id", required = true)
    protected String municipalId;
    
    /** The region name. */
    @XmlElement(name = "namn", required = true)
    protected String regionName;
    
    /** The parties. */
    @XmlElement(name = "parti", required = true)
    protected List<SwedenPoliticalParty> parties;
    
    /** The hjid. */
    @XmlAttribute(name = "Hjid")
    protected Long hjid;

    /**
	 * Gets the county id.
	 *
	 * @return the county id
	 */
    @Basic
    @Column(name = "COUNTY_ID")
    public String getCountyId() {
        return countyId;
    }

    /**
	 * Sets the county id.
	 *
	 * @param value the new county id
	 */
    public void setCountyId(final String value) {
        this.countyId = value;
    }

    /**
	 * Gets the municipal id.
	 *
	 * @return the municipal id
	 */
    @Basic
    @Column(name = "MUNICIPAL_ID")
    public String getMunicipalId() {
        return municipalId;
    }

    /**
	 * Sets the municipal id.
	 *
	 * @param value the new municipal id
	 */
    public void setMunicipalId(final String value) {
        this.municipalId = value;
    }

    /**
	 * Gets the region name.
	 *
	 * @return the region name
	 */
    @Basic
    @Column(name = "REGION_NAME")
    public String getRegionName() {
        return regionName;
    }

    /**
	 * Sets the region name.
	 *
	 * @param value the new region name
	 */
    public void setRegionName(final String value) {
        this.regionName = value;
    }

    /**
	 * Gets the parties.
	 *
	 * @return the parties
	 */
    @OneToMany(targetEntity = SwedenPoliticalParty.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "PARTIES_SWEDEN_ELECTION_REGI_0")
    public List<SwedenPoliticalParty> getParties() {
        if (parties == null) {
            parties = new ArrayList<>();
        }
        return this.parties;
    }

    /**
	 * Sets the parties.
	 *
	 * @param parties the new parties
	 */
    public void setParties(final List<SwedenPoliticalParty> parties) {
        this.parties = parties;
    }

    /**
	 * Gets the hjid.
	 *
	 * @return the hjid
	 */
    @Id
    @Column(name = "HJID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getHjid() {
        return hjid;
    }

    /**
	 * Sets the hjid.
	 *
	 * @param value the new hjid
	 */
    public void setHjid(final Long value) {
        this.hjid = value;
    }

    /* (non-Javadoc)
     * @see org.jvnet.jaxb2_commons.lang.Equals#equals(org.jvnet.jaxb2_commons.locator.ObjectLocator, org.jvnet.jaxb2_commons.locator.ObjectLocator, java.lang.Object, org.jvnet.jaxb2_commons.lang.EqualsStrategy)
     */
    public boolean equals(final ObjectLocator thisLocator, final ObjectLocator thatLocator, final Object object, final EqualsStrategy strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SwedenElectionRegion that = ((SwedenElectionRegion) object);
        {
            String lhsCountyId;
            lhsCountyId = this.getCountyId();
            String rhsCountyId;
            rhsCountyId = that.getCountyId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "countyId", lhsCountyId), LocatorUtils.property(thatLocator, "countyId", rhsCountyId), lhsCountyId, rhsCountyId)) {
                return false;
            }
        }
        {
            String lhsMunicipalId;
            lhsMunicipalId = this.getMunicipalId();
            String rhsMunicipalId;
            rhsMunicipalId = that.getMunicipalId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "municipalId", lhsMunicipalId), LocatorUtils.property(thatLocator, "municipalId", rhsMunicipalId), lhsMunicipalId, rhsMunicipalId)) {
                return false;
            }
        }
        {
            String lhsRegionName;
            lhsRegionName = this.getRegionName();
            String rhsRegionName;
            rhsRegionName = that.getRegionName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "regionName", lhsRegionName), LocatorUtils.property(thatLocator, "regionName", rhsRegionName), lhsRegionName, rhsRegionName)) {
                return false;
            }
        }
        {
            List<SwedenPoliticalParty> lhsParties;
            lhsParties = (((this.parties!= null)&&(!this.parties.isEmpty()))?this.getParties():null);
            List<SwedenPoliticalParty> rhsParties;
            rhsParties = (((that.parties!= null)&&(!that.parties.isEmpty()))?that.getParties():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "parties", lhsParties), LocatorUtils.property(thatLocator, "parties", rhsParties), lhsParties, rhsParties)) {
                return false;
            }
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(final Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public final String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public final int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}
