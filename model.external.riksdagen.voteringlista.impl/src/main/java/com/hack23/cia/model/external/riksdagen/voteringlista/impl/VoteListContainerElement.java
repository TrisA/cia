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
// Generated on: 2019.02.24 at 11:40:17 PM CET 
//


package com.hack23.cia.model.external.riksdagen.voteringlista.impl;

import java.util.ArrayList;
import java.util.Collection;
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
 * The Class VoteListContainerElement.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VoteListContainerElement", propOrder = {
    "votering"
})
@Entity(name = "VoteListContainerElement")
@Table(name = "VOTE_LIST_CONTAINER_ELEMENT")
@Inheritance(strategy = InheritanceType.JOINED)
public class VoteListContainerElement
    implements ModelObject, Equals
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The votering. */
    @XmlElement(required = true)
    protected List<BallotDocumentElement> votering;
    
    /** The grouping. */
    @XmlAttribute(name = "gruppering", required = true)
    protected String grouping;
    
    /** The condition. */
    @XmlAttribute(name = "villkor", required = true)
    protected String condition;
    
    /** The number value. */
    @XmlAttribute(name = "antal", required = true)
    protected String numberValue;
    
    /** The hjid. */
    @XmlAttribute(name = "Hjid")
    protected Long hjid;

    /**
	 * Gets the votering.
	 *
	 * @return the votering
	 */
    @OneToMany(targetEntity = BallotDocumentElement.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "VOTERING_VOTE_LIST_CONTAINER_0")
    public List<BallotDocumentElement> getVotering() {
        if (votering == null) {
            votering = new ArrayList<>();
        }
        return this.votering;
    }

    /**
	 * Sets the votering.
	 *
	 * @param votering the new votering
	 */
    public void setVotering(final List<BallotDocumentElement> votering) {
        this.votering = votering;
    }

    /**
	 * Gets the grouping.
	 *
	 * @return the grouping
	 */
    @Basic
    @Column(name = "GROUPING_")
    public String getGrouping() {
        return grouping;
    }

    /**
	 * Sets the grouping.
	 *
	 * @param value the new grouping
	 */
    public void setGrouping(final String value) {
        this.grouping = value;
    }

    /**
	 * Gets the condition.
	 *
	 * @return the condition
	 */
    @Basic
    @Column(name = "CONDITION")
    public String getCondition() {
        return condition;
    }

    /**
	 * Sets the condition.
	 *
	 * @param value the new condition
	 */
    public void setCondition(final String value) {
        this.condition = value;
    }

    /**
	 * Gets the number value.
	 *
	 * @return the number value
	 */
    @Basic
    @Column(name = "NUMBER_VALUE")
    public String getNumberValue() {
        return numberValue;
    }

    /**
	 * Sets the number value.
	 *
	 * @param value the new number value
	 */
    public void setNumberValue(final String value) {
        this.numberValue = value;
    }

    /**
	 * With votering.
	 *
	 * @param values the values
	 * @return the vote list container element
	 */
    public VoteListContainerElement withVotering(final BallotDocumentElement... values) {
        if (values!= null) {
            for (final BallotDocumentElement value: values) {
                getVotering().add(value);
            }
        }
        return this;
    }

    /**
	 * With votering.
	 *
	 * @param values the values
	 * @return the vote list container element
	 */
    public VoteListContainerElement withVotering(final Collection<BallotDocumentElement> values) {
        if (values!= null) {
            getVotering().addAll(values);
        }
        return this;
    }

    /**
	 * With votering.
	 *
	 * @param votering the votering
	 * @return the vote list container element
	 */
    public VoteListContainerElement withVotering(final List<BallotDocumentElement> votering) {
        setVotering(votering);
        return this;
    }

    /**
	 * With grouping.
	 *
	 * @param value the value
	 * @return the vote list container element
	 */
    public VoteListContainerElement withGrouping(final String value) {
        setGrouping(value);
        return this;
    }

    /**
	 * With condition.
	 *
	 * @param value the value
	 * @return the vote list container element
	 */
    public VoteListContainerElement withCondition(final String value) {
        setCondition(value);
        return this;
    }

    /**
	 * With number value.
	 *
	 * @param value the value
	 * @return the vote list container element
	 */
    public VoteListContainerElement withNumberValue(final String value) {
        setNumberValue(value);
        return this;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public final String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
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
     * @see org.jvnet.jaxb2_commons.lang.Equals#equals(org.jvnet.jaxb2_commons.locator.ObjectLocator, org.jvnet.jaxb2_commons.locator.ObjectLocator, java.lang.Object, org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy)
     */
    public boolean equals(final ObjectLocator thisLocator, final ObjectLocator thatLocator, final Object object, final EqualsStrategy strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final VoteListContainerElement that = ((VoteListContainerElement) object);
        {
            List<BallotDocumentElement> lhsVotering;
            lhsVotering = (((this.votering!= null)&&(!this.votering.isEmpty()))?this.getVotering():null);
            List<BallotDocumentElement> rhsVotering;
            rhsVotering = (((that.votering!= null)&&(!that.votering.isEmpty()))?that.getVotering():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "votering", lhsVotering), LocatorUtils.property(thatLocator, "votering", rhsVotering), lhsVotering, rhsVotering)) {
                return false;
            }
        }
        {
            String lhsGrouping;
            lhsGrouping = this.getGrouping();
            String rhsGrouping;
            rhsGrouping = that.getGrouping();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "grouping", lhsGrouping), LocatorUtils.property(thatLocator, "grouping", rhsGrouping), lhsGrouping, rhsGrouping)) {
                return false;
            }
        }
        {
            String lhsCondition;
            lhsCondition = this.getCondition();
            String rhsCondition;
            rhsCondition = that.getCondition();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "condition", lhsCondition), LocatorUtils.property(thatLocator, "condition", rhsCondition), lhsCondition, rhsCondition)) {
                return false;
            }
        }
        {
            String lhsNumberValue;
            lhsNumberValue = this.getNumberValue();
            String rhsNumberValue;
            rhsNumberValue = that.getNumberValue();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "numberValue", lhsNumberValue), LocatorUtils.property(thatLocator, "numberValue", rhsNumberValue), lhsNumberValue, rhsNumberValue)) {
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
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public final int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}
