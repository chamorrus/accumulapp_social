package com.chamorrus.accumulapp.service;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chamorrus.accumulapp.persistence.dao.AccumulappRoleRepository;
import com.chamorrus.accumulapp.persistence.dao.AccumulappUserRepository;
import com.chamorrus.accumulapp.persistence.dao.VerificationTokenRepository;
import com.chamorrus.accumulapp.persistence.model.AccumulappUser;
import com.chamorrus.accumulapp.persistence.model.VerificationToken;
import com.chamorrus.accumulapp.service.interfaces.UserService;
import com.chamorrus.accumulapp.web.dto.UserDto;
import com.chamorrus.accumulapp.web.error.UserAlreadyExistsException;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private AccumulappUserRepository userEntityRepository;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AccumulappRoleRepository roleRepository;

	@Override
	public AccumulappUser registerNewUserAccount(final UserDto userDto) {
		if (emailExist(userDto.getEmail())) {
			throw new UserAlreadyExistsException("There is an account with that email adress: " + userDto.getEmail());
		}
		final AccumulappUser userEntity = new AccumulappUser();
		// userEntity.setFirstName(userDto.getFirstName());
		// userEntity.setLastName(userDto.getLastName());
		userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userEntity.setEmail(userDto.getEmail());
		// userEntity.setUsing2FA(userDto.isUsing2FA());
		userEntity.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
		return userEntityRepository.save(userEntity);
	}

	@Override
	public AccumulappUser findByEmail(String email) {
		return userEntityRepository.findByEmail(email);
	}

	@Override
	public AccumulappUser getUser(String verificationToken) {
		AccumulappUser user = verificationTokenRepository.findByToken(verificationToken).getUserEntity();
		return user;
	}

	@Override
	public void saveRegisteredUser(final AccumulappUser user) {
		userEntityRepository.save(user);
	}

	@Override
	public void deleteUser(final AccumulappUser user) {
		final VerificationToken verificationToken = verificationTokenRepository.findByUser(user);

		if (verificationToken != null) {
			verificationTokenRepository.delete(verificationToken);
		}

		userEntityRepository.delete(user);
	}

	@Override
	public VerificationToken getVerificationToken(String VerificationToken) {
		return verificationTokenRepository.findByToken(VerificationToken);
	}

	@Override
	public void createVerificationToken(AccumulappUser user, String token) {
		VerificationToken myToken = new VerificationToken(token, user);
		verificationTokenRepository.save(myToken);
	}

	@Override
	public VerificationToken renewVerificationToken(AccumulappUser user, String token) {
		return null;
	}

	// Check whether the email exists yet.
	private boolean emailExist(final String email) {
		return userEntityRepository.findByEmail(email) != null;
	}
}