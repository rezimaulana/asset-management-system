package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.AttendanceDao;
import com.lawencon.elearn.model.Attendance;

@Repository
@Profile("hql")
public class AttendanceDaoImpl extends BaseDaoImpl implements AttendanceDao {

	@Override
	public Attendance insert(final Attendance data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public Attendance update(final Attendance data) {
		final Attendance result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<Attendance> getById(final Long id) {
		final Attendance result = this.em.find(Attendance.class, id);
		em.detach(result);
		final Optional<Attendance> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<Attendance> getAll() {
		final String sql = " SELECT doc FROM Attendance doc ";
		final List<Attendance> result = this.em.createQuery(sql, Attendance.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM Attendance WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}

	@Override
	public List<Attendance> getAttendLearn(final Long scheduleId) {
		final String sql = "SELECT doc FROM Attendance doc "
				+ "INNER JOIN FETCH doc.learningSchedule s "
				+ "WHERE s.id = :scheduleId AND s.id IS NOT NULL ";
		final List<Attendance> result = this.em.createQuery(sql, Attendance.class)
				.setParameter("scheduleId", scheduleId).getResultList();
		return result;
	}

	@Override
	public List<Attendance> getAttendQuiz(final Long scheduleId) {
		final String sql = "SELECT doc FROM Attendance doc "
				+ "INNER JOIN FETCH doc.quizSchedule s "
				+ "WHERE s.id = :scheduleId AND s.id IS NOT NULL ";
		final List<Attendance> result = this.em.createQuery(sql, Attendance.class)
				.setParameter("scheduleId", scheduleId).getResultList();
		return result;
	}

	@Override
	public List<Attendance> getAttendExam(final Long scheduleId) {
		final String sql = "SELECT doc FROM Attendance doc "
				+ "INNER JOIN FETCH doc.examSchedule s "
				+ "WHERE s.id = :scheduleId AND s.id IS NOT NULL ";
		final List<Attendance> result = this.em.createQuery(sql, Attendance.class)
				.setParameter("scheduleId", scheduleId).getResultList();
		return result;
	}

}
