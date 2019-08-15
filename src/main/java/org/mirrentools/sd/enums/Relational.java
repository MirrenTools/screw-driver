package org.mirrentools.sd.enums;

/**
 * 关系类型
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public enum Relational {
	OneToOne("OneToOne"), OneToMany("OneToMany"), ManyToOne("ManyToOne"), ManyToMany("ManyToMany");
	/** 关系的值 */
	public String val;

	private Relational(String val) {
		this.val = val;
	}

}
