package com.lhsystems.usersadmin.doa;

import com.lhsystems.usersadmin.domain.User;

public interface UserDao
{

	public void create(User user);

	public User update(User user);

	public User find(Long userId);

	public User findByUsername(String username);

}
