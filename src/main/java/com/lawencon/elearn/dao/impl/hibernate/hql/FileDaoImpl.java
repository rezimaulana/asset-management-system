package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.FileDao;
import com.lawencon.elearn.model.File;

@Repository
@Profile("hql")
public class FileDaoImpl extends BaseDaoImpl implements FileDao{
	
	@Override
	public File insert(final File data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public File update(final File data) {
		final File result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<File> getById(final Long id) {
		final File result = this.em.find(File.class, id);
		em.detach(result);
		final Optional<File> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<File> getAll() {
		final String sql = " SELECT doc FROM File doc ";
		final List<File> result = this.em.createQuery(sql, File.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM File WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
}
