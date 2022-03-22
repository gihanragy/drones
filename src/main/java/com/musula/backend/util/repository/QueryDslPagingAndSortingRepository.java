package com.musula.backend.util.repository;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * merge pagination, sorting and query Dsl interfaces with generic query dsl binding
 *
 * @param <T>  Entity Class
 * @param <ID> Entity ID type
 * @param <Q>  EntityPathBase class for the entity class
 */
@NoRepositoryBean
public interface QueryDslPagingAndSortingRepository<T, ID extends Serializable, Q extends EntityPath<?>>
        extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T>, QuerydslBinderCustomizer<Q> {
    @Override
    default void customize(QuerydslBindings bindings, Q root) {
        bindings.bind(String.class).first(
                (SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}
