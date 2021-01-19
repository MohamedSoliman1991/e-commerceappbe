package ae.task.ecomperceappbe.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "configurations")

public class configuration {
	  @Id
	  //@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	  @Column(name="CONFIG_KEY")
	private String configKey;
	  @Column(name="CONFIG_VALUE")
	private String configValue;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConfigKey() {
		return configKey;
	}
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
}
