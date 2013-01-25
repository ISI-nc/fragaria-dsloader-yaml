package nc.isi.fragaria_dsloader_yaml.model;


import org.apache.tapestry5.ioc.Registry;
import org.apache.tapestry5.ioc.RegistryBuilder;

public enum QaRegistry {
	INSTANCE;

	private final Registry registry = RegistryBuilder
			.buildAndStartupRegistry(QAModule.class);

	public Registry getRegistry() {
		return registry;
	}

}
