package comsilly.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
//@ToString @RequiredArgsConstructor @Getter
@Data // Ïª§ÏÑú?ò¨?†§?Ñú ?Üç?Ñ±Î≥¥Í∏∞
public class Restaurant {
	@Autowired
	private Chef chef;

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
}
