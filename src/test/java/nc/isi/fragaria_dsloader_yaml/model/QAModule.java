package nc.isi.fragaria_dsloader_yaml.model;

import nc.isi.fragaria_dsloader_yaml.YamlDsLoaderModule;

import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.SubModule;

@SubModule(YamlDsLoaderModule.class)
public class QAModule {

	public void contributeConnectionDataBuilder(
			MappedConfiguration<String, String> configuration) {
		configuration.add("test", SampleConnectionData.class.getName());
	}

	public void contributeReflectionProvider(Configuration<String> configuration) {
		configuration.add("nc.isi.fragaria_dsloader_yaml");
	}

}
