package edu.zut.cs.OSALS.base.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
//将实体类中的属性封装在这个非实体类中    他的属性都将映射到其子类的数据库字段中？？？
@Access(value=AccessType.FIELD)
//AccessType.FIELD：直接访问Entity的变量，可以不定义getter和setter方法，但是需要将变量定义为public
//AccessType.PROPERTY：通过getter和setter方法访问Entity的变量，可以把变量定义为private
public class BaseTreeEntity<T extends BaseTreeEntity<T>> extends BaseEntity {
	//此处泛型的使用

	/**
	 *
	 */
	private static final long serialVersionUID = -5961264427451119166L;

	@JsonManagedReference("parent-children")
	//解决对象中存在双向引用导致的无限递归
	@OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	List<T> children;

	@Transient
	boolean leaf = true;

	@JsonBackReference("parent-children")
	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	T parent;

	@Column(name = "TEXT")
	String text;

	public List<T> getChildren() {
		return children;
	}

	public T getParent() {
		return parent;
	}

	public String getText() {
		return text;
	}

	public boolean isLeaf() {
		if (null != this.children && this.children.size() > 0) {
			this.leaf = false;
		} else {
			this.leaf = true;
		}
		return leaf;
	}

	public void setChildren(List<T> children) {
		this.children = children;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public void setParent(T parent) {
		this.parent = parent;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	//复写父类中的方法
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE, false);
	}

}
