package com.wenhao.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.wenhao.form.BaseBean;
import com.wenhao.form.Page;

@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class,Integer.class})})
public class PageInterceptor implements Interceptor{

	public Object intercept(Invocation arg0) throws Throwable {
		StatementHandler statementHandler = (StatementHandler)arg0.getTarget();
		MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,new DefaultReflectorFactory());
		MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
		String id = mappedStatement.getId();
		if(id.endsWith("ByPage")) {
			BoundSql boundSql = statementHandler.getBoundSql();
			String sql = boundSql.getSql();
			String countSql = "select count(*) from(" + sql + ")t";
			Connection conn = (Connection)arg0.getArgs()[0];
			PreparedStatement statement = conn.prepareStatement(countSql);
			ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
			parameterHandler.setParameters(statement);
			ResultSet rs = statement.executeQuery();
			BaseBean bean = (BaseBean)boundSql.getParameterObject();
			Page page = bean.getPage();
			if(rs.next()) {
				page.setTotalNumber(rs.getInt(1));
			}
			int currentPage = page.getCurrentPage();
			int pageNumber = page.getPageNumber();
			 Properties prop = new Properties();
		     prop.load(PageInterceptor.class.getClassLoader().getResourceAsStream("application.properties"));
		     String dbDriver = prop.getProperty("spring.datasource.driver-class-name");
		     String pageSql = sql;
		     //mysql分页
		     if("com.mysql.jdbc.Driver".equals(dbDriver)){
		    	 pageSql = getPageSql4Mysql(pageSql, (currentPage - 1) * pageNumber, pageNumber);
		     }
		     //oracle分页
		     else if("oracle.jdbc.driver.OracleDriver".equals(dbDriver)){
		    	 pageSql = getPageSql4Oracle(pageSql, (currentPage - 1) * pageNumber, currentPage*pageNumber);
		     }
			metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		return arg0.proceed();
	}

	public Object plugin(Object arg0) {
		return Plugin.wrap(arg0, this);
	}

	public void setProperties(Properties arg0) {
		
	}
	/**
     * Oracle分页
     * @param sql
     * @param offset
     * @param limit
     * @return
     */
    public String getPageSql4Oracle(String sql, int offset, int limit) {
        sql = sql.trim();
        boolean isForUpdate = false;
        if (sql.toLowerCase().endsWith(" for update")) {
            sql = sql.substring(0, sql.length() - 11);
            isForUpdate = true;
        }
        StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
        if (offset > 0) {
            pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
        } else {
            pagingSelect.append("select * from ( ");
        }
        pagingSelect.append(sql);
        if (offset > 0) {
            pagingSelect.append(" ) row_ ) where rownum_ <= " + limit + " and rownum_ > " + offset);
        } else {
            pagingSelect.append(" ) where rownum <= " + limit);
        }
        if (isForUpdate) {
            pagingSelect.append(" for update");
        }
        return pagingSelect.toString();
    }

    /**
     * mysql分页
     * @param sql
     * @param offset
     * @param limit
     * @return
     */
    public String getPageSql4Mysql(String sql, int offset, int limit) {
        sql = sql.trim();
        boolean isForUpdate = false;
        if (sql.toLowerCase().endsWith(" for update")) {
            sql = sql.substring(0, sql.length() - 11);
            isForUpdate = true;
        }
        StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
        if (offset < 0) {
            offset = 0;
        }
        pagingSelect.append(sql);
        pagingSelect.append(" limit " + offset + "," + limit);

        if (isForUpdate) {
            pagingSelect.append(" for update");
        }
        return pagingSelect.toString();
    }
}
