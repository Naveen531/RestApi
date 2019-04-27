package com.chitiapp.security;

import static com.chitiapp.security.SecurityConstants.EXPIRATION_TIME;
import static com.chitiapp.security.SecurityConstants.HEADER_STRING;
import static com.chitiapp.security.SecurityConstants.SECRET;
import static com.chitiapp.security.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.chitiapp.model.LoginRequest;
import com.chitiapp.model.Users;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {

		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {
			System.out.println("===========================================" + req.getContextPath());

//			InputStream is = req.getInputStream();
//			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//			String buffer = null;
//			//System.out.println(br.readLine()==null);
//			while ((buffer = br.readLine()) != null) {
//				System.out.println(buffer);
//			}
			LoginRequest creds = new ObjectMapper().readValue(req.getInputStream(), LoginRequest.class);
			System.out.println(creds.getUsername()+" , "+creds.getPassword());
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					creds.getUsername(), creds.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		
		System.out.println("In Successful Authentication==========");
		System.out.println(((User) auth.getPrincipal()).getUsername());
		String token = Jwts.builder().setSubject(((User) auth.getPrincipal()).getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		//res.addHeader("Access-Control-Allow-Origin", "*");
		//res.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		res.setHeader("access-control-expose-headers", "test");
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
		res.addHeader("test", token);
	
	}

}
