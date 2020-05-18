package com.ecs.monitor.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proj1ParamsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Proj1ParamsExample() {
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

        public Criteria andScanDelayIsNull() {
            addCriterion("scan_delay is null");
            return (Criteria) this;
        }

        public Criteria andScanDelayIsNotNull() {
            addCriterion("scan_delay is not null");
            return (Criteria) this;
        }

        public Criteria andScanDelayEqualTo(Integer value) {
            addCriterion("scan_delay =", value, "scanDelay");
            return (Criteria) this;
        }

        public Criteria andScanDelayNotEqualTo(Integer value) {
            addCriterion("scan_delay <>", value, "scanDelay");
            return (Criteria) this;
        }

        public Criteria andScanDelayGreaterThan(Integer value) {
            addCriterion("scan_delay >", value, "scanDelay");
            return (Criteria) this;
        }

        public Criteria andScanDelayGreaterThanOrEqualTo(Integer value) {
            addCriterion("scan_delay >=", value, "scanDelay");
            return (Criteria) this;
        }

        public Criteria andScanDelayLessThan(Integer value) {
            addCriterion("scan_delay <", value, "scanDelay");
            return (Criteria) this;
        }

        public Criteria andScanDelayLessThanOrEqualTo(Integer value) {
            addCriterion("scan_delay <=", value, "scanDelay");
            return (Criteria) this;
        }

        public Criteria andScanDelayIn(List<Integer> values) {
            addCriterion("scan_delay in", values, "scanDelay");
            return (Criteria) this;
        }

        public Criteria andScanDelayNotIn(List<Integer> values) {
            addCriterion("scan_delay not in", values, "scanDelay");
            return (Criteria) this;
        }

        public Criteria andScanDelayBetween(Integer value1, Integer value2) {
            addCriterion("scan_delay between", value1, value2, "scanDelay");
            return (Criteria) this;
        }

        public Criteria andScanDelayNotBetween(Integer value1, Integer value2) {
            addCriterion("scan_delay not between", value1, value2, "scanDelay");
            return (Criteria) this;
        }

        public Criteria andKeepLogTimeIsNull() {
            addCriterion("keep_log_time is null");
            return (Criteria) this;
        }

        public Criteria andKeepLogTimeIsNotNull() {
            addCriterion("keep_log_time is not null");
            return (Criteria) this;
        }

        public Criteria andKeepLogTimeEqualTo(Integer value) {
            addCriterion("keep_log_time =", value, "keepLogTime");
            return (Criteria) this;
        }

        public Criteria andKeepLogTimeNotEqualTo(Integer value) {
            addCriterion("keep_log_time <>", value, "keepLogTime");
            return (Criteria) this;
        }

        public Criteria andKeepLogTimeGreaterThan(Integer value) {
            addCriterion("keep_log_time >", value, "keepLogTime");
            return (Criteria) this;
        }

        public Criteria andKeepLogTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("keep_log_time >=", value, "keepLogTime");
            return (Criteria) this;
        }

        public Criteria andKeepLogTimeLessThan(Integer value) {
            addCriterion("keep_log_time <", value, "keepLogTime");
            return (Criteria) this;
        }

        public Criteria andKeepLogTimeLessThanOrEqualTo(Integer value) {
            addCriterion("keep_log_time <=", value, "keepLogTime");
            return (Criteria) this;
        }

        public Criteria andKeepLogTimeIn(List<Integer> values) {
            addCriterion("keep_log_time in", values, "keepLogTime");
            return (Criteria) this;
        }

        public Criteria andKeepLogTimeNotIn(List<Integer> values) {
            addCriterion("keep_log_time not in", values, "keepLogTime");
            return (Criteria) this;
        }

        public Criteria andKeepLogTimeBetween(Integer value1, Integer value2) {
            addCriterion("keep_log_time between", value1, value2, "keepLogTime");
            return (Criteria) this;
        }

        public Criteria andKeepLogTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("keep_log_time not between", value1, value2, "keepLogTime");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNull() {
            addCriterion("is_active is null");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNotNull() {
            addCriterion("is_active is not null");
            return (Criteria) this;
        }

        public Criteria andIsActiveEqualTo(Integer value) {
            addCriterion("is_active =", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotEqualTo(Integer value) {
            addCriterion("is_active <>", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThan(Integer value) {
            addCriterion("is_active >", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_active >=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThan(Integer value) {
            addCriterion("is_active <", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThanOrEqualTo(Integer value) {
            addCriterion("is_active <=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveIn(List<Integer> values) {
            addCriterion("is_active in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotIn(List<Integer> values) {
            addCriterion("is_active not in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveBetween(Integer value1, Integer value2) {
            addCriterion("is_active between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("is_active not between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andIpsIsNull() {
            addCriterion("ips is null");
            return (Criteria) this;
        }

        public Criteria andIpsIsNotNull() {
            addCriterion("ips is not null");
            return (Criteria) this;
        }

        public Criteria andIpsEqualTo(String value) {
            addCriterion("ips =", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotEqualTo(String value) {
            addCriterion("ips <>", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsGreaterThan(String value) {
            addCriterion("ips >", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsGreaterThanOrEqualTo(String value) {
            addCriterion("ips >=", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsLessThan(String value) {
            addCriterion("ips <", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsLessThanOrEqualTo(String value) {
            addCriterion("ips <=", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsLike(String value) {
            addCriterion("ips like", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotLike(String value) {
            addCriterion("ips not like", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsIn(List<String> values) {
            addCriterion("ips in", values, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotIn(List<String> values) {
            addCriterion("ips not in", values, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsBetween(String value1, String value2) {
            addCriterion("ips between", value1, value2, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotBetween(String value1, String value2) {
            addCriterion("ips not between", value1, value2, "ips");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
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