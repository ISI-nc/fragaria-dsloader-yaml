package nc.isi.fragaria_adapter_rewrite;

import java.util.Arrays;
import java.util.Collection;

import nc.isi.fragaria_adapter_rewrite.CityViews.Name;
import nc.isi.fragaria_adapter_rewrite.services.domain.AbstractEntity;
import nc.isi.fragaria_adapter_rewrite.services.domain.DsKey;
import nc.isi.fragaria_adapter_rewrite.services.domain.Embeded;
import nc.isi.fragaria_adapter_rewrite.services.domain.EntityMetadataFactory;
import nc.isi.fragaria_adapter_rewrite.services.domain.ObjectResolver;

import com.fasterxml.jackson.databind.node.ObjectNode;

@DsKey("rer")
public class PersonData extends AbstractEntity {
	public static final String NAME = "name";
	public static final String FIRST_NAME = "firstName";
	public static final String ADRESS = "adress";
	public static final String CITIES = "cities";
	public static final String CITY = "city";

	public PersonData(ObjectNode objectNode, ObjectResolver objectResolver,
			EntityMetadataFactory entityMetadataFactory) {
		super(objectNode, objectResolver, entityMetadataFactory);
	}

	public String getName() {
		return readProperty(String.class, NAME);
	}

	public void setName(String name) {
		writeProperty(NAME, name);
	}

	public Collection<String> getFirstName() {
		return readCollection(String.class, FIRST_NAME);
	}

	public void setFirstName(String... firstNames) {
		writeProperty(FIRST_NAME, Arrays.asList(firstNames));
	}

	public Adress getAdress() {
		return readProperty(Adress.class, ADRESS);
	}

	public void setAdress(Adress adress) {
		writeProperty(ADRESS, adress);
	}

	@Embeded(Name.class)
	public Collection<City> getCities() {
		return readCollection(City.class, CITIES);
	}

	public void setCities(Collection<City> cities) {
		writeProperty(CITIES, cities);
	}

	@Embeded(Name.class)
	public City getCity() {
		return readProperty(City.class, CITY);
	}

	public void setCity(City city) {
		writeProperty(CITY, city);
	}

}
