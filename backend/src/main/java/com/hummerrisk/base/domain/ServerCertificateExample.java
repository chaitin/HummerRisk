package com.hummerrisk.base.domain;

import java.util.ArrayList;
import java.util.List;

public class ServerCertificateExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
    public ServerCertificateExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andIsPublicKeyIsNull() {
            addCriterion("is_public_key is null");
            return (Criteria) this;
        }

        public Criteria andIsPublicKeyIsNotNull() {
            addCriterion("is_public_key is not null");
            return (Criteria) this;
        }

        public Criteria andIsPublicKeyEqualTo(String value) {
            addCriterion("is_public_key =", value, "isPublicKey");
            return (Criteria) this;
        }

        public Criteria andIsPublicKeyNotEqualTo(String value) {
            addCriterion("is_public_key <>", value, "isPublicKey");
            return (Criteria) this;
        }

        public Criteria andIsPublicKeyGreaterThan(String value) {
            addCriterion("is_public_key >", value, "isPublicKey");
            return (Criteria) this;
        }

        public Criteria andIsPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("is_public_key >=", value, "isPublicKey");
            return (Criteria) this;
        }

        public Criteria andIsPublicKeyLessThan(String value) {
            addCriterion("is_public_key <", value, "isPublicKey");
            return (Criteria) this;
        }

        public Criteria andIsPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("is_public_key <=", value, "isPublicKey");
            return (Criteria) this;
        }

        public Criteria andIsPublicKeyLike(String value) {
            addCriterion("is_public_key like", value, "isPublicKey");
            return (Criteria) this;
        }

        public Criteria andIsPublicKeyNotLike(String value) {
            addCriterion("is_public_key not like", value, "isPublicKey");
            return (Criteria) this;
        }

        public Criteria andIsPublicKeyIn(List<String> values) {
            addCriterion("is_public_key in", values, "isPublicKey");
            return (Criteria) this;
        }

        public Criteria andIsPublicKeyNotIn(List<String> values) {
            addCriterion("is_public_key not in", values, "isPublicKey");
            return (Criteria) this;
        }

        public Criteria andIsPublicKeyBetween(String value1, String value2) {
            addCriterion("is_public_key between", value1, value2, "isPublicKey");
            return (Criteria) this;
        }

        public Criteria andIsPublicKeyNotBetween(String value1, String value2) {
            addCriterion("is_public_key not between", value1, value2, "isPublicKey");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("`password` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPublicKeyPathIsNull() {
            addCriterion("public_key_path is null");
            return (Criteria) this;
        }

        public Criteria andPublicKeyPathIsNotNull() {
            addCriterion("public_key_path is not null");
            return (Criteria) this;
        }

        public Criteria andPublicKeyPathEqualTo(String value) {
            addCriterion("public_key_path =", value, "publicKeyPath");
            return (Criteria) this;
        }

        public Criteria andPublicKeyPathNotEqualTo(String value) {
            addCriterion("public_key_path <>", value, "publicKeyPath");
            return (Criteria) this;
        }

        public Criteria andPublicKeyPathGreaterThan(String value) {
            addCriterion("public_key_path >", value, "publicKeyPath");
            return (Criteria) this;
        }

        public Criteria andPublicKeyPathGreaterThanOrEqualTo(String value) {
            addCriterion("public_key_path >=", value, "publicKeyPath");
            return (Criteria) this;
        }

        public Criteria andPublicKeyPathLessThan(String value) {
            addCriterion("public_key_path <", value, "publicKeyPath");
            return (Criteria) this;
        }

        public Criteria andPublicKeyPathLessThanOrEqualTo(String value) {
            addCriterion("public_key_path <=", value, "publicKeyPath");
            return (Criteria) this;
        }

        public Criteria andPublicKeyPathLike(String value) {
            addCriterion("public_key_path like", value, "publicKeyPath");
            return (Criteria) this;
        }

        public Criteria andPublicKeyPathNotLike(String value) {
            addCriterion("public_key_path not like", value, "publicKeyPath");
            return (Criteria) this;
        }

        public Criteria andPublicKeyPathIn(List<String> values) {
            addCriterion("public_key_path in", values, "publicKeyPath");
            return (Criteria) this;
        }

        public Criteria andPublicKeyPathNotIn(List<String> values) {
            addCriterion("public_key_path not in", values, "publicKeyPath");
            return (Criteria) this;
        }

        public Criteria andPublicKeyPathBetween(String value1, String value2) {
            addCriterion("public_key_path between", value1, value2, "publicKeyPath");
            return (Criteria) this;
        }

        public Criteria andPublicKeyPathNotBetween(String value1, String value2) {
            addCriterion("public_key_path not between", value1, value2, "publicKeyPath");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIsNull() {
            addCriterion("last_modified is null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIsNotNull() {
            addCriterion("last_modified is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedEqualTo(Long value) {
            addCriterion("last_modified =", value, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedNotEqualTo(Long value) {
            addCriterion("last_modified <>", value, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedGreaterThan(Long value) {
            addCriterion("last_modified >", value, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedGreaterThanOrEqualTo(Long value) {
            addCriterion("last_modified >=", value, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedLessThan(Long value) {
            addCriterion("last_modified <", value, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedLessThanOrEqualTo(Long value) {
            addCriterion("last_modified <=", value, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIn(List<Long> values) {
            addCriterion("last_modified in", values, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedNotIn(List<Long> values) {
            addCriterion("last_modified not in", values, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedBetween(Long value1, Long value2) {
            addCriterion("last_modified between", value1, value2, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedNotBetween(Long value1, Long value2) {
            addCriterion("last_modified not between", value1, value2, "lastModified");
            return (Criteria) this;
        }

        public Criteria andProxyIdIsNull() {
            addCriterion("proxy_id is null");
            return (Criteria) this;
        }

        public Criteria andProxyIdIsNotNull() {
            addCriterion("proxy_id is not null");
            return (Criteria) this;
        }

        public Criteria andProxyIdEqualTo(Integer value) {
            addCriterion("proxy_id =", value, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdNotEqualTo(Integer value) {
            addCriterion("proxy_id <>", value, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdGreaterThan(Integer value) {
            addCriterion("proxy_id >", value, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("proxy_id >=", value, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdLessThan(Integer value) {
            addCriterion("proxy_id <", value, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdLessThanOrEqualTo(Integer value) {
            addCriterion("proxy_id <=", value, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdIn(List<Integer> values) {
            addCriterion("proxy_id in", values, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdNotIn(List<Integer> values) {
            addCriterion("proxy_id not in", values, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdBetween(Integer value1, Integer value2) {
            addCriterion("proxy_id between", value1, value2, "proxyId");
            return (Criteria) this;
        }

        public Criteria andProxyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("proxy_id not between", value1, value2, "proxyId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table server_certificate
     *
     * @mbg.generated do_not_delete_during_merge Wed Sep 21 13:59:35 CST 2022
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table server_certificate
     *
     * @mbg.generated Wed Sep 21 13:59:35 CST 2022
     */
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