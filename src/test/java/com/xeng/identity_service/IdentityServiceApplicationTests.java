package com.xeng.identity_service;

import jakarta.xml.bind.DatatypeConverter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
@SpringBootTest
class IdentityServiceApplicationTests {

	@Test
	void hash() throws NoSuchAlgorithmException {
		String password = "123456";
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");

		messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
		byte[] digest = messageDigest.digest();
		String md5Hash = DatatypeConverter.printHexBinary(digest);
		log.info("MD5 round 1: {}", md5Hash);

		messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
		digest = messageDigest.digest();
		md5Hash = DatatypeConverter.printHexBinary(digest);
		log.info("MD5 round 2: {}", md5Hash);

		messageDigest.update("123".getBytes(StandardCharsets.UTF_8));
		messageDigest.update("456".getBytes(StandardCharsets.UTF_8));
		byte[] digest2 = messageDigest.digest();
		md5Hash = DatatypeConverter.printHexBinary(digest2);
		log.info("MD5 round 3: {}", md5Hash);

		messageDigest.update("123".getBytes(StandardCharsets.UTF_8));
		messageDigest.update("456".getBytes(StandardCharsets.UTF_8));
		byte[] digest3 = messageDigest.digest();
		md5Hash = DatatypeConverter.printHexBinary(digest3);
		log.info("MD5 round 4: {}", md5Hash);

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
		log.info("Bcrypt round 1: {}", passwordEncoder.encode(password));
		log.info("Bcrypt round 2: {}", passwordEncoder.encode(password));
	}
	void contextLoads() {
	}

}
