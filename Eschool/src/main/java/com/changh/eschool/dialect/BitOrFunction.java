package com.changh.eschool.dialect;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.Mapping;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.type.Type;

public class BitOrFunction implements SQLFunction {
	@SuppressWarnings("deprecation")
	public Type getReturnType(Type type, Mapping mapping) {
		return Hibernate.INTEGER;
	}
	public boolean hasArguments() {
		return true;
	}
	public boolean hasParenthesesIfNoArguments() {
		return true;
	}
	@SuppressWarnings("rawtypes")
	public String render(List args, SessionFactoryImplementor factory) throws QueryException {
		if (args.size() != 2) {
			throw new IllegalArgumentException(
					"BitOrFunction requires 2 arguments!");
		}
		return args.get(0).toString() + " | " + args.get(1).toString();
	}
	@SuppressWarnings("rawtypes")
	@Override
	public String render(Type firstArgumentType, List args, SessionFactoryImplementor factory) throws QueryException {
		if (args.size() != 2) {
			throw new IllegalArgumentException(
					"BitOrFunction requires 2 arguments!");
		}
		return args.get(0).toString() + " | " + args.get(1).toString();
	}
}