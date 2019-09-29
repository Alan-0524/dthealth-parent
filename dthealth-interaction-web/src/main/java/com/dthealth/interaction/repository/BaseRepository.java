package com.dthealth.interaction.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

public abstract class BaseRepository<T> {
    @Autowired
    MongoTemplate mongoTemplate;

    abstract Class getEntityClass();

    public QueryResult<T> findByPage(QueryCondition queryCondition, int page, int rows) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        List<Map<String, Object>> list = queryCondition.getList();
        for (Map<String, Object> map : list) {
            char type = (char) map.get(QueryCondition.QUERY_TYPE);
            map.get(QueryCondition.ATTRIBUTE);
            if (verifyEmpty(map.get(QueryCondition.ATTRIBUTE), map.get(QueryCondition.VALUE))) {
                switch (type) {
                    case QueryCondition.EXACT:
                        criteria.and(map.get(QueryCondition.ATTRIBUTE).toString()).is(map.get(QueryCondition.VALUE));
                        break;
                    case QueryCondition.FUZZY:
                        criteria.and(map.get(QueryCondition.ATTRIBUTE).toString()).regex(".*?" + map.get(QueryCondition.VALUE) + ".*");
                        break;
                    case QueryCondition.SEGMENTATION_IN:
                        criteria.and(map.get(QueryCondition.ATTRIBUTE).toString()).gte(map.get(QueryCondition.LESS)).lte(map.get(QueryCondition.GREATER));
                        break;
                    case QueryCondition.SEGMENTATION_LESS:
                        criteria.and(map.get(QueryCondition.ATTRIBUTE).toString()).lte(map.get(QueryCondition.VALUE));
                        break;
                    case QueryCondition.SEGMENTATION_GREATER:
                        criteria.and(map.get(QueryCondition.ATTRIBUTE).toString()).gte(map.get(QueryCondition.VALUE));
                        break;
                }
            }
            if (!StringUtils.isEmpty(queryCondition.getOrderedAttribute()) && !StringUtils.isEmpty(queryCondition.getOrderType())) {
                Sort.Direction e = queryCondition.getOrderType() == 0 ? Sort.Direction.ASC : Sort.Direction.DESC;
                query.with(new Sort(e, queryCondition.getOrderedAttribute()));
            }
            query.addCriteria(criteria);
        }

        long count = mongoTemplate.count(query, getEntityClass());
        Pageable pageable = PageRequest.of(page, rows);
        List<T> listObject = mongoTemplate.find(query.with(pageable), getEntityClass());
        QueryResult<T> queryResult = new QueryResult<>();
        queryResult.setTotal(count);
        queryResult.setRows(listObject);
        return queryResult;
    }

    private boolean verifyEmpty(Object attribute, Object value) {
        return !StringUtils.isEmpty(attribute) && !StringUtils.isEmpty(value);
    }

    public T save(T t) {
        return mongoTemplate.save(t);
    }

    public T findOneObject(QueryCondition queryCondition) {
        Criteria criteria = new Criteria();
        Query query = new Query();
        criteria.and(queryCondition.getMap().get(QueryCondition.ATTRIBUTE).toString())
                .is(queryCondition.getMap().get(QueryCondition.VALUE).toString());
        query.addCriteria(criteria);
        return (T) mongoTemplate.findOne(query, getEntityClass());
    }

    public void delete(T t) {
        mongoTemplate.remove(t);
    }

    public boolean exist(QueryCondition queryCondition) {
        Criteria criteria = new Criteria();
        Query query = new Query();
        criteria.and(queryCondition.getMap().get(QueryCondition.ATTRIBUTE).toString())
                .is(queryCondition.getMap().get(QueryCondition.VALUE).toString());
        query.addCriteria(criteria);
        return mongoTemplate.exists(query, getEntityClass());
    }
}
