package sz.schlamm.jaspic;

import java.util.Collections;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.AutoApplySession;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ApplicationScoped
@AutoApplySession
public class Authenticator implements HttpAuthenticationMechanism {

	@Override
	public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response,
			HttpMessageContext httpMessageContext) throws AuthenticationException {
		
		System.out.println("Auth");
		
		String secret = request.getHeader("secret");
		if ("shampoo".equals(secret)) { 
			return httpMessageContext.notifyContainerAboutLogin("Heinz", Collections.singleton("admin"));
		}
		
		return httpMessageContext.responseUnauthorized();
	}

}
