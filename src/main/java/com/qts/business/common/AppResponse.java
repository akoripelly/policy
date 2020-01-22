package com.qts.business.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

public final class AppResponse {
	private String responseStatus = "OK";

	private String message;

	private Map<String, Object> data = null;

	private Object fullData = null;

	private String referUrl;

	private String redirectUrl;;

	private String requestUrl;

	/**
	 * @return the referUrl
	 */
	public String getReferUrl() {
		return referUrl;
	}

	/**
	 * @param referUrl the referUrl to set
	 */
	public void setReferUrl(String referUrl) {
		this.referUrl = referUrl;
	}

	/**
	 * @return the redirectUrl
	 */
	public String getRedirectUrl() {
		return redirectUrl;
	}

	/**
	 * @param redirectUrl the redirectUrl to set
	 */
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	/**
	 * @return the requestUrl
	 */
	public String getRequestUrl() {
		return requestUrl;
	}

	/**
	 * @param requestUrl the requestUrl to set
	 */
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public AppResponse() {
		setResponseStatus("OK");
		data = new HashMap<>(2);
	}

	/**
	 * @return the responseStatus
	 */
	public String getResponseStatus() {
		return responseStatus;
	}

	/**
	 * @param responseStatus the responseStatus to set
	 */
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public AppResponse setMessage(final String message) {
		this.message = message;
		return this;
	}

	/**
	 * @param entity
	 * @return
	 */
	/*public AppResponse add(final Object entity) {
		if (entity == null) {
			return this;
		}
		return add(getKey(entity), entity);
	}*/

	/**
	 * @param key
	 * @param entity
	 * @return
	 */
	/*public AppResponse add(final String key, final Object entity) {
		if (entity == null) {
			return this;
		}
		if (StringUtils.hasLength(key)) {
			data.put(key, entity);
		}
		return this;
	}*/

	public AppResponse add(final String key, final Object entity) throws Exception {
		try {

			if (entity == null) {
				return this;
			}

			data.put(key, entity);

		} catch (Exception e) {
			throw new Exception("Exception at adding status code to Data Object" + e.getMessage());
		}

		return this;
	}

	/**
	 * @param other
	 * @return
	 */
	public AppResponse add(final AppResponse other) {
		if (other != null) {

			Map<String, Object> otherData = other.getData();
			if (otherData != null && !otherData.isEmpty()) {
				for (Map.Entry<String, Object> entry : otherData.entrySet()) {
					if (StringUtils.hasLength(entry.getKey()) && entry.getValue() != null) {
						if (data.containsKey(entry.getKey())) {
							System.out.println(">>> Map already contains " + entry.getKey()
									+ " and is replaced with a new value <<<");
						}
						data.put(entry.getKey(), entry.getValue());
					}
				}
			}
		}
		return this;
	}

	/**
	 * @return
	 */
	public Map<String, Object> getData() {
		if (data == null) {
			data = new HashMap<>(0);
		}
		return data;
	}

	/**
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		Object value = null;
		if (StringUtils.hasLength(key)) {
			value = data.get(key);
		}
		return value;
	}

	/**
	 * @param projectedTo
	 * @param             <T>
	 * @return
	 */
	public <T> T get(final Class<T> projectedTo) {
		if (projectedTo != null) {
			return get(projectedTo.getSimpleName().toLowerCase(), projectedTo);
		}
		return null;
	}

	/**
	 * @param key
	 * @param projectedTo
	 * @param             <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(final String key, final Class<T> projectedTo) {
		T projectedEntity = null;
		if (StringUtils.hasLength(key)) {
			Object value = data.get(key);
			projectedEntity = projectedTo.isAssignableFrom(value.getClass()) ? projectedTo.cast(value) : (T) value;
		}
		return projectedEntity;
	}

	/**
	 * @param obj
	 * @return
	 */
	private String getKey(final Object obj) {
		String key = null;
		if (obj != null) {
			key = obj.getClass().getSimpleName().toLowerCase();
		}
		return key;
	}

	/**
	 * @return the fullData
	 */
	public Object getFullData() {
		return fullData;
	}

	/**
	 * @param fullData the fullData to set
	 */
	public void setFullData(Object fullData) {
		this.fullData = fullData;
	}

	/**
	 * @param data the Data to set
	 */
	public void setData(Map<String, Object> Data) {
		this.data.putAll(Data);

	}

	/**
	 * Remove key from Data Map
	 */
	public void remove(String key) throws Exception {
		if (data.containsKey(key)) {
			data.remove(key);
		} else {
			throw new Exception("The given key does not exist");
		}

	}
}
