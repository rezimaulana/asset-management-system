package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.ExamScheduleDao;
import com.lawencon.elearn.model.ExamSchedule;

@Repository
@Profile("hql")
public class ExamScheduleDaoImpl extends BaseDaoImpl implements ExamScheduleDao{
	
	@Override
	public ExamSchedule insert(final ExamSchedule data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public ExamSchedule update(final ExamSchedule data) {
		final ExamSchedule result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<ExamSchedule> getById(final Long id) {
		final ExamSchedule result = this.em.find(ExamSchedule.class, id);
		em.detach(result);
		final Optional<ExamSchedule> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<ExamSchedule> getAll() {
		final String sql = " SELECT doc FROM ExamSchedule doc ";
		final List<ExamSchedule> result = this.em.createQuery(sql, ExamSchedule.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM ExamSchedule WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}

	@Override
	public List<ExamSchedule> getAllIdMaterial(final Long idMaterial) {
		final String sql = "SELECT schedule "
				+ "FROM ExamSchedule schedule "
				+ "INNER JOIN FETCH schedule.examMaterial material "
				+ "WHERE material.id = :id ";
		final List<ExamSchedule> result = this.em.createQuery(sql, ExamSchedule.class)
				.setParameter("id", idMaterial).getResultList();
		return result;
	}

	@Override
	public List<ExamSchedule> getAllIdClassHdr(final Long classHdrId) {
		final String sql = "SELECT schedule "
				+ "FROM ExamSchedule schedule "
				+ "INNER JOIN FETCH schedule.examMaterial material "
				+ "INNER JOIN FETCH material.classHdr ch "
				+ "WHERE ch.id = :id ";
		final List<ExamSchedule> result = this.em.createQuery(sql, ExamSchedule.class)
				.setParameter("id", classHdrId).getResultList();
		return result;
	}

}
