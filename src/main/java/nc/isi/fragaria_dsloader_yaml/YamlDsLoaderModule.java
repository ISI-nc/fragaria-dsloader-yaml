package nc.isi.fragaria_dsloader_yaml;

import nc.isi.fragaria_adapter_rewrite.resources.SpecificDsLoader;
import nc.isi.fragaria_adapter_rewrite.services.FragariaDomainModule;

import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.SubModule;

@SubModule(FragariaDomainModule.class)
public class YamlDsLoaderModule {
	public static void bind(ServiceBinder binder) {
		binder.bind(YamlDsLoader.class);
		binder.bind(YamlSerializer.class);
	}

	public void contributeMasterDsLoader(
			Configuration<SpecificDsLoader> configuration,
			YamlDsLoader yamlDsLoader) {
		configuration.add(yamlDsLoader);
	}

}
