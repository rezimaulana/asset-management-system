package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.ClassDtlDao;
import com.lawencon.elearn.model.ClassDtl;

@Repository
@Profile("hql")
public class ClassDtlDaoImpl extends BaseDaoImpl implements ClassDtlDao{

	@Override
	public ClassDtl insert(final ClassDtl data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public ClassDtl update(final ClassDtl data) {
		final ClassDtl result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<ClassDtl> getById(Long id) {
		final ClassDtl result = this.em.find(ClassDtl.class, id);
		em.detach(result);
		final Optional<ClassDtl> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<ClassDtl> getAll() {
		final String sql = " SELECT doc FROM ClassDtl doc ";
		final List<ClassDtl> result = this.em.createQuery(sql, ClassDtl.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM ClassDtl WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}

	@Override
	public List<ClassDtl> getAllIdStudent(final Long id) {
		final String sql = "SELECT cd "
				+ "FROM ClassDtl cd "
				+ "INNER JOIN FETCH cd.classHdr c "
				+ "INNER JOIN FETCH c.instructor i "
				+ "INNER JOIN FETCH cd.student s "
				+ "INNER JOIN FETCH c.photo f "
				+ "WHERE s.id = :id";
		final List<ClassDtl> result = this.em.createQuery(sql, ClassDtl.class)
				.setParameter("id", id).getResultList();
		return result;
	}

	@Override
	public Optional<ClassDtl> getByIdStudentIdClass(Long id) {
		final String sql = "SELECT cd "
				+ "FROM ClassDtl cd "
				+ "INNER JOIN FETCH cd.classHdr c "
				+ "INNER JOIN FETCH c.instructor i "
				+ "WHERE cd.id = :id";
		final ClassDtl result = this.em.createQuery(sql, ClassDtl.class)
				.setParameter("id", id).getSingleResult();
		em.detach(result);
		final Optional<ClassDtl> optional = Optional.ofNullable(result);
		return optional;
	}

}
