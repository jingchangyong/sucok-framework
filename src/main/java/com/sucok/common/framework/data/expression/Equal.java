/*
 * Copyright 2016 - 2017 suoke & Co., Ltd.
 */
package com.sucok.common.framework.data.expression;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.sucok.common.framework.data.AbstractExpression;
import com.sucok.common.framework.data.QueryFormHelper;
import org.springframework.data.mongodb.core.query.Criteria;

/**
 * @author chendx
 * @version 1.0 created at 2017年5月26日 下午1:08:21
 *
 */
public class Equal extends AbstractExpression {

	public Equal(String  field, Object value) {
		super(field,value);
	}

	@Override
	public Predicate buildJpaPredicate(CriteriaBuilder cb, Root<?> root) {
		Expression<Object> path = QueryFormHelper.getPath(root, field);
		return cb.equal(path, value);
	}

	@Override
	public Criteria buildMongoCriteria(Object expression) {
		String path = expression.toString();
		return Criteria.where(path).is(value);
	}
}
