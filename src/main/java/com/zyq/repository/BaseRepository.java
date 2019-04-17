package com.zyq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zyq.beans.BaseBean;

/**
 * @author zyq
 * @date 2019-04-17
 * @param <T>
 */
@Repository
public interface BaseRepository<T extends BaseBean> extends JpaRepository<T, Long> {

}
