package com.auth.dao;

import com.auth.models.ApplicationUser;

public interface ApplicationUserDao {

	public ApplicationUser find(String username);
}
