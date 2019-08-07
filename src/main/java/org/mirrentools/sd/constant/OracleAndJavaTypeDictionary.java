package org.mirrentools.sd.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Oracle数据类型与Java数据类型的关系
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class OracleAndJavaTypeDictionary {

	public static final Map<String, String> ORACLE_JAVA;

	public static final Map<String, String> JAVA_ORACLE;

	static {
		ORACLE_JAVA = new HashMap<String, String>();
		ORACLE_JAVA.put(Oracle.CHAR, Java.CHAR);
		ORACLE_JAVA.put(Oracle.NCHAR, Java.CHAR);
		ORACLE_JAVA.put(Oracle.VARCHAR2, Java.STRING);
		ORACLE_JAVA.put(Oracle.NVARCHAR2, Java.STRING);
		ORACLE_JAVA.put(Oracle.CLOB, Java.STRING);
		ORACLE_JAVA.put(Oracle.NCLOB, Java.LONG);
		ORACLE_JAVA.put(Oracle.DATE, Java.DATE);
		ORACLE_JAVA.put(Oracle.TIMESTAMP, Java.DATE);
		ORACLE_JAVA.put(Oracle.RAW, Java.BYTE_ARRAYS);
		ORACLE_JAVA.put(Oracle.NUMBER, Java.BIG_DECIMAL);
		ORACLE_JAVA.put(Oracle.LONG, Java.STRING);
		
		
		JAVA_ORACLE = new HashMap<String, String>();
		JAVA_ORACLE.put(Java.CHAR, Oracle.CHAR);
		JAVA_ORACLE.put(Java.STRING, Oracle.VARCHAR2);
		JAVA_ORACLE.put(Java.BOOLEAN, Oracle.NUMBER);
		JAVA_ORACLE.put(Java.BYTE, Oracle.NUMBER);
		JAVA_ORACLE.put(Java.SHORT, Oracle.NUMBER);
		JAVA_ORACLE.put(Java.INT, Oracle.NUMBER);
		JAVA_ORACLE.put(Java.INTEGER, Oracle.NUMBER);
		JAVA_ORACLE.put(Java.LONG, Oracle.NUMBER);
		JAVA_ORACLE.put(Java.FLOAT, Oracle.NUMBER);
		JAVA_ORACLE.put(Java.DOUBLE, Oracle.NUMBER);
		JAVA_ORACLE.put(Java.BIG_DECIMAL, Oracle.NUMBER);
		
	}

}
