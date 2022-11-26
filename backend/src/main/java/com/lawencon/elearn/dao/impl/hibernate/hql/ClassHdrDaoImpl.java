package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.ClassHdrDao;
import com.lawencon.elearn.model.ClassHdr;

@Repository
@Profile("hql")
public class ClassHdrDaoImpl extends BaseDaoImpl implements ClassHdrDao {
	
	@Override
	public ClassHdr insert(final ClassHdr data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public ClassHdr update(final ClassHdr data) {
		final ClassHdr result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<ClassHdr> getById(final Long id) {
		final ClassHdr result = this.em.find(ClassHdr.class, id);
		em.detach(result);
		final Optional<ClassHdr> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<ClassHdr> getAll() {
		final String sql = " SELECT doc FROM ClassHdr doc ";
		final List<ClassHdr> result = this.em.createQuery(sql, ClassHdr.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM ClassHdr WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}

	@Override
	public List<ClassHdr> getAllIdInstr(final Long id) {
		final String sql = "SELECT c "
				+ "FROM ClassHdr c "
				+ "INNER JOIN FETCH c.instructor u "
				+ "WHERE u.id = :id ";
		final List<ClassHdr> result = this.em.createQuery(sql, ClassHdr.class)
				.setParameter("id", id).getResultList();
		return result;
	}

	@Override
	public Optional<ClassHdr> getByIdInstrIdClass(final Long idInstr, final Long idClass) {
		final String sql = "SELECT c "
				+ "FROM ClassHdr c "
				+ "INNER JOIN FETCH c.instructor u "
				+ "WHERE u.id = :id1 AND c.id = :id2 ";
		final ClassHdr result = this.em.createQuery(sql, ClassHdr.class)
				.setParameter("id1", idInstr).setParameter("id2", idClass).getSingleResult();
		final Optional<ClassHdr> optional = Optional.ofNullable(result);
		return optional;
	}

}
