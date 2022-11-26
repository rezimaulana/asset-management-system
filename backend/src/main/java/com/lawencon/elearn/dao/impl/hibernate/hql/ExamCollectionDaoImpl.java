package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.ExamCollectionDao;
import com.lawencon.elearn.model.ExamCollection;

@Repository
@Profile("hql")
public class ExamCollectionDaoImpl extends BaseDaoImpl implements ExamCollectionDao{
	
	@Override
	public ExamCollection insert(final ExamCollection data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public ExamCollection update(final ExamCollection data) {
		final ExamCollection result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<ExamCollection> getById(Long id) {
		final ExamCollection result = this.em.find(ExamCollection.class, id);
		em.detach(result);
		final Optional<ExamCollection> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<ExamCollection> getAll() {
		final String sql = " SELECT doc FROM ExamCollection doc ";
		final List<ExamCollection> result = this.em.createQuery(sql, ExamCollection.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM ExamCollection WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
	@Override
	public List<ExamCollection> getAllClsDtlIdScheduleId(final long classDtlId, final long scheduleId) {
		final String sql = "SELECT col "
				+ "FROM ExamCollection col "
				+ "INNER JOIN FETCH col.classDtl cd "
				+ "INNER JOIN FETCH cd.student s "
				+ "INNER JOIN FETCH col.file f "
				+ "INNER JOIN FETCH col.examSchedule es "
				+ "WHERE cd.id = :classDtlId "
				+ "AND es.id = :scheduleId ";
		final List<ExamCollection> result = this.em.createQuery(sql, ExamCollection.class)
				.setParameter("classDtlId", classDtlId).setParameter("scheduleId", scheduleId).getResultList();
		return result;
	}
	
	
	
}
