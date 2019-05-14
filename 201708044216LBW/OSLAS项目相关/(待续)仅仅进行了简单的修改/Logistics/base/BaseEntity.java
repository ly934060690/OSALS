package edu.zut.cs.software.base;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass

@Access(value= AccessType.FIELD)
public class BaseEntity extends BaseDomain {

	/**
	 *
	 */
	private static final long serialVersionUID = -6163675075289529459L;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATECREATED")
	protected Date dateCreated = new Date();

	/**
	 * 实体修改时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATEMODIFIED")
	protected Date dateModified = new Date();

	/**
	 * 实体是否被删除
	 */
	@Column(name = "DELETED")
	protected Boolean deleted;

	@Column(name = "ENTITY_NAME")
	protected String entityName;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Version
	@Access(AccessType.FIELD)
	private long version;

	@Override
	public boolean equals(Object obj) {
		if (null != obj) {
			if (obj instanceof BaseEntity) {
				BaseEntity domain = (BaseEntity) obj;
				if (this.id == domain.id) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public String toString() {
		return null;
	}


	public Date getDateCreated() {
		return dateCreated;
	}




	public Date getDateModified() {
		return dateModified;
	}


	public Boolean getDeleted() {
		return deleted;
	}


	public String getEntityName() {
		return entityName;
	}


	public Long getId() {
		return id;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}


	public void setId(Long id) {
		this.id = id;
	}



}
