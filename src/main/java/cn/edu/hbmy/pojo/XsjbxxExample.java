package cn.edu.hbmy.pojo;

import java.util.ArrayList;
import java.util.List;

public class XsjbxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XsjbxxExample() {
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

        public Criteria andXsjbxxXhIsNull() {
            addCriterion("XSJBXX_XH is null");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXhIsNotNull() {
            addCriterion("XSJBXX_XH is not null");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXhEqualTo(String value) {
            addCriterion("XSJBXX_XH =", value, "xsjbxxXh");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXhNotEqualTo(String value) {
            addCriterion("XSJBXX_XH <>", value, "xsjbxxXh");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXhGreaterThan(String value) {
            addCriterion("XSJBXX_XH >", value, "xsjbxxXh");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXhGreaterThanOrEqualTo(String value) {
            addCriterion("XSJBXX_XH >=", value, "xsjbxxXh");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXhLessThan(String value) {
            addCriterion("XSJBXX_XH <", value, "xsjbxxXh");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXhLessThanOrEqualTo(String value) {
            addCriterion("XSJBXX_XH <=", value, "xsjbxxXh");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXhLike(String value) {
            addCriterion("XSJBXX_XH like", value, "xsjbxxXh");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXhNotLike(String value) {
            addCriterion("XSJBXX_XH not like", value, "xsjbxxXh");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXhIn(List<String> values) {
            addCriterion("XSJBXX_XH in", values, "xsjbxxXh");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXhNotIn(List<String> values) {
            addCriterion("XSJBXX_XH not in", values, "xsjbxxXh");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXhBetween(String value1, String value2) {
            addCriterion("XSJBXX_XH between", value1, value2, "xsjbxxXh");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXhNotBetween(String value1, String value2) {
            addCriterion("XSJBXX_XH not between", value1, value2, "xsjbxxXh");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXmIsNull() {
            addCriterion("XSJBXX_XM is null");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXmIsNotNull() {
            addCriterion("XSJBXX_XM is not null");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXmEqualTo(String value) {
            addCriterion("XSJBXX_XM =", value, "xsjbxxXm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXmNotEqualTo(String value) {
            addCriterion("XSJBXX_XM <>", value, "xsjbxxXm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXmGreaterThan(String value) {
            addCriterion("XSJBXX_XM >", value, "xsjbxxXm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXmGreaterThanOrEqualTo(String value) {
            addCriterion("XSJBXX_XM >=", value, "xsjbxxXm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXmLessThan(String value) {
            addCriterion("XSJBXX_XM <", value, "xsjbxxXm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXmLessThanOrEqualTo(String value) {
            addCriterion("XSJBXX_XM <=", value, "xsjbxxXm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXmLike(String value) {
            addCriterion("XSJBXX_XM like", value, "xsjbxxXm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXmNotLike(String value) {
            addCriterion("XSJBXX_XM not like", value, "xsjbxxXm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXmIn(List<String> values) {
            addCriterion("XSJBXX_XM in", values, "xsjbxxXm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXmNotIn(List<String> values) {
            addCriterion("XSJBXX_XM not in", values, "xsjbxxXm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXmBetween(String value1, String value2) {
            addCriterion("XSJBXX_XM between", value1, value2, "xsjbxxXm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXmNotBetween(String value1, String value2) {
            addCriterion("XSJBXX_XM not between", value1, value2, "xsjbxxXm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXbIsNull() {
            addCriterion("XSJBXX_XB is null");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXbIsNotNull() {
            addCriterion("XSJBXX_XB is not null");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXbEqualTo(String value) {
            addCriterion("XSJBXX_XB =", value, "xsjbxxXb");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXbNotEqualTo(String value) {
            addCriterion("XSJBXX_XB <>", value, "xsjbxxXb");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXbGreaterThan(String value) {
            addCriterion("XSJBXX_XB >", value, "xsjbxxXb");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXbGreaterThanOrEqualTo(String value) {
            addCriterion("XSJBXX_XB >=", value, "xsjbxxXb");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXbLessThan(String value) {
            addCriterion("XSJBXX_XB <", value, "xsjbxxXb");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXbLessThanOrEqualTo(String value) {
            addCriterion("XSJBXX_XB <=", value, "xsjbxxXb");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXbLike(String value) {
            addCriterion("XSJBXX_XB like", value, "xsjbxxXb");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXbNotLike(String value) {
            addCriterion("XSJBXX_XB not like", value, "xsjbxxXb");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXbIn(List<String> values) {
            addCriterion("XSJBXX_XB in", values, "xsjbxxXb");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXbNotIn(List<String> values) {
            addCriterion("XSJBXX_XB not in", values, "xsjbxxXb");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXbBetween(String value1, String value2) {
            addCriterion("XSJBXX_XB between", value1, value2, "xsjbxxXb");
            return (Criteria) this;
        }

        public Criteria andXsjbxxXbNotBetween(String value1, String value2) {
            addCriterion("XSJBXX_XB not between", value1, value2, "xsjbxxXb");
            return (Criteria) this;
        }

        public Criteria andXsjbxxMmIsNull() {
            addCriterion("XSJBXX_MM is null");
            return (Criteria) this;
        }

        public Criteria andXsjbxxMmIsNotNull() {
            addCriterion("XSJBXX_MM is not null");
            return (Criteria) this;
        }

        public Criteria andXsjbxxMmEqualTo(String value) {
            addCriterion("XSJBXX_MM =", value, "xsjbxxMm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxMmNotEqualTo(String value) {
            addCriterion("XSJBXX_MM <>", value, "xsjbxxMm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxMmGreaterThan(String value) {
            addCriterion("XSJBXX_MM >", value, "xsjbxxMm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxMmGreaterThanOrEqualTo(String value) {
            addCriterion("XSJBXX_MM >=", value, "xsjbxxMm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxMmLessThan(String value) {
            addCriterion("XSJBXX_MM <", value, "xsjbxxMm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxMmLessThanOrEqualTo(String value) {
            addCriterion("XSJBXX_MM <=", value, "xsjbxxMm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxMmLike(String value) {
            addCriterion("XSJBXX_MM like", value, "xsjbxxMm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxMmNotLike(String value) {
            addCriterion("XSJBXX_MM not like", value, "xsjbxxMm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxMmIn(List<String> values) {
            addCriterion("XSJBXX_MM in", values, "xsjbxxMm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxMmNotIn(List<String> values) {
            addCriterion("XSJBXX_MM not in", values, "xsjbxxMm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxMmBetween(String value1, String value2) {
            addCriterion("XSJBXX_MM between", value1, value2, "xsjbxxMm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxMmNotBetween(String value1, String value2) {
            addCriterion("XSJBXX_MM not between", value1, value2, "xsjbxxMm");
            return (Criteria) this;
        }

        public Criteria andXsjbxxZymcIsNull() {
            addCriterion("XSJBXX_ZYMC is null");
            return (Criteria) this;
        }

        public Criteria andXsjbxxZymcIsNotNull() {
            addCriterion("XSJBXX_ZYMC is not null");
            return (Criteria) this;
        }

        public Criteria andXsjbxxZymcEqualTo(String value) {
            addCriterion("XSJBXX_ZYMC =", value, "xsjbxxZymc");
            return (Criteria) this;
        }

        public Criteria andXsjbxxZymcNotEqualTo(String value) {
            addCriterion("XSJBXX_ZYMC <>", value, "xsjbxxZymc");
            return (Criteria) this;
        }

        public Criteria andXsjbxxZymcGreaterThan(String value) {
            addCriterion("XSJBXX_ZYMC >", value, "xsjbxxZymc");
            return (Criteria) this;
        }

        public Criteria andXsjbxxZymcGreaterThanOrEqualTo(String value) {
            addCriterion("XSJBXX_ZYMC >=", value, "xsjbxxZymc");
            return (Criteria) this;
        }

        public Criteria andXsjbxxZymcLessThan(String value) {
            addCriterion("XSJBXX_ZYMC <", value, "xsjbxxZymc");
            return (Criteria) this;
        }

        public Criteria andXsjbxxZymcLessThanOrEqualTo(String value) {
            addCriterion("XSJBXX_ZYMC <=", value, "xsjbxxZymc");
            return (Criteria) this;
        }

        public Criteria andXsjbxxZymcLike(String value) {
            addCriterion("XSJBXX_ZYMC like", value, "xsjbxxZymc");
            return (Criteria) this;
        }

        public Criteria andXsjbxxZymcNotLike(String value) {
            addCriterion("XSJBXX_ZYMC not like", value, "xsjbxxZymc");
            return (Criteria) this;
        }

        public Criteria andXsjbxxZymcIn(List<String> values) {
            addCriterion("XSJBXX_ZYMC in", values, "xsjbxxZymc");
            return (Criteria) this;
        }

        public Criteria andXsjbxxZymcNotIn(List<String> values) {
            addCriterion("XSJBXX_ZYMC not in", values, "xsjbxxZymc");
            return (Criteria) this;
        }

        public Criteria andXsjbxxZymcBetween(String value1, String value2) {
            addCriterion("XSJBXX_ZYMC between", value1, value2, "xsjbxxZymc");
            return (Criteria) this;
        }

        public Criteria andXsjbxxZymcNotBetween(String value1, String value2) {
            addCriterion("XSJBXX_ZYMC not between", value1, value2, "xsjbxxZymc");
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