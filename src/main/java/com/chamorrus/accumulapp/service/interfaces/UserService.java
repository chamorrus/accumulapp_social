package com.chamorrus.accumulapp.service.interfaces;

import java.security.Principal;

import com.chamorrus.accumulapp.persistence.model.AccumulappUser;
import com.chamorrus.accumulapp.persistence.model.VerificationToken;
import com.chamorrus.accumulapp.web.dto.UserDto;

public interface UserService {
	public AccumulappUser registerNewUserAccount(final UserDto userDto);

	public AccumulappUser findByEmail(String email);

	public AccumulappUser getUser(String verificationToken);

	public void saveRegisteredUser(final AccumulappUser user);

	public void deleteUser(final AccumulappUser user);

	public void createVerificationToken(AccumulappUser user, String token);

	public VerificationToken getVerificationToken(String VerificationToken);

	public VerificationToken renewVerificationToken(AccumulappUser user, String VerificationToken);
}
