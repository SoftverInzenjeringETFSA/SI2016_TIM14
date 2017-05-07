package bll.auth;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import common.exception.ExpiredAuthenticationException;
import common.exception.UnauthorizedException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtService {

	static final long EXPIRATIONTIME = 28800000; // 8 hours
	static final String SECRET = "wqp6iP5i8P1mIvdSRnbLcoFvHvkDplwlGjDM2WugWpc09U1HyUFxJGLOma8F5jb"; // thanks to https://www.grc.com/passwords.htm :)

	public static String issueToken(Boolean isAdmin) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("isAdmin", isAdmin);

		return Jwts.builder()
				.setClaims(claims)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SECRET)
				.compact();
	}
	
	public static Boolean verifyToken(String jwt) {
		if (jwt == null) {
			return false;
		}
		
		try {
			Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwt);
		}
		catch (ExpiredJwtException e) {
			throw new ExpiredAuthenticationException();
		}
		catch (Exception e) {
			throw new UnauthorizedException();
		}

		return true;
	}
	
	public static Boolean verifyTokenForAdmin(String jwt) {
		if (jwt == null) {
			return false;
		}
		
		try {
			Jwts.parser().setSigningKey(SECRET).require("isAdmin", true).parseClaimsJws(jwt);
		}
		catch (ExpiredJwtException e) {
			throw new ExpiredAuthenticationException();
		}
		catch (Exception e) {
			throw new UnauthorizedException();
		}

		return true;
	}
}
