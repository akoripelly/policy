/**
 * 
 */
package com.qts.business.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author mtoluchuri
 *
 */
public class Business implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private String policyId;

	private String state;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date lastTxnDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date effectiveDate;

	private String lineOfBusiness;

	/**
	 * @return the policyId
	 */
	public String getPolicyId() {
		return policyId;
	}

	/**
	 * @param policyId the policyId to set
	 */
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the lastTxnDate
	 */
	public Date getLastTxnDate() {
		return lastTxnDate;
	}

	/**
	 * @param lastTxnDate the lastTxnDate to set
	 */
	public void setLastTxnDate(Date lastTxnDate) {
		this.lastTxnDate = lastTxnDate;
	}

	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the lineOfBusiness
	 */
	public String getLineOfBusiness() {
		return lineOfBusiness;
	}

	/**
	 * @param lineOfBusiness the lineOfBusiness to set
	 */
	public void setLineOfBusiness(String lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}

}
