package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.RoleDao;
import com.lawencon.elearn.model.Role;

@Repository
@Profile("hql")
public class RoleDaoImpl extends BaseDaoImpl implements RoleDao {
	
	@Override
	public Role insert(final Role data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public Role update(final Role data) {
		final Role result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<Role> getById(final Long id) {
		final Role result = this.em.find(Role.class, id);
		em.detach(result);
		final Optional<Role> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<Role> getAll() {
		final String sql = " SELECT doc FROM Role doc ";
		final List<Role> result = this.em.createQuery(sql, Role.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM Role WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
	@Override
	public Optional<Role> getByCode(final String code) {
		final String sql = "SELECT r FROM Role r WHERE lower(r.code) = lower(:code)";
		final Role result = this.em.createQuery(sql, Role.class).setParameter("code", code).getSingleResult();
		em.detach(result);
		final Optional<Role> optional = Optional.ofNullable(result);
		return optional;
	}
	
}
