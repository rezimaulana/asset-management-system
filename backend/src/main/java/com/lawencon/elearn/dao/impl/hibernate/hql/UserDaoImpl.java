package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.UserDao;
import com.lawencon.elearn.model.User;

@Repository
@Profile("hql")
public class UserDaoImpl extends BaseDaoImpl implements UserDao{
	
	@Override
	public Optional<User> getByEmail(final String email)  {		
		final String sql = " SELECT u "
				+ "FROM User u "
				+ "INNER JOIN FETCH u.role r "
				+ "WHERE u.email = :email";
		final User result = this.em.createQuery(sql, User.class).setParameter("email", email).getSingleResult();
		final Optional<User> userOptional = Optional.ofNullable(result);
		return userOptional;
	}
	
	@Override
	public User insert(final User data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public User update(final User data) {
		final User result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<User> getById(final Long id) {
		final User result = this.em.find(User.class, id);
		em.detach(result);
		final Optional<User> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<User> getAll() {
		final String sql = " SELECT doc FROM User doc ";
		final List<User> result = this.em.createQuery(sql, User.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM User WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
}
