package kr.co.jhta.web.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		System.out.println("패스워드 : "+ rawPassword);
		return rawPassword.toString();//캐릭터 타입이라 toString을 써야함
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		//입력된 패스워드와 인코딩 패스워드가 동인한지 여부를 리턴
		
		return rawPassword.toString().equals(encodedPassword);
	}

}
