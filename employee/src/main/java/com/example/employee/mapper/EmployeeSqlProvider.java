package com.example.employee.mapper;

import com.example.employee.entity.Employee;
import com.example.employee.entity.EmployeeExample.Criteria;
import com.example.employee.entity.EmployeeExample.Criterion;
import com.example.employee.entity.EmployeeExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class EmployeeSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee
	 * @mbggenerated  Fri Sep 22 13:44:00 MMT 2017
	 */
	public String countByExample(EmployeeExample example) {
		SQL sql = new SQL();
		sql.SELECT("count(*)").FROM("`employee`");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee
	 * @mbggenerated  Fri Sep 22 13:44:00 MMT 2017
	 */
	public String deleteByExample(EmployeeExample example) {
		SQL sql = new SQL();
		sql.DELETE_FROM("`employee`");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee
	 * @mbggenerated  Fri Sep 22 13:44:00 MMT 2017
	 */
	public String insertSelective(Employee record) {
		SQL sql = new SQL();
		sql.INSERT_INTO("`employee`");
		if (record.getEmployeeId() != null) {
			sql.VALUES("`employee_id`", "#{employeeId,jdbcType=BIGINT}");
		}
		if (record.getEmployeeName() != null) {
			sql.VALUES("`employee_name`", "#{employeeName,jdbcType=VARCHAR}");
		}
		if (record.getAddress() != null) {
			sql.VALUES("`address`", "#{address,jdbcType=VARCHAR}");
		}
		if (record.getGender() != null) {
			sql.VALUES("`gender`", "#{gender,jdbcType=VARCHAR}");
		}
		if (record.getRemark() != null) {
			sql.VALUES("`remark`", "#{remark,jdbcType=VARCHAR}");
		}
		if (record.getEmail() != null) {
			sql.VALUES("`email`", "#{email,jdbcType=VARCHAR}");
		}
		if (record.getPassword() != null) {
			sql.VALUES("`password`", "#{password,jdbcType=VARCHAR}");
		}
		if (record.getPhone() != null) {
			sql.VALUES("`phone`", "#{phone,jdbcType=VARCHAR}");
		}
		if (record.getRole() != null) {
			sql.VALUES("`role`", "#{role,jdbcType=VARCHAR}");
		}
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee
	 * @mbggenerated  Fri Sep 22 13:44:00 MMT 2017
	 */
	public String selectByExample(EmployeeExample example) {
		SQL sql = new SQL();
		if (example != null && example.isDistinct()) {
			sql.SELECT_DISTINCT("`employee_id`");
		} else {
			sql.SELECT("`employee_id`");
		}
		sql.SELECT("`employee_name`");
		sql.SELECT("`address`");
		sql.SELECT("`gender`");
		sql.SELECT("`remark`");
		sql.SELECT("`email`");
		sql.SELECT("`password`");
		sql.SELECT("`phone`");
		sql.SELECT("`role`");
		sql.FROM("`employee`");
		applyWhere(sql, example, false);
		if (example != null && example.getOrderByClause() != null) {
			sql.ORDER_BY(example.getOrderByClause());
		}
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee
	 * @mbggenerated  Fri Sep 22 13:44:00 MMT 2017
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		Employee record = (Employee) parameter.get("record");
		EmployeeExample example = (EmployeeExample) parameter.get("example");
		SQL sql = new SQL();
		sql.UPDATE("`employee`");
		if (record.getEmployeeId() != null) {
			sql.SET("`employee_id` = #{record.employeeId,jdbcType=BIGINT}");
		}
		if (record.getEmployeeName() != null) {
			sql.SET("`employee_name` = #{record.employeeName,jdbcType=VARCHAR}");
		}
		if (record.getAddress() != null) {
			sql.SET("`address` = #{record.address,jdbcType=VARCHAR}");
		}
		if (record.getGender() != null) {
			sql.SET("`gender` = #{record.gender,jdbcType=VARCHAR}");
		}
		if (record.getRemark() != null) {
			sql.SET("`remark` = #{record.remark,jdbcType=VARCHAR}");
		}
		if (record.getEmail() != null) {
			sql.SET("`email` = #{record.email,jdbcType=VARCHAR}");
		}
		if (record.getPassword() != null) {
			sql.SET("`password` = #{record.password,jdbcType=VARCHAR}");
		}
		if (record.getPhone() != null) {
			sql.SET("`phone` = #{record.phone,jdbcType=VARCHAR}");
		}
		if (record.getRole() != null) {
			sql.SET("`role` = #{record.role,jdbcType=VARCHAR}");
		}
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee
	 * @mbggenerated  Fri Sep 22 13:44:00 MMT 2017
	 */
	public String updateByExample(Map<String, Object> parameter) {
		SQL sql = new SQL();
		sql.UPDATE("`employee`");
		sql.SET("`employee_id` = #{record.employeeId,jdbcType=BIGINT}");
		sql.SET("`employee_name` = #{record.employeeName,jdbcType=VARCHAR}");
		sql.SET("`address` = #{record.address,jdbcType=VARCHAR}");
		sql.SET("`gender` = #{record.gender,jdbcType=VARCHAR}");
		sql.SET("`remark` = #{record.remark,jdbcType=VARCHAR}");
		sql.SET("`email` = #{record.email,jdbcType=VARCHAR}");
		sql.SET("`password` = #{record.password,jdbcType=VARCHAR}");
		sql.SET("`phone` = #{record.phone,jdbcType=VARCHAR}");
		sql.SET("`role` = #{record.role,jdbcType=VARCHAR}");
		EmployeeExample example = (EmployeeExample) parameter.get("example");
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee
	 * @mbggenerated  Fri Sep 22 13:44:00 MMT 2017
	 */
	public String updateByPrimaryKeySelective(Employee record) {
		SQL sql = new SQL();
		sql.UPDATE("`employee`");
		if (record.getEmployeeName() != null) {
			sql.SET("`employee_name` = #{employeeName,jdbcType=VARCHAR}");
		}
		if (record.getAddress() != null) {
			sql.SET("`address` = #{address,jdbcType=VARCHAR}");
		}
		if (record.getGender() != null) {
			sql.SET("`gender` = #{gender,jdbcType=VARCHAR}");
		}
		if (record.getRemark() != null) {
			sql.SET("`remark` = #{remark,jdbcType=VARCHAR}");
		}
		if (record.getEmail() != null) {
			sql.SET("`email` = #{email,jdbcType=VARCHAR}");
		}
		if (record.getPassword() != null) {
			sql.SET("`password` = #{password,jdbcType=VARCHAR}");
		}
		if (record.getPhone() != null) {
			sql.SET("`phone` = #{phone,jdbcType=VARCHAR}");
		}
		if (record.getRole() != null) {
			sql.SET("`role` = #{role,jdbcType=VARCHAR}");
		}
		sql.WHERE("`employee_id` = #{employeeId,jdbcType=BIGINT}");
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee
	 * @mbggenerated  Fri Sep 22 13:44:00 MMT 2017
	 */
	protected void applyWhere(SQL sql, EmployeeExample example, boolean includeExamplePhrase) {
		if (example == null) {
			return;
		}
		String parmPhrase1;
		String parmPhrase1_th;
		String parmPhrase2;
		String parmPhrase2_th;
		String parmPhrase3;
		String parmPhrase3_th;
		if (includeExamplePhrase) {
			parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
			parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
			parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
			parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
			parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
			parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
		} else {
			parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
			parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
			parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
			parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
			parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
			parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
		}
		StringBuilder sb = new StringBuilder();
		List<Criteria> oredCriteria = example.getOredCriteria();
		boolean firstCriteria = true;
		for (int i = 0; i < oredCriteria.size(); i++) {
			Criteria criteria = oredCriteria.get(i);
			if (criteria.isValid()) {
				if (firstCriteria) {
					firstCriteria = false;
				} else {
					sb.append(" or ");
				}
				sb.append('(');
				List<Criterion> criterions = criteria.getAllCriteria();
				boolean firstCriterion = true;
				for (int j = 0; j < criterions.size(); j++) {
					Criterion criterion = criterions.get(j);
					if (firstCriterion) {
						firstCriterion = false;
					} else {
						sb.append(" and ");
					}
					if (criterion.isNoValue()) {
						sb.append(criterion.getCondition());
					} else if (criterion.isSingleValue()) {
						if (criterion.getTypeHandler() == null) {
							sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
						} else {
							sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,
									criterion.getTypeHandler()));
						}
					} else if (criterion.isBetweenValue()) {
						if (criterion.getTypeHandler() == null) {
							sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
						} else {
							sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j,
									criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
						}
					} else if (criterion.isListValue()) {
						sb.append(criterion.getCondition());
						sb.append(" (");
						List<?> listItems = (List<?>) criterion.getValue();
						boolean comma = false;
						for (int k = 0; k < listItems.size(); k++) {
							if (comma) {
								sb.append(", ");
							} else {
								comma = true;
							}
							if (criterion.getTypeHandler() == null) {
								sb.append(String.format(parmPhrase3, i, j, k));
							} else {
								sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
							}
						}
						sb.append(')');
					}
				}
				sb.append(')');
			}
		}
		if (sb.length() > 0) {
			sql.WHERE(sb.toString());
		}
	}
}