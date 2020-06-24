package sz.schlamm.jaspic;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Bean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2751397822721160125L;
	private int counter = 0;
	
	public int getCounter() {
		return counter++;
	}
}
