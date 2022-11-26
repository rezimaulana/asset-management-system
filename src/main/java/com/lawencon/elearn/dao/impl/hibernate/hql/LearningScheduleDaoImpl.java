package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.LearningScheduleDao;
import com.lawencon.elearn.model.LearningSchedule;

@Repository
@Profile("hql")
public class LearningScheduleDaoImpl extends BaseDaoImpl implements LearningScheduleDao{
	
	@Override
	public LearningSchedule insert(final LearningSchedule data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public LearningSchedule update(final LearningSchedule data) {
		final LearningSchedule result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<LearningSchedule> getById(final Long id) {
		final LearningSchedule result = this.em.find(LearningSchedule.class, id);
		em.detach(result);
		final Optional<LearningSchedule> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<LearningSchedule> getAll() {
		final String sql = " SELECT doc FROM LearningSchedule doc ";
		final List<LearningSchedule> result = this.em.createQuery(sql, LearningSchedule.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM LearningSchedule WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
	@Override
	public List<LearningSchedule> getAllIdMaterial(final Long idMaterial) {
		final String sql = "SELECT schedule "
				+ "FROM LearningSchedule schedule "
				+ "INNER JOIN FETCH schedule.learningMaterial material "
				+ "WHERE material.id = :id ";
		final List<LearningSchedule> result = this.em.createQuery(sql, LearningSchedule.class)
				.setParameter("id", idMaterial).getResultList();
		return result;
	}

	@Override
	public List<LearningSchedule> getAllIdClassHdr(final Long classHdrId) {
		final String sql = "SELECT schedule "
				+ "FROM LearningSchedule schedule "
				+ "INNER JOIN FETCH schedule.learningMaterial material "
				+ "INNER JOIN FETCH material.classHdr ch "
				+ "WHERE ch.id = :id ";
		final List<LearningSchedule> result = this.em.createQuery(sql, LearningSchedule.class)
				.setParameter("id", classHdrId).getResultList();
		return result;
	}
	
}
