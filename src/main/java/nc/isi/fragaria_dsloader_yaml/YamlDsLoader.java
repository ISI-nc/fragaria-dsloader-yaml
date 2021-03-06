package nc.isi.fragaria_dsloader_yaml;

import java.io.IOException;
import java.util.Map;

import nc.isi.fragaria_adapter_rewrite.resources.ConnectionDataBuilder;
import nc.isi.fragaria_adapter_rewrite.resources.DataSourceMetadata;
import nc.isi.fragaria_adapter_rewrite.resources.Datasource;
import nc.isi.fragaria_adapter_rewrite.resources.DatasourceImpl;
import nc.isi.fragaria_adapter_rewrite.resources.SpecificDsLoader;
import nc.isi.fragaria_reflection.services.ResourceFinder;
import nc.isi.fragaria_reflection.utils.FragariaFileUtils;

import org.apache.log4j.Logger;

import com.google.common.collect.Maps;

/**
 * 
 * @author bjonathas Specific DsLoader permettant de charger une datasource
 *         depuis un fichier yaml
 */
public class YamlDsLoader implements SpecificDsLoader {
	private static final Logger LOGGER = Logger.getLogger(YamlDsLoader.class);
	private static final String YAML_REG_EXP = ".*\\.yaml";
	private final Map<String, Datasource> map = Maps.newHashMap();;
	private final YamlSerializer serializer;
	private final ConnectionDataBuilder builder;

	public YamlDsLoader(ResourceFinder finder, YamlSerializer serializer,
			ConnectionDataBuilder builder) {
		this.serializer = serializer;
		this.builder = builder;
		for (String fileName : finder.getResourcesMatching(YAML_REG_EXP)) {
			LOGGER.info("Ds file : " + fileName);
			String dsKey = getDsKey(fileName);
			try {
				map.put(dsKey, new DatasourceImpl(dsKey,
						buildDsMetadata(fileName)));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public Map<String, Datasource> getDs() {
		return map;
	}

	private String getDsKey(String fileName) {
		return FragariaFileUtils.removeExtension(fileName);
	}

	private DataSourceMetadata buildDsMetadata(String fileName)
			throws IOException {
		YamlDatasourceMetadata yamlDs = serializer.serialize(fileName,
				YamlDatasourceMetadata.class);
		return new DataSourceMetadata(yamlDs.getType(), builder.build(
				yamlDs.getType(), yamlDs.getConnectionData().values()),
				yamlDs.canEmbed());
	}

}
