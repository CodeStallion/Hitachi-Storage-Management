package com.hitachi.hibernate.entities;

// Generated Dec 19, 2011 2:23:47 AM by Hibernate Tools 3.4.0.CR1

/**
 * PoolId generated by hbm2java
 */
public class PoolId implements java.io.Serializable {

	private int poolId;
	private String objectId;

	public PoolId() {
	}

	public PoolId(int poolId, String objectId) {
		this.poolId = poolId;
		this.objectId = objectId;
	}

	public int getPoolId() {
		return this.poolId;
	}

	public void setPoolId(int poolId) {
		this.poolId = poolId;
	}

	public String getObjectId() {
		return this.objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PoolId))
			return false;
		PoolId castOther = (PoolId) other;

		return (this.getPoolId() == castOther.getPoolId())
				&& ((this.getObjectId() == castOther.getObjectId()) || (this
						.getObjectId() != null
						&& castOther.getObjectId() != null && this
						.getObjectId().equals(castOther.getObjectId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPoolId();
		result = 37 * result
				+ (getObjectId() == null ? 0 : this.getObjectId().hashCode());
		return result;
	}

}
