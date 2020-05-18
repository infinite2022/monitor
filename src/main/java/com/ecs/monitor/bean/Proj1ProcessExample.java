package com.ecs.monitor.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proj1ProcessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Proj1ProcessExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPnameIsNull() {
            addCriterion("pname is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pname is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pname =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pname <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pname >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pname >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pname <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pname <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pname like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pname not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pname in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pname not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pname between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pname not between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andFpathIsNull() {
            addCriterion("fpath is null");
            return (Criteria) this;
        }

        public Criteria andFpathIsNotNull() {
            addCriterion("fpath is not null");
            return (Criteria) this;
        }

        public Criteria andFpathEqualTo(String value) {
            addCriterion("fpath =", value, "fpath");
            return (Criteria) this;
        }

        public Criteria andFpathNotEqualTo(String value) {
            addCriterion("fpath <>", value, "fpath");
            return (Criteria) this;
        }

        public Criteria andFpathGreaterThan(String value) {
            addCriterion("fpath >", value, "fpath");
            return (Criteria) this;
        }

        public Criteria andFpathGreaterThanOrEqualTo(String value) {
            addCriterion("fpath >=", value, "fpath");
            return (Criteria) this;
        }

        public Criteria andFpathLessThan(String value) {
            addCriterion("fpath <", value, "fpath");
            return (Criteria) this;
        }

        public Criteria andFpathLessThanOrEqualTo(String value) {
            addCriterion("fpath <=", value, "fpath");
            return (Criteria) this;
        }

        public Criteria andFpathLike(String value) {
            addCriterion("fpath like", value, "fpath");
            return (Criteria) this;
        }

        public Criteria andFpathNotLike(String value) {
            addCriterion("fpath not like", value, "fpath");
            return (Criteria) this;
        }

        public Criteria andFpathIn(List<String> values) {
            addCriterion("fpath in", values, "fpath");
            return (Criteria) this;
        }

        public Criteria andFpathNotIn(List<String> values) {
            addCriterion("fpath not in", values, "fpath");
            return (Criteria) this;
        }

        public Criteria andFpathBetween(String value1, String value2) {
            addCriterion("fpath between", value1, value2, "fpath");
            return (Criteria) this;
        }

        public Criteria andFpathNotBetween(String value1, String value2) {
            addCriterion("fpath not between", value1, value2, "fpath");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDaemonIsNull() {
            addCriterion("daemon is null");
            return (Criteria) this;
        }

        public Criteria andDaemonIsNotNull() {
            addCriterion("daemon is not null");
            return (Criteria) this;
        }

        public Criteria andDaemonEqualTo(Integer value) {
            addCriterion("daemon =", value, "daemon");
            return (Criteria) this;
        }

        public Criteria andDaemonNotEqualTo(Integer value) {
            addCriterion("daemon <>", value, "daemon");
            return (Criteria) this;
        }

        public Criteria andDaemonGreaterThan(Integer value) {
            addCriterion("daemon >", value, "daemon");
            return (Criteria) this;
        }

        public Criteria andDaemonGreaterThanOrEqualTo(Integer value) {
            addCriterion("daemon >=", value, "daemon");
            return (Criteria) this;
        }

        public Criteria andDaemonLessThan(Integer value) {
            addCriterion("daemon <", value, "daemon");
            return (Criteria) this;
        }

        public Criteria andDaemonLessThanOrEqualTo(Integer value) {
            addCriterion("daemon <=", value, "daemon");
            return (Criteria) this;
        }

        public Criteria andDaemonIn(List<Integer> values) {
            addCriterion("daemon in", values, "daemon");
            return (Criteria) this;
        }

        public Criteria andDaemonNotIn(List<Integer> values) {
            addCriterion("daemon not in", values, "daemon");
            return (Criteria) this;
        }

        public Criteria andDaemonBetween(Integer value1, Integer value2) {
            addCriterion("daemon between", value1, value2, "daemon");
            return (Criteria) this;
        }

        public Criteria andDaemonNotBetween(Integer value1, Integer value2) {
            addCriterion("daemon not between", value1, value2, "daemon");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Integer value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Integer value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Integer value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Integer value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Integer> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Integer> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Integer value1, Integer value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andPmtCreateIsNull() {
            addCriterion("pmt_create is null");
            return (Criteria) this;
        }

        public Criteria andPmtCreateIsNotNull() {
            addCriterion("pmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andPmtCreateEqualTo(Date value) {
            addCriterion("pmt_create =", value, "pmtCreate");
            return (Criteria) this;
        }

        public Criteria andPmtCreateNotEqualTo(Date value) {
            addCriterion("pmt_create <>", value, "pmtCreate");
            return (Criteria) this;
        }

        public Criteria andPmtCreateGreaterThan(Date value) {
            addCriterion("pmt_create >", value, "pmtCreate");
            return (Criteria) this;
        }

        public Criteria andPmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("pmt_create >=", value, "pmtCreate");
            return (Criteria) this;
        }

        public Criteria andPmtCreateLessThan(Date value) {
            addCriterion("pmt_create <", value, "pmtCreate");
            return (Criteria) this;
        }

        public Criteria andPmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("pmt_create <=", value, "pmtCreate");
            return (Criteria) this;
        }

        public Criteria andPmtCreateIn(List<Date> values) {
            addCriterion("pmt_create in", values, "pmtCreate");
            return (Criteria) this;
        }

        public Criteria andPmtCreateNotIn(List<Date> values) {
            addCriterion("pmt_create not in", values, "pmtCreate");
            return (Criteria) this;
        }

        public Criteria andPmtCreateBetween(Date value1, Date value2) {
            addCriterion("pmt_create between", value1, value2, "pmtCreate");
            return (Criteria) this;
        }

        public Criteria andPmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("pmt_create not between", value1, value2, "pmtCreate");
            return (Criteria) this;
        }

        public Criteria andPmtUpdateIsNull() {
            addCriterion("pmt_update is null");
            return (Criteria) this;
        }

        public Criteria andPmtUpdateIsNotNull() {
            addCriterion("pmt_update is not null");
            return (Criteria) this;
        }

        public Criteria andPmtUpdateEqualTo(Date value) {
            addCriterion("pmt_update =", value, "pmtUpdate");
            return (Criteria) this;
        }

        public Criteria andPmtUpdateNotEqualTo(Date value) {
            addCriterion("pmt_update <>", value, "pmtUpdate");
            return (Criteria) this;
        }

        public Criteria andPmtUpdateGreaterThan(Date value) {
            addCriterion("pmt_update >", value, "pmtUpdate");
            return (Criteria) this;
        }

        public Criteria andPmtUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("pmt_update >=", value, "pmtUpdate");
            return (Criteria) this;
        }

        public Criteria andPmtUpdateLessThan(Date value) {
            addCriterion("pmt_update <", value, "pmtUpdate");
            return (Criteria) this;
        }

        public Criteria andPmtUpdateLessThanOrEqualTo(Date value) {
            addCriterion("pmt_update <=", value, "pmtUpdate");
            return (Criteria) this;
        }

        public Criteria andPmtUpdateIn(List<Date> values) {
            addCriterion("pmt_update in", values, "pmtUpdate");
            return (Criteria) this;
        }

        public Criteria andPmtUpdateNotIn(List<Date> values) {
            addCriterion("pmt_update not in", values, "pmtUpdate");
            return (Criteria) this;
        }

        public Criteria andPmtUpdateBetween(Date value1, Date value2) {
            addCriterion("pmt_update between", value1, value2, "pmtUpdate");
            return (Criteria) this;
        }

        public Criteria andPmtUpdateNotBetween(Date value1, Date value2) {
            addCriterion("pmt_update not between", value1, value2, "pmtUpdate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}